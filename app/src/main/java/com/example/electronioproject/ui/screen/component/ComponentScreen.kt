package com.example.electronioproject.ui.screen.component


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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.electronioproject.R
import com.example.electronioproject.ui.component.CardComponent
import com.example.electronioproject.ui.screen.utils.LoadingState


@Composable
fun ComponentScreen(
    modifier: Modifier = Modifier,
    viewModel: ComponentViewModel = remember { ComponentViewModel() },
    navigateToDetail: (Long) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LazyComponent(
            viewModel = viewModel,
            modifier = modifier,
            navigateToDetail = navigateToDetail
        )
    }
}

@Composable
fun LazyComponent(
    viewModel: ComponentViewModel,
    modifier: Modifier,
    navigateToDetail: (Long) -> Unit

) {
    val state by viewModel.loadingState.collectAsState()

    LaunchedEffect(viewModel.loadingState) {
        viewModel.getAllComponent()
    }


    when (state.status) {
        LoadingState.Status.SUCCESS -> {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                        Text(
                            text = stringResource(R.string.list_component_header),
                            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp),
                            modifier = modifier
                                .padding(vertical = 20.dp)
                        )

                    Divider(thickness = 2.dp)

                }

                items(viewModel.componentList) { component ->
                    CardComponent(
                        title = component.name!!,
                        image = component.url_images,
                        modifier = modifier
                            .clickable { navigateToDetail(component.id!!) }
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

@Preview
@Composable
fun ComponentScreenPreview() {

}