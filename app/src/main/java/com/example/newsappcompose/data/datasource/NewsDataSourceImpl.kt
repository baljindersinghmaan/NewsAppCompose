package com.example.newsappcompose.data.datasource

import com.example.newsappcompose.data.api.ApiInterface
import com.example.newsappcompose.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(private  val apiInterface: ApiInterface): NewsDataSource {
    override suspend fun getNewsHeadline(country: String): Response<NewsResponse> {
        return  apiInterface.getNewsHeadline(country)
    }

}