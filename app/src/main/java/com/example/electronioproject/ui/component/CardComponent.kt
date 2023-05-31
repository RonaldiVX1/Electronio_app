package com.example.electronioproject.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.electronioproject.R
import com.example.electronioproject.ui.theme.ElectronioProjectTheme

@Composable
fun CardComponent(
    title: String,
    image: Int,
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
            Image(
                painter = painterResource(image),
                contentDescription = null,
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
        CardComponent(image = R.drawable.placeholder, title = "component name")
    }
}
