package com.android.daggerhiltwithmvvmrepositorywithhitapi.repository

import com.android.daggerhiltwithmvvmrepositorywithhitapi.model.Blog
import com.android.daggerhiltwithmvvmrepositorywithhitapi.retrofit.BlogRetrofitAPI
import com.android.daggerhiltwithmvvmrepositorywithhitapi.retrofit.NetworkMapper
import com.android.daggerhiltwithmvvmrepositorywithhitapi.room.BlogDao
import com.android.daggerhiltwithmvvmrepositorywithhitapi.room.CashMapper
import com.android.daggerhiltwithmvvmrepositorywithhitapi.util.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class MainRepository @Inject constructor(private val BlogDao:BlogDao,private val retrofitAPI: BlogRetrofitAPI,private val cashMapper: CashMapper,private val networkMapper: NetworkMapper) {

    suspend fun  getBlog():Flow<DataState<List<Blog>>> = flow{
        emit(DataState.Loading)
        delay(1000)
        try {
            val nerWorkBlogs = retrofitAPI.get()
            val blogs = networkMapper.mapFromEntityList(nerWorkBlogs)
            for(blog in blogs){
                BlogDao.insert(cashMapper.mapToEntity(blog))
            }
            val cashedBlogs = BlogDao.get()
            emit(DataState.Success(cashMapper.mapFromEntityList(cashedBlogs)))
        }catch (e:Exception){
            emit(DataState.Error(e))
        }
    }
}