package com.example.electronioproject.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.electronioproject.ui.theme.Dark4
import com.example.electronioproject.ui.theme.ElectronioProjectTheme
import com.example.electronioproject.ui.theme.White

@Composable
fun ButtonUniversal(
    modifier: Modifier,
    title: String,
    color: Color,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color
        ),
    modifier = modifier
        .width(290.dp)
        .height(60.dp)

    ) {
        Text(
            text = title,
            color = White,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            ),
        )
    }
}

@Preview
@Composable
fun ButtonPreview(modifier: Modifier = Modifier) {
    ElectronioProjectTheme {
        ButtonUniversal(
            modifier = modifier,
            title = "Register",
            color = Dark4
        ) {

        }
    }
}