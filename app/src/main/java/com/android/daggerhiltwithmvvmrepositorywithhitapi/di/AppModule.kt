package com.android.daggerhiltwithmvvmrepositorywithhitapi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object AppModule {
     @Singleton
     @Provides
     fun provideSomeString():String{
         return "there are some string"
     }
}