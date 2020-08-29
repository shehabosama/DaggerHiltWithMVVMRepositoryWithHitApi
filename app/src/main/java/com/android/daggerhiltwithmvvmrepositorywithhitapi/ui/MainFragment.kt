package com.android.daggerhiltwithmvvmrepositorywithhitapi.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.android.daggerhiltwithmvvmrepositorywithhitapi.R
import com.android.daggerhiltwithmvvmrepositorywithhitapi.model.Blog
import com.android.daggerhiltwithmvvmrepositorywithhitapi.repository.MainRepository
import com.android.daggerhiltwithmvvmrepositorywithhitapi.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.contracts.ExperimentalContracts

@AndroidEntryPoint
class MainFragment constructor(
    private  val someString:String
) : Fragment(R.layout.fragment_main) {
    @ExperimentalCoroutinesApi
    private val viewModel : MainViewModel by viewModels()

    private val TAG = "App debug"
    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ${someString}")
        subscribeObserver()
        viewModel.SetStateEvent(MainStateEvent.GetBlogEvents)


    }

    private fun subscribeObserver(){
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState->
            when(dataState){
                is DataState.Success<List<Blog>> ->{
                    displayProgressBar(false)
                    appendBlogTitle(dataState.data)
                }
                is DataState.Error ->{
                    displayProgressBar(false)
                    dataState.exception.message?.let { displayError(it) }
                }
                is DataState.Loading ->{
                    displayProgressBar(true)

                }
            }
        })
    }

    private fun displayError(message: String){
        if(message!=null){
            text.text = message
        }else{
            text.text = "Unknown Error"
        }
    }
    private fun displayProgressBar(isDisplay:Boolean){
        progress_bar.visibility = if(isDisplay) View.VISIBLE else View.GONE
    }

    private fun appendBlogTitle(blogs:List<Blog>){
        val sb = StringBuilder()
        for(blog in blogs){
            sb.append(blog.title)
        }
        text.text = sb.toString()
    }
}