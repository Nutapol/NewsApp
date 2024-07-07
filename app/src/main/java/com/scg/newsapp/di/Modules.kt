package com.scg.newsapp.di


import com.scg.newsapp.network.NewsApi
import com.scg.newsapp.repositories.NewsRepository
import com.scg.newsapp.ui.newdetail.NewsDetailInteractor
import com.scg.newsapp.ui.newdetail.NewsDetailPresenter
import com.scg.newsapp.ui.newslist.NewsListInteractor
import com.scg.newsapp.ui.newslist.NewsListPresenter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }
}

val repositoryModule = module {
    single { NewsRepository(get()) }
}

val newsListModule = module {
    factory { NewsListInteractor(get()) }
    viewModel { NewsListPresenter(get()) }
}

val newsDetailModule = module {
    factory { NewsDetailInteractor() }
    viewModel { NewsDetailPresenter(get()) }
}

val appModules = listOf(networkModule, repositoryModule, newsListModule, newsDetailModule)
