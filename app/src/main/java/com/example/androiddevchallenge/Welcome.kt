package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

enum class ButtonType {
    PRIMARY,
    SECONDARY
}

class Welcome : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    WelcomeBackground {
                        WelcomeContent()
                    }
                }
            }
        }
    }
}


@Composable
fun WelcomeContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxSize()
        ) {
            WeTradeButton(
                modifier = Modifier
                    .weight(0.5F)
                    .padding(end = 8.dp),
                label = "GET STARTED"
            )
            WeTradeButton(
                modifier = Modifier
                    .weight(0.5F)
                    .padding(start = 8.dp)
                    .border(
                        1.dp,
                        color = MaterialTheme.colors.primary,
                        shape = RoundedCornerShape(50)
                    ),
                label = "LOG IN",
                type = ButtonType.SECONDARY
            )
        }
    }
}

@Composable
fun WeTradeButton(
    modifier: Modifier = Modifier,
    label: String,
    type: ButtonType = ButtonType.PRIMARY
) {
    Button(
        modifier = modifier,
        onClick = {},
        contentPadding = PaddingValues(16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (type == ButtonType.PRIMARY) MaterialTheme.colors.primary else Color.Transparent
        ),
        shape = RoundedCornerShape(50)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.button,
            color = if (type == ButtonType.PRIMARY) MaterialTheme.colors.onPrimary else MaterialTheme.colors.primary
        )
    }
}

@Composable
fun WelcomeBackground(content: @Composable () -> Unit) {
    Box {
        CoilImage(
            data = R.drawable.welcome_bg,
            modifier = Modifier.fillMaxSize(),
            contentDescription = "Welcome",
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CoilImage(
                data = R.drawable.logo,
                contentDescription = "Logo",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .height(50.dp)
                    .wrapContentSize(Alignment.Center)
            )
        }
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyTheme {
        WelcomeContent()
    }
}