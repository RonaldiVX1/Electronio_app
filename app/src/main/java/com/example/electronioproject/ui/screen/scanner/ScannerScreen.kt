package com.example.electronioproject.ui.screen.scanner

import android.content.ContentValues
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import coil.compose.rememberImagePainter
import com.example.electronioproject.BuildConfig
import com.example.electronioproject.R
import com.example.electronioproject.ui.component.ButtonShort
import com.example.electronioproject.ui.screen.utils.LoadingState
import com.example.electronioproject.ui.theme.Dark1
import com.example.electronioproject.ui.theme.Dark4
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.util.*

@Composable
fun ScannerScreen(
    modifier: Modifier = Modifier,
    viewModel: ScannerViewModel = remember { ScannerViewModel() },
    navigateToDetail: (Long) -> Unit
) {
    val context = LocalContext.current
    val file = context.createImageFile()
    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        BuildConfig.APPLICATION_ID + ".provider", file
    )

    val state by viewModel.loadingState.collectAsState()
    val stateComponent by viewModel.scannerComponent.collectAsState()
    var getFile: File? = null

    var capturedImageUri by remember {
        mutableStateOf<Uri>(Uri.EMPTY)
    }

    val cameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
            capturedImageUri = uri
        }

    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
            capturedImageUri = it!!
        }


    fun uploadImage() {

        getFile = uriToFile(capturedImageUri, context)
        if (getFile != null) {
            val file = reduceFileImage(getFile as File)
            val requestImageFile = file.asRequestBody("image/jpeg".toMediaTypeOrNull())
            val imageMultipart: MultipartBody.Part = MultipartBody.Part.createFormData(
                "file",
                file.name,
                requestImageFile
            )
            Log.e(ContentValues.TAG, file.toString() + "file gaming")

            viewModel.scanComponent(imageMultipart)
            when (state.status) {

                LoadingState.Status.SUCCESS -> {
                    Log.e(ContentValues.TAG, stateComponent!!.id.toString())
                    navigateToDetail(stateComponent!!.id!!)
                }
                LoadingState.Status.LOADING -> {

                }

                else -> {

                }
            }


        } else {
            Log.e(ContentValues.TAG, "image null")
        }

    }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        if (capturedImageUri.path?.isNotEmpty() == true) {
            Image(
                modifier = Modifier
                    .width(450.dp)
                    .height(300.dp)
                    .padding(16.dp, 8.dp),
                painter = rememberImagePainter(capturedImageUri),
                contentDescription = null
            )
        } else {
            ImagePreview(modifier = modifier)
        }

        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.Top
        ) {
            ButtonOption(
                modifier = modifier
                    .clickable { cameraLauncher.launch(uri) },
                title = stringResource(R.string.camera_text),
                icon = R.drawable.ic_camera,
            )
            ButtonOption(
                modifier = modifier
                    .clickable { galleryLauncher.launch("image/*") },
                title = stringResource(R.string.gallery_text),
                icon = R.drawable.ic_gallery
            )
        }
        ButtonShort(
            text = stringResource(R.string.button_scan),
            onClick = {
                uploadImage()

            },
            modifier = modifier.padding(vertical = 20.dp)
        )
    }


}

@Composable
fun ImagePreview(
    modifier: Modifier,

    ) {
    Image(
        painter = painterResource(R.drawable.placeholder),
        contentDescription = null,
        modifier = modifier
            .width(450.dp)
            .height(300.dp)
            .padding(vertical = 20.dp, horizontal = 10.dp)
    )
}

@Composable
fun ButtonRowSection(
    modifier: Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        ButtonOption(
            modifier = modifier,
            title = stringResource(R.string.camera_text),
            icon = R.drawable.ic_camera,
        )
        ButtonOption(
            modifier = modifier,

            title = stringResource(R.string.gallery_text),
            icon = R.drawable.ic_gallery
        )


    }
}

@Composable
fun ButtonOption(
    modifier: Modifier,
    title: String,
    icon: Int,
) {
    Button(
        modifier = modifier,
        onClick = {},
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Dark4
        )
    ) {
        Column(
            modifier = modifier
                .padding(vertical = 15.dp, horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter =
                painterResource(icon),
                contentDescription = "open camera",
                modifier = modifier
                    .size(70.dp)
                    .padding(bottom = 20.dp)

            )
            Text(
                text = title,
                style = TextStyle(fontWeight = FontWeight.Bold),
                color = Dark1
            )
        }
    }
}

@Preview
@Composable
fun PreviewScannerScreen() {
}