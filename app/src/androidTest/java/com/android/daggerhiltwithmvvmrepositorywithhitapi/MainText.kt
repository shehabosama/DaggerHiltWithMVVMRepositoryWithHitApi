package com.android.daggerhiltwithmvvmrepositorywithhitapi

import android.app.Activity
import android.app.LauncherActivity
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import com.android.daggerhiltwithmvvmrepositorywithhitapi.di.AppModule
import com.android.daggerhiltwithmvvmrepositorywithhitapi.ui.MainActivity
import com.android.daggerhiltwithmvvmrepositorywithhitapi.ui.MainFragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.hamcrest.CoreMatchers.containsString
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Singleton
@UninstallModules(AppModule::class)
@HiltAndroidTest
class MainText {
    @get :Rule
    var hiltRule=HiltAndroidRule(this)

    @Inject lateinit var someString:String
    @Before
    fun init(){
        hiltRule.inject()
    }
     @Test
     fun someTest(){
         assertThat(someString,containsString("TESTING"))
     }

        @Test
        fun mainFragmentTest(){

        }

    @Module
    @InstallIn(ApplicationComponent::class)
    object AppModule{
        @Singleton
        @Provides
        fun provideSomeString():String{
            return "TESTING"
        }
    }

}