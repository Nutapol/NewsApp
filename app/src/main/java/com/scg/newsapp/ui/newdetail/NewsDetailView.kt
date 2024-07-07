package com.scg.newsapp.ui.newdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier

@Composable
fun NewsDetailView(articleTitle: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = articleTitle, style = MaterialTheme.typography.titleLarge)
        // Add more detail views as needed
    }
}
