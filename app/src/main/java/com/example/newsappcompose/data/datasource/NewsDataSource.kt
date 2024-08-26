package com.example.newsappcompose.data.datasource

import com.example.newsappcompose.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {

    suspend fun getNewsHeadline(
        country: String,
        ): Response<NewsResponse>
}