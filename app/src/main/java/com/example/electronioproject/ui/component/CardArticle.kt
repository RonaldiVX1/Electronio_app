package com.example.electronioproject.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.electronioproject.ui.theme.ElectronioProjectTheme

@Composable
fun CardArticle(
    image: String?,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(350.dp)
            .height(160.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        Column() {
            AsyncImage(
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .height(105.dp)
            )
            Text(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                ),
                modifier = modifier
                    .padding(10.dp)
            )
        }

    }
}

@Preview
@Composable
fun CardArticlePreview() {
    ElectronioProjectTheme() {
    }
}