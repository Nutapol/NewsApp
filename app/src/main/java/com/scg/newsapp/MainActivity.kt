package com.scg.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.scg.newsapp.theme_app.NewsAppTheme
import com.scg.newsapp.ui.newdetail.NewsDetailView
import com.scg.newsapp.ui.newslist.NewsListView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "newsList") {
                    composable("newsList") { NewsListView(navController) }
                    composable("newsDetail/{articleTitle}") { backStackEntry ->
                        val articleTitle = backStackEntry.arguments?.getString("articleTitle")
                        articleTitle?.let { NewsDetailView(articleTitle) }
                    }
                }
            }
        }
    }
}
