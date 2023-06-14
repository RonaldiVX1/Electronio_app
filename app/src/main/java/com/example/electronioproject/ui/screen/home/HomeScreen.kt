package com.example.electronioproject.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.electronioproject.R
import com.example.electronioproject.ui.component.ButtonShort
import com.example.electronioproject.ui.component.CardArticle
import com.example.electronioproject.ui.component.CardComponent
import com.example.electronioproject.ui.screen.article.ArticleViewModel
import com.example.electronioproject.ui.screen.component.ComponentViewModel
import com.example.electronioproject.ui.screen.utils.LoadingState
import com.example.electronioproject.ui.theme.Dark1
import com.example.electronioproject.ui.theme.ElectronioProjectTheme
import com.example.electronioproject.ui.theme.Grey

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    componentViewModel: ComponentViewModel = remember { ComponentViewModel() },
    articleViewModel: ArticleViewModel = remember { ArticleViewModel() },
    onNavigateToComponent: () -> Unit,
    onNavigateToArticle: () -> Unit,
    onNavigateToScanner: () -> Unit
) {
    val stateComponent by componentViewModel.loadingState.collectAsState()
    componentViewModel.getAllComponent()

    val stateArticle by articleViewModel.loadingState.collectAsState()
    articleViewModel.getAllArticle()

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {

        item {
            Banner(
                onNavigateToScanner = onNavigateToScanner
            )
        }
        item {

            SectionText(title = "Component")


        }
        when (stateComponent.status) {
            LoadingState.Status.SUCCESS -> {
                items(componentViewModel.homeSectionComponentList) { component ->
                    Row(
                        modifier = modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CardComponent(
                            title = component.name!!,
                            image = component.url_images,
                            modifier = modifier.clickable { onNavigateToComponent() })
                    }

                }
            }
            else -> {}
        }
        item {
            SectionText(title = "Article")
        }
        when (stateArticle.status) {
            LoadingState.Status.SUCCESS -> {
                items(articleViewModel.articleList) { article ->
                    Row(
                        modifier = modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CardArticle(
                            image = article.url_images,
                            title = article.title,
                            modifier = modifier.clickable { onNavigateToArticle() })
                    }

                }
            }
            else -> {}
        }
    }
}

@Composable
fun Banner(
    modifier: Modifier = Modifier,
    onNavigateToScanner: () -> Unit
) {
    Box() {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .height(280.dp)
                .padding(bottom = 18.dp),
            shape = RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp),
            backgroundColor = Dark1
        ) {}
        Column(
            modifier = modifier
                .padding(horizontal = 25.dp, vertical = 30.dp)
        ) {
            Text(
                text = stringResource(R.string.banner),
                color = Grey,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp
                ),
                modifier = modifier
                    .padding(bottom = 30.dp)
            )
            ButtonShort(text = "Try Now", onClick = {
                onNavigateToScanner()
            })

        }
    }
}

@Composable
fun SectionText(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        ),
        modifier = modifier
            .padding(top = 20.dp, bottom = 10.dp, start = 30.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ElectronioProjectTheme {

    }
}