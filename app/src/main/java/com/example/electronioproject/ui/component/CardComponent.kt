package com.example.electronioproject.ui.component


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun CardComponent(
    title: String,
    image: String?,
    modifier: Modifier = Modifier

) {
    Card(
        modifier = modifier
            .width(340.dp)
            .height(100.dp),
        shape = RoundedCornerShape(5.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically

        ) {
            AsyncImage(
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxHeight()
                    .width(100.dp)
            )
            Text(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                ),
                modifier = modifier
                    .padding(start = 10.dp)
            )

        }


    }
}

@Preview
@Composable
fun CardComponentPreview() {
    ElectronioProjectTheme {
        CardComponent(title = "Component Name", image = "https://placehold.co/600x400")

    }
}
