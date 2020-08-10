package com.android.daggerhiltwithmvvmrepositorywithhitapi.retrofit

import retrofit2.http.GET

interface BlogRetrofitAPI {
    @GET("blogs")
    suspend fun get():List<BlogNetWorkEntity>
}