package com.example.newsappcompose.data.api

import com.example.newsappcompose.data.entity.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("v2/top-headlines")
    fun getNewsHeadline(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = "18f9401e671f4de59bc149855bff7cfc",
    ): Response<NewsResponse>

   // https://newsapi.org/v2/top-headlines?country=us&apiKey=18f9401e671f4de59bc149855bff7cfc
}