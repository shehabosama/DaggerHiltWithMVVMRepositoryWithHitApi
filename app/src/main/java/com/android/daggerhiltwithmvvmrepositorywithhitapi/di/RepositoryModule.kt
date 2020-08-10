package com.android.daggerhiltwithmvvmrepositorywithhitapi.di

import com.android.daggerhiltwithmvvmrepositorywithhitapi.repository.MainRepository
import com.android.daggerhiltwithmvvmrepositorywithhitapi.retrofit.BlogRetrofitAPI
import com.android.daggerhiltwithmvvmrepositorywithhitapi.retrofit.NetworkMapper
import com.android.daggerhiltwithmvvmrepositorywithhitapi.room.BlogDao
import com.android.daggerhiltwithmvvmrepositorywithhitapi.room.CashMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {
    @Singleton
    @Provides
    fun provideMainRepository(blogDao: BlogDao,retrofitAPI: BlogRetrofitAPI,cashMapper: CashMapper,networkMapper: NetworkMapper):MainRepository{
        return MainRepository(blogDao,retrofitAPI,cashMapper,networkMapper)
    }
}