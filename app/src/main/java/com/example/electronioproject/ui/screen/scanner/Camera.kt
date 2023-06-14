package com.example.electronioproject.ui.screen.scanner

import android.net.Uri
import android.widget.Toast
import androidx.camera.core.ImageCapture
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ujizin.camposer.CameraPreview
import com.ujizin.camposer.state.ImageCaptureResult
import com.ujizin.camposer.state.rememberCameraState


@Composable
fun CameraScreen(
    modifier: Modifier = Modifier,
//    navigateBackToScanner : (Uri) -> Unit
) {
    val cameraState = rememberCameraState()
    val context = LocalContext.current

    val photoFile = createTempFile(context)
    val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

    CameraPreview(
        cameraState = cameraState,

    ) {
        Box(
        ) {
            Row(
                modifier = modifier
                    .fillMaxSize()
                    .padding(bottom = 40.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center

            ) {
                Button(
                    modifier = modifier
                        .size(80.dp)
                    ,
                    shape = CircleShape,
                    onClick = {
                        cameraState.takePicture(photoFile) { result ->
                            if (result is ImageCaptureResult.Success) {
                                val savedUri = result.savedUri ?: Uri.fromFile(photoFile)
//                                navigateBackToScanner(savedUri)
                                // result.savedUri might be useful to you
                                Toast.makeText(context, "Success!", Toast.LENGTH_LONG).show()
                            }
                        }
                    }) {

                }
            }

        }
    }
}


@Preview
@Composable
fun PreviewCamera() {
}