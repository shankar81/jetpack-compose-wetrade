package com.example.androiddevchallenge

import android.graphics.drawable.VectorDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.onSurface) {
                    LoginContent()
                }
            }
        }
    }
}

@Composable
fun LoginContent() {
    Column(modifier = Modifier.fillMaxSize()) {
        LoginBackground(modifier = Modifier.weight(0.5F)) {
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
        LoginForm(modifier = Modifier.weight(0.5F))
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
fun LoginForm(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    MyTheme {
        LoginContent()
    }
}