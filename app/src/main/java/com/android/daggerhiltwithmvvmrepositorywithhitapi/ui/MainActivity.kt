package com.android.daggerhiltwithmvvmrepositorywithhitapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.android.daggerhiltwithmvvmrepositorywithhitapi.R
import com.android.daggerhiltwithmvvmrepositorywithhitapi.model.Blog
import com.android.daggerhiltwithmvvmrepositorywithhitapi.util.DataState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG:String = "AppDebug"
    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        subscribeObserver()
        viewModel.SetStateEvent(MainStateEvent.GetBlogEvents)

    }

    private fun subscribeObserver(){
        viewModel.dataState.observe(this, Observer { dataState->
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