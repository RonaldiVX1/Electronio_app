package com.example.electronioproject.ui.screen.profile.profile_menu.help_center

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.electronioproject.R

@Composable
fun HelpCenterScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        item {
            Row(
                modifier = modifier.fillMaxWidth(),
            ) {
                Text(
                    text = stringResource(R.string.help_center),
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp),
                    modifier = modifier
                        .padding(vertical = 20.dp)
                )

                Divider(thickness = 2.dp)
            }

        }

        item {
            Text(
                text = "If you can't find the answers you're looking for or need further assistance, please reach out to our support team. You can contact us through electronio@gmail.com\n" +
                        "\n" +
                        "Please note that our support team operates during working hours. We strive to respond to inquiries as quickly as possible, and we appreciate your patience.\n" +
                        "\n" +
                        "Remember to check our Help Center frequently, as we update it with new information and resources to enhance your Electronio experience.\n" +
                        "\n" +
                        "Thank you for choosing Electronio!",
                textAlign = TextAlign.Justify,
                style = TextStyle(fontSize = 16.sp)
            )
        }


    }
}

@Preview
@Composable
fun HelpCenterPreview() {
    HelpCenterScreen()
}

