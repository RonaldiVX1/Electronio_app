package com.example.electronioproject.ui.screen.profile.profile_menu.terms_conditions

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
fun TermsAndConditionsScreen(
    modifier: Modifier = Modifier,
    viewModel: TermsAndConditionsViewModel = TermsAndConditionsViewModel()
) {
    val groupedTAC by viewModel.groupedTermsAndConditions.collectAsState()

    LazyColumn(
        modifier = modifier
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        item {
            Row(modifier = modifier.fillMaxWidth(),
            ) {
                Text(
                    text = stringResource(R.string.terms_and_condition),
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp),
                    modifier = modifier
                        .padding(vertical = 20.dp)
                )

                Divider(thickness = 2.dp)
            }

        }

        items(groupedTAC) { tac ->
            ContentTermsAndConditions(title = tac.title, description = tac.description)
        }
    }
}

@Composable
fun ContentTermsAndConditions(
    title: String,
    description: String
) {
    Column {
        Text(
            text = title,
            style = TextStyle(fontWeight = FontWeight.Medium, fontSize = 18.sp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
            style = TextStyle(fontWeight = FontWeight.Normal, fontSize = 14.sp)
        )
    }
}

@Preview
@Composable
fun TermsAndConditionSPreview() {
    TermsAndConditionsScreen()
}