package com.example.newsappcompose.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsappcompose.data.entity.NewsResponse
import com.example.newsappcompose.ui.components.Loader
import com.example.newsappcompose.ui.viewmodel.NewsViewModel
import com.example.untilities.ResourceState

@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {
    val news by newsViewModel.news.collectAsState()
    Surface(modifier = Modifier.fillMaxSize()) {
        when(news){
            is ResourceState.Loading -> {
                Loader()
            }
            is ResourceState.Success -> {
                val response =  (news as ResourceState.Success).data
                Log.d("Baljinder", response.totalResults.toString())

            }

            is ResourceState.Error -> {
                Log.d("Baljinder", (news as ResourceState.Error).toString())

            }
        }
    }
}