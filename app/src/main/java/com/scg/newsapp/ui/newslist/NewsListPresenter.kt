package com.scg.newsapp.ui.newslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scg.newsapp.repositories.NewsRepository
import kotlinx.coroutines.launch

class NewsListPresenter(private val interactor: NewsListInteractor) : ViewModel() {

    val articles = interactor.articles

    fun getTopHeadlines(country: String, apiKey: String) {
        viewModelScope.launch {
            interactor.getTopHeadlines(country, apiKey)
        }
    }
}