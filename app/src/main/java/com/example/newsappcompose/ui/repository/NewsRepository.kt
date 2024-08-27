package com.example.newsappcompose.ui.repository

import com.example.newsappcompose.data.datasource.NewsDataSource
import com.example.newsappcompose.data.entity.NewsResponse
import com.example.untilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsDataSource: NewsDataSource) {

    /*suspend fun getHeadLines(country : String): Response<NewsResponse> {
        return newsDataSource.getNewsHeadline(country)
    }*/

    suspend fun getHeadLines(country : String): Flow<ResourceState<NewsResponse>> {
        return flow {
            emit(ResourceState.Loading())
            val response = newsDataSource.getNewsHeadline(country)

            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            }
            else {
                emit(ResourceState.Error("Some Error happened in api"))
            }
        }.catch { e->
            emit(ResourceState.Error(e.localizedMessage ?:"Error in flow"))
        }

    }

}