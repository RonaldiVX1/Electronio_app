package com.example.electronioproject.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.KeyEventDispatcher.Component
import com.example.electronioproject.R
import com.example.electronioproject.ui.component.ButtonTryNow
import com.example.electronioproject.ui.component.CardArticle
import com.example.electronioproject.ui.component.CardComponent
import com.example.electronioproject.ui.theme.Dark1
import com.example.electronioproject.ui.theme.ElectronioProjectTheme
import com.example.electronioproject.ui.theme.Grey

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(        modifier = modifier
        .verticalScroll(rememberScrollState())) {
        Banner()
        HomeContent()
    }


}


@Composable
fun HomeContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(horizontal = 20.dp)
    ) {
        SectionText(title = "Component")
        CardRow()
        SectionText(title = "Article")
        ArticleColumn()
    }

}


@Composable
fun CardRow() {
    CardComponent(title = "Component Name", image = R.drawable.placeholder)
    CardComponent(title = "Component Name", image = R.drawable.placeholder)
}

@Composable
fun ArticleColumn(modifier: Modifier = Modifier) {
    Column() {
        CardArticle(image = R.drawable.placeholder, title = "Article Title")
        CardArticle(image = R.drawable.placeholder, title = "Article Title")
    }
}

@Composable
fun Banner(modifier: Modifier = Modifier) {
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
            ButtonTryNow(text = "Try Now", onClick = {})

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
            .padding(vertical = 8.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ElectronioProjectTheme {
        HomeScreen()
    }
}