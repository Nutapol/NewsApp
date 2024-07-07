package com.scg.newsapp.ui.newslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.scg.newsapp.models.Article
import com.scg.newsapp.repositories.NewsRepository

class NewsListInteractor(private val newsRepository: NewsRepository) {

    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> get() = _articles

    suspend fun getTopHeadlines(country: String, apiKey: String) {
        val response = newsRepository.getTopHeadlines(country, apiKey)
        if (response.isSuccessful) {
            _articles.postValue(response.body()?.articles ?: emptyList())
        }
    }
}
