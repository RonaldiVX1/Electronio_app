package com.example.electronioproject.ui.screen.detail_component

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.electronioproject.R
import com.example.electronioproject.ui.screen.utils.LoadingState
import com.example.electronioproject.ui.theme.Dark1
import com.example.electronioproject.ui.theme.Dark5
import com.example.electronioproject.ui.theme.ElectronioProjectTheme
import com.example.electronioproject.ui.theme.Green


@Composable
fun DetailComponentScreen(
    modifier: Modifier = Modifier,
    componentId: Long,
    viewModel: DetailComponentViewModel = remember { DetailComponentViewModel(componentId)}

) {
    val state by viewModel.loadingState.collectAsState()
    val stateComponent by viewModel.component.collectAsState()


    SideEffect {
        viewModel.getComponentById()
    }

    when (state.status) {
        LoadingState.Status.SUCCESS -> {
            val tempComponent = stateComponent
            Log.e(ContentValues.TAG, tempComponent.toString())
            if (tempComponent != null) {
                Log.e(ContentValues.TAG, tempComponent.toString())
                Column(modifier = modifier) {
                    DetailComponentContent(
                        modifier = modifier,
                        image = tempComponent.url_images!!,
                        nameComponent = tempComponent.name!!,
                        description = tempComponent.description!!,
                        functionComponent = tempComponent.function!!
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
fun DetailComponentContent(
    modifier: Modifier,
    image: String,
    nameComponent: String,
    description: String,
    functionComponent: String,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        ImageComponent(modifier = modifier, image = image)
        ComponentName(nameComponent = nameComponent, modifier = modifier)
        DetailDescription(modifier = modifier, description = description)
        DetailFunction(modifier = modifier, function = functionComponent)
    }
}


@Composable
fun ComponentName(
    nameComponent: String,
    modifier: Modifier
) {
    Text(
        text = nameComponent,
        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 32.sp),
        modifier = modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
    )
}


@Composable
fun ImageComponent(
    modifier: Modifier,
    image: String,

    ) {
    AsyncImage(
        model = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .width(500.dp)
            .height(300.dp)
            .padding(horizontal = 30.dp, vertical = 15.dp)
    )
}


@Composable
fun DetailDescription(
    modifier: Modifier,
    description: String,

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
            Text(
                text = stringResource(R.string.description_text),
                color = Dark1,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ),
                modifier = modifier.padding(vertical = 15.dp)
            )
            Text(text = description,color = Dark1,)

        }
    }
}

@Composable
fun DetailFunction(
    modifier: Modifier,
    function: String,

    ) {
    Card(
        backgroundColor = Green,
        modifier = modifier
            .padding(horizontal = 20.dp, vertical = 20.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(modifier = modifier
            .padding(horizontal = 15.dp, vertical = 20.dp)) {
            Text(
                text = stringResource(R.string.function_text),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ),
                modifier = modifier.padding(vertical = 10.dp)
            )
            Text(text = function)

        }
    }
}


@Preview
@Composable
fun DetailComponentScreenPreview() {
    ElectronioProjectTheme {

    }
}