package com.scg.newsapp.network

class NewsService(private val newsApi: NewsApi) {
    suspend fun getTopHeadlines(country: String, apiKey: String) = newsApi.getTopHeadlines(country, apiKey)
}