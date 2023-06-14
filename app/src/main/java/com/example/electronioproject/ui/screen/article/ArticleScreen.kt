package com.example.electronioproject.ui.screen.article

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.electronioproject.R
import com.example.electronioproject.ui.component.CardArticle
import com.example.electronioproject.ui.screen.utils.LoadingState

@Composable
fun ArticleScreen(
    modifier: Modifier = Modifier,
    viewModel: ArticleViewModel = remember { ArticleViewModel() },
    navigateToDetailArticle: (Long) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        LazyArticle(
            viewModel = viewModel,
            navigateToDetailArticle = navigateToDetailArticle,
            modifier = modifier
        )
    }
}


@Composable
fun LazyArticle(
    viewModel: ArticleViewModel,
    modifier: Modifier,
    navigateToDetailArticle: (Long) -> Unit
) {
    val state by viewModel.loadingState.collectAsState()
    viewModel.getAllArticle()

    when(state.status){
        LoadingState.Status.SUCCESS -> {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Text(
                        text = stringResource(R.string.list_article_header),
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp),
                        modifier = modifier
                            .padding(vertical = 20.dp)

                    )
                    Divider(thickness = 2.dp)

                }

                items(viewModel.articleList) { article ->
                   CardArticle(
                       image = article.url_images,
                       title = article.title,
                       modifier = modifier
                           .clickable { navigateToDetailArticle(article.id) }
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