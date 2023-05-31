package com.example.electronioproject.ui.screen.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.electronioproject.R
import com.example.electronioproject.ui.component.ButtonUniversal
import com.example.electronioproject.ui.screen.utils.LoadingState
import com.example.electronioproject.ui.theme.Dark1
import com.example.electronioproject.ui.theme.Dark4
import com.example.electronioproject.ui.theme.ElectronioProjectTheme
import com.example.electronioproject.ui.theme.Grey

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = LoginViewModel()
) {


    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TitleLogin(modifier = modifier)
        LoginBox(viewModel = viewModel)
        RegisterSection(modifier = modifier)
    }
}


@Composable
fun LoginBox(
    modifier: Modifier = Modifier,
    viewModel : LoginViewModel
) {
    val state by viewModel.loadingState.collectAsState()

    var inputEmail by remember { mutableStateOf("") }
    var inputPassword by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = modifier
                .width(340.dp)
                .height(300.dp),
            backgroundColor = Dark1,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = modifier
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                FieldSection(
                    title = stringResource(R.string.email),
                    textPlaceholder = stringResource(R.string.placeholder_email),
                    inputText = inputEmail,
                    onValueChange = { newInput ->
                        inputEmail = newInput
                    },
                    modifier = modifier
                )
                PasswordSection(
                    title = stringResource(R.string.password),
                    textPlaceholder = stringResource(R.string.placeholder_password),
                    inputText = inputPassword,
                    onValueChange = { newInput ->
                        inputPassword = newInput
                    },
                    modifier = modifier
                        .padding(top = 15.dp)
                )
            }

        }
        ButtonUniversal(
            modifier = modifier
                .padding(top = 20.dp, bottom = 40.dp),
            title = stringResource(R.string.login_title),
            color = Dark4,
            onClick = {viewModel.signInWithEmailAndPassword(inputEmail, inputPassword)}
        )
        when(state.status){
            LoadingState.Status.SUCCESS -> {
                Text(text = "Success")
            }
            LoadingState.Status.FAILED -> {
                Text(text = state.msg ?: "Error")
            }
            else -> {}
        }
    }
}

@Composable
fun FieldSection(
    title: String,
    textPlaceholder: String,
    inputText: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            color = Grey,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            ),
            modifier = modifier
                .padding(bottom = 10.dp)
        )
        TextField(
            value = inputText,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Grey,
            ),
            placeholder = {
                Text(text = textPlaceholder)
            },
            shape = RoundedCornerShape(5.dp)
        )
    }
}

@Composable
fun PasswordSection(
    title: String,
    textPlaceholder: String,
    inputText: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            color = Grey,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            ),
            modifier = modifier
                .padding(bottom = 10.dp)
        )
        TextField(
            value = inputText,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Grey,
            ),
            visualTransformation = PasswordVisualTransformation(),
            placeholder = {
                Text(text = textPlaceholder)
            },
            shape = RoundedCornerShape(5.dp)
        )
    }
}



@Composable
fun TitleLogin(modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.login_title),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )
        Text(
            text = stringResource(R.string.login_subtitle),
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            ),
            modifier = modifier
                .padding(
                    top = 10.dp,
                    bottom = 45.dp
                )
        )
    }
}


@Composable
fun RegisterSection(modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.register_subtitle),
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            ),

        )
        Text(
            text = stringResource(R.string.register_title),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            ),
            modifier = modifier
                .clickable { }
        )
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    ElectronioProjectTheme {
        LoginScreen()
    }
}