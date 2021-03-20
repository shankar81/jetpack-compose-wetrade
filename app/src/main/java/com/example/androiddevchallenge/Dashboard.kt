package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import kotlinx.coroutines.launch

class Stock(
    val alias: String,
    val company: String,
    val price: String,
    val percent: String,
    val image: Int
)

val stocks = listOf(
    Stock(
        alias = "ALK",
        company = "Alaska Air Group, Inc.",
        price = "\$7,918",
        percent = "-0.54%",
        image = R.drawable.alk
    ),
    Stock(
        alias = "BA",
        company = "Boeing Co.",
        price = "\$1,293",
        percent = "+4.18%",
        image = R.drawable.ba
    ),
    Stock(
        alias = "DAL",
        company = "Delta Airlines Inc",
        price = "\$893.50",
        percent = "-0.54%",
        image = R.drawable.dal
    ),
    Stock(
        alias = "EXPE",
        company = "Expedia Group Inc.",
        price = "\$12,301",
        percent = "+2.51%",
        image = R.drawable.exp
    ),
    Stock(
        alias = "EADSY",
        company = "Airbus SE",
        price = "\$12,301",
        percent = "+1.38%",
        image = R.drawable.eadsy
    ),
    Stock(
        alias = "JBLU",
        company = "Jetblue Airways Corp.",
        price = "\$8,521",
        percent = "+1.56%",
        image = R.drawable.jblu
    ),
    Stock(
        alias = "MAR",
        company = "Marriott International Inc.",
        price = "\$521",
        percent = "+2.75%",
        image = R.drawable.mar
    ),
    Stock(
        alias = "CCL",
        company = "Carnival Corp",
        price = "\$5,481",
        percent = "+0.14%",
        image = R.drawable.ccl
    ),
    Stock(
        alias = "RCL",
        company = "Royal Caribbean Cruises",
        price = "\$9,184",
        percent = "+1.69%",
        image = R.drawable.rcl
    ),
    Stock(
        alias = "TRVL",
        company = "Travelocity Inc.",
        price = "\$654",
        percent = "+3.23%",
        image = R.drawable.trvl
    )
)

class Dashboard : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
                bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
            )
            val coroutineScope = rememberCoroutineScope()
            MyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    BottomSheetScaffold(
                        sheetContent = {
                            Text(
                                text = "Positions",
                                style = MaterialTheme.typography.subtitle1,
                                color = MaterialTheme.colors.onSurface,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        coroutineScope.launch {
                                            if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                                                bottomSheetScaffoldState.bottomSheetState.expand()
                                            } else {
                                                bottomSheetScaffoldState.bottomSheetState.collapse()
                                            }
                                        }
                                    }
                                    .padding(vertical = 24.dp)
                            )
                            BottomSheetContent()
                        },
                        sheetShape = RectangleShape,
                        scaffoldState = bottomSheetScaffoldState,
                        sheetPeekHeight = 80.dp,
                    ) {
                        DashboardContent()
                    }
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
        Image(
            painter = painterResource(id = R.drawable.home_graph),
            modifier = Modifier.fillMaxWidth(),
            contentDescription = "Graph",
            contentScale = ContentScale.FillWidth
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

@ExperimentalMaterialApi
@Composable
fun BottomSheetContent() {
    Surface(color = MaterialTheme.colors.surface) {
        Column(modifier = Modifier.padding(16.dp)) {
            repeat(stocks.size) {
                StockItem(stock = stocks[it])
            }
        }
    }
}

@Composable
fun StockItem(stock: Stock) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Divider(color = MaterialTheme.colors.onSurface)
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(64.dp)
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Column(modifier = Modifier.weight(0.15F)) {
                Text(
                    text = stock.price,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface
                )
                Text(
                    text = stock.percent,
                    style = MaterialTheme.typography.body1,
                    color = Color(android.graphics.Color.parseColor("#D93C19"))
                )
            }
            Column(modifier = Modifier.weight(0.5F)) {
                Text(
                    text = stock.alias,
                    style = MaterialTheme.typography.h3,
                    color = MaterialTheme.colors.onSurface
                )
                Text(
                    text = stock.company,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface
                )
            }
            Image(
                painter = painterResource(id = stock.image),
                modifier = Modifier
                    .weight(0.35F)
                    .fillMaxHeight(),
                contentDescription = stock.alias,
                contentScale = ContentScale.FillBounds
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