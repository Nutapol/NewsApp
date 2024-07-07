package com.scg.newsapp.ui.newslist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.scg.newsapp.models.Article

@Composable
fun NewsListView(navController: NavController, viewModel: NewsListPresenter = hiltViewModel()) {
    val articles by viewModel.articles.collectAsState(initial = emptyList())

    LazyColumn {
        items(articles) { article ->
            NewsItem(articles[article]) {
                navController.navigate("newsDetail/${articles[article].title}")
            }
        }
    }

    viewModel.getTopHeadlines("us", "7b0b517d400d479d812c6958fc6d88a7")
}

@Composable
fun NewsItem(article: Article, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = article.urlToImage),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(end = 8.dp),
            contentScale = ContentScale.Crop
        )
        Column {
            Text(text = article.title, style = MaterialTheme.typography.titleMedium)
            Text(text = article.description ?: "", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
