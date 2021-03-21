package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate

@Composable
fun Login(navController: NavHostController) {
    // A surface container using the 'background' color from the theme
    Surface(color = MaterialTheme.colors.surface) {
        LoginContent(navController)
    }
}

@Composable
fun LoginContent(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        LoginBackground(modifier = Modifier.weight(0.6F)) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 100.dp)
            ) {
                Text(
                    text = "Welcome back",
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onBackground,
                    textAlign = TextAlign.Center
                )
            }
        }
        LoginForm(
            modifier = Modifier
                .weight(0.4F)
                .padding(16.dp)
                .fillMaxSize(),
            navController
        )
    }
}

@Composable
fun LoginBackground(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.login_bg),
            modifier = Modifier.fillMaxSize(),
            contentDescription = "Login",
            contentScale = ContentScale.FillBounds
        )
        content()
    }
}

@Composable
fun LoginForm(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginInput(
            onValueChange = {},
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.mail_outline),
                    contentDescription = "Email"
                )
            },
            placeholder = "Email address"
        )
        LoginInput(
            onValueChange = {},
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.password),
                    contentDescription = "Password"
                )
            },
            placeholder = "Password",
            visualTransformation = PasswordVisualTransformation()
        )
        WeTradeButton(
            label = "LOG IN", modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            onClick = { navController.navigate("Dashboard") }
        )
    }
}

@Composable
fun LoginInput(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable () -> Unit,
    placeholder: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(),
        value = value, onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface
            )
        },
        leadingIcon = leadingIcon,
        visualTransformation = visualTransformation,
    )
}