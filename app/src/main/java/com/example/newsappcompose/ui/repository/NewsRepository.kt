package com.example.newsappcompose.ui.repository

import com.example.newsappcompose.data.datasource.NewsDataSource
import com.example.newsappcompose.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsDataSource: NewsDataSource) {
    suspend fun getHeadLines(country : String): Response<NewsResponse> {
        return newsDataSource.getNewsHeadline(country)
    }
}