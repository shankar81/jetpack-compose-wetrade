package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

class Dashboard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    DashboardContent()
                }
            }
        }
    }
}

@Composable
fun DashboardContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            WeTradeTextButton(modifier = Modifier.weight(1F), label = "ACCOUNT")
            WeTradeTextButton(modifier = Modifier.weight(1F), label = "WATCHLIST")
            WeTradeTextButton(modifier = Modifier.weight(1F), label = "PROFILE")
        }
        Text(
            modifier = Modifier.padding(top = 24.dp),
            text = "Balance",
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onBackground
        )
        Text(
            modifier = Modifier.padding(vertical = 24.dp),
            text = "\$73,589.01",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onBackground
        )
        Text(
            modifier = Modifier.padding(bottom = 24.dp),
            text = "+412.35 today",
            style = MaterialTheme.typography.subtitle1,
            color = Color(android.graphics.Color.parseColor("#39A844"))
        )
        WeTradeButton(modifier = Modifier.fillMaxWidth(), label = "TRANSACT")
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(vertical = 16.dp)
        ) {
            WeTradeOutlineButton(
                label = "Week",
                more = true
            )
            WeTradeOutlineButton(
                label = "ETFs",
            )
            WeTradeOutlineButton(
                label = "Stocks",
            )
            WeTradeOutlineButton(
                label = "Funds",
            )
            WeTradeOutlineButton(
                label = "Others",
            )
        }
        CoilImage(
            data =  R.drawable.home_graph,
            modifier = Modifier.fillMaxWidth(),
            contentDescription = "Graph",
        )
    }
}

@Composable
fun WeTradeTextButton(modifier: Modifier = Modifier, label: String) {
    TextButton(modifier = modifier, onClick = {}) {
        Text(
            text = label,
            style = MaterialTheme.typography.button,
            color = MaterialTheme.colors.onBackground
        )
    }
}

@Composable
fun WeTradeOutlineButton(label: String, more: Boolean = false) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(end = 16.dp)
            .border(1.dp, MaterialTheme.colors.onBackground, RoundedCornerShape(50))
            .clip(RoundedCornerShape(50))
            .clickable { }
            .padding(vertical = 12.dp, horizontal = 24.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onBackground
        )
        if (more) {
            Icon(
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(16.dp),
                painter = painterResource(id = R.drawable.expand_more),
                contentDescription = "Expand"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    MyTheme {
        DashboardContent()
    }
}