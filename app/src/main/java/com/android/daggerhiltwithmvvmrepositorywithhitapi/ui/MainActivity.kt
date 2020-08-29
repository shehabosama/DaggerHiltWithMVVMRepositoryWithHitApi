package com.android.daggerhiltwithmvvmrepositorywithhitapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.daggerhiltwithmvvmrepositorywithhitapi.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG:String = "AppDebug"
//    private val viewModel : MainViewModel by viewModels()
//    @Inject
//    lateinit var fragmentFactory: MainFragmentFactoryClass // this normal way to use the fragment factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        subscribeObserver()
//        viewModel.SetStateEvent(MainStateEvent.GetBlogEvents)

//        supportFragmentManager.fragmentFactory = fragmentFactory
//        supportFragmentManager.beginTransaction().replace(R.id.main_fragment_container, // this normal way to use the fragment factory
//            MainFragment::class.java,null).commit()


    }

//    private fun subscribeObserver(){
//        viewModel.dataState.observe(this, Observer { dataState->
//            when(dataState){
//                is DataState.Success<List<Blog>> ->{
//                    displayProgressBar(false)
//                    appendBlogTitle(dataState.data)
//                }
//                is DataState.Error ->{
//                    displayProgressBar(false)
//                    dataState.exception.message?.let { displayError(it) }
//                }
//                is DataState.Loading ->{
//                    displayProgressBar(true)
//
//                }
//            }
//        })
//    }
//
//    private fun displayError(message: String){
//        if(message!=null){
//            text.text = message
//        }else{
//            text.text = "Unknown Error"
//        }
//    }
//    private fun displayProgressBar(isDisplay:Boolean){
//        progress_bar.visibility = if(isDisplay) View.VISIBLE else View.GONE
//    }
//
//    private fun appendBlogTitle(blogs:List<Blog>){
//        val sb = StringBuilder()
//        for(blog in blogs){
//            sb.append(blog.title)
//        }
//        text.text = sb.toString()
//    }
}