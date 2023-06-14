package com.example.electronioproject.ui.screen.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.electronioproject.R
import com.example.electronioproject.ui.component.ButtonUniversal
import com.example.electronioproject.ui.screen.utils.LoadingState
import com.example.electronioproject.ui.theme.Dark1
import com.example.electronioproject.ui.theme.ElectronioProjectTheme
import com.example.electronioproject.ui.theme.Red
import com.example.electronioproject.ui.theme.White

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = ProfileViewModel(),
    onNavigateToTAC: () -> Unit,
    onNavigateToPAP: () -> Unit,
    onNavigateToHelpCenter: () -> Unit,
    onNavigateToLogin: () -> Unit

) {
    Column {

        Banner(
            modifier = modifier,
            viewModel = viewModel
        )
        MenuSection(
            modifier = modifier,
            viewModel = viewModel,
            onNavigateToTAC = onNavigateToTAC,
            onNavigateToPAP = onNavigateToPAP,
            onNavigateToHelpCenter = onNavigateToHelpCenter,
            onNavigateToLogin = { onNavigateToLogin() }
        )
    }
}

@Composable
fun Banner(
    modifier: Modifier,
    viewModel: ProfileViewModel,
) {
    Box() {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(bottom = 18.dp),
            shape = RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp),
            backgroundColor = Dark1
        ) {}
        Column(
            modifier = modifier
                .padding(horizontal = 25.dp, vertical = 10.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = modifier
                    .size(144.dp),
                shape = CircleShape,
                backgroundColor = White
            ) {

            }
            Text(
                text = if (viewModel.getUsername() != null) {
                    viewModel.getUsername()!!
                } else {
                    stringResource(R.string.username)
                },
                color = White,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = modifier
                    .padding(top = 30.dp)
            )
        }
    }
}

@Composable
fun MenuSection(
    modifier: Modifier,
    viewModel: ProfileViewModel,
    onNavigateToTAC: () -> Unit,
    onNavigateToPAP: () -> Unit,
    onNavigateToHelpCenter: () -> Unit,
    onNavigateToLogin: () -> Unit,
) {
    val state by viewModel.loadingState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ButtonUniversal(
            modifier = modifier
                .padding(top = 15.dp),
            title = stringResource(R.string.terms_and_condition),
            color = Dark1
        ) { onNavigateToTAC() }
        ButtonUniversal(
            modifier = modifier
                .padding(top = 15.dp),
            title = stringResource(R.string.privacy_policy),
            color = Dark1
        ) { onNavigateToPAP() }
        ButtonUniversal(
            modifier = modifier
                .padding(top = 15.dp),
            title = stringResource(R.string.help_center),
            color = Dark1
        ) { onNavigateToHelpCenter() }
        ButtonUniversal(
            modifier = modifier
                .padding(vertical = 25.dp),
            title = stringResource(R.string.log_out),
            color = Red,
            onClick = { viewModel.logOut() }
        )
        when (state.status) {
            LoadingState.Status.SUCCESS -> {
                onNavigateToLogin()
            }
            LoadingState.Status.FAILED -> {
                Text(text = stringResource(R.string.log_out_failed))
            }
            else -> {}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen(modifier: Modifier = Modifier) {
    ElectronioProjectTheme {
    }
}