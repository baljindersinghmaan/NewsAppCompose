package com.example.newsappcompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappcompose.data.entity.NewsResponse
import com.example.newsappcompose.ui.repository.NewsRepository
import com.example.untilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {

    init {
        getNews("us")
    }

    private val _news : MutableStateFlow<ResourceState<NewsResponse>> = MutableStateFlow(ResourceState.Loading())
    val news : StateFlow<ResourceState<NewsResponse>> = _news

    fun getNews(country: String){
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getHeadLines(country).collectLatest { newsResponse ->
                _news.value = newsResponse

            }
        }
    }
}