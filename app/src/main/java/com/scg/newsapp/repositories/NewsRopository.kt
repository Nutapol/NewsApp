package com.scg.newsapp.repositories

import com.scg.newsapp.network.NewsService

class NewsRepository(private val newsService: NewsService) {
    suspend fun getTopHeadlines(country: String, apiKey: String) = newsService.getTopHeadlines(country, apiKey)
}