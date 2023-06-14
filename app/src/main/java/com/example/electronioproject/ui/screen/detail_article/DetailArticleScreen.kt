package com.example.electronioproject.ui.screen.detail_article

import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.electronioproject.ui.screen.utils.LoadingState
import com.example.electronioproject.ui.theme.Dark1
import com.example.electronioproject.ui.theme.Dark5


@Composable
fun DetailArticleScreen(
    modifier: Modifier = Modifier,
    articleId: Long,
    viewModel: DetailArticleViewModel = remember { DetailArticleViewModel(articleId) }
) {
    val state by viewModel.loadingState.collectAsState()
    val stateArticle by viewModel.detailArticle.collectAsState()

    SideEffect {
        viewModel.getArticleById()
    }

    when (state.status) {
        LoadingState.Status.SUCCESS -> {
            val tempArticle = stateArticle
            if (stateArticle != null) {
                Log.e(ContentValues.TAG, stateArticle.toString())
                Column(modifier = modifier) {
                   DetailArticleContent(
                       articleTitle = tempArticle!!.title!!,
                       articleDate = tempArticle.date!!,
                       articleImage = tempArticle.url_images!!,
                       articleDescription = tempArticle.description!!,
                       modifier = modifier
                   )
                }
            }
        }
        LoadingState.Status.LOADING -> {
            CircularProgressIndicator()
        }
        else -> {}
    }




}

@Composable
fun DetailArticleContent(
    articleTitle : String,
    articleDate : String,
    articleImage : String,
    articleDescription: String,
    modifier: Modifier
) {
    Column(modifier = modifier
        .verticalScroll(rememberScrollState())
    ) {
        ArticleTitle(titleArticle = articleTitle, dateArticle = articleDate, modifier = modifier)
        ImageArticle(image = articleImage, modifier = modifier)
        ArticleDescription(description = articleDescription,modifier = modifier,  )
    }
}




@Composable
fun ArticleTitle(
    titleArticle: String,
    dateArticle : String,
    modifier: Modifier
) {
    Column() {
        Text(
            text = titleArticle,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp),
            modifier = modifier
                .padding(horizontal = 20.dp, vertical = 10.dp)
        )

        Text(
            text = dateArticle,
            style = TextStyle(fontWeight = FontWeight.Light, fontSize = 14.sp),
            modifier = modifier
                .padding(horizontal = 20.dp, vertical = 5.dp)
        )
    }

}


@Composable
fun ImageArticle(
    image: String,
    modifier: Modifier,
    ) {
    AsyncImage(
        model = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .width(500.dp)
            .height(300.dp)
            .padding(horizontal = 20.dp, vertical = 10.dp)
    )
}

@Composable
fun ArticleDescription(

    description: String,
    modifier: Modifier,
    ) {
    Card(
        backgroundColor = Dark5,
        modifier = modifier
            .padding(horizontal = 20.dp, vertical = 20.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(modifier = modifier
            .padding(horizontal = 15.dp , vertical = 20.dp)) {
            Text(text = description,color = Dark1,)

        }
    }
}