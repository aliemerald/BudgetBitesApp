package com.example.budgetbitesapp

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.budgetbites.R
import com.example.budgetbitesapp.model.Bite

val cards = listOf(
    Pair("path", "Master Wei Xi'an"),
    Pair("path", "Choppaluna"),
    Pair("path", "Starbucks"),
    Pair("path", "The King of Falafel"),
    Pair("path", "The 49 café"),
    Pair("path", "Hair & Tortoise")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = Modifier.padding(15.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = modifier
                .padding(10.dp)
                .align(alignment = CenterHorizontally),
            text = "SEARCH",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            fontSize = 42.sp,
            lineHeight = 30.sp
        )
        var searchText by remember { mutableStateOf("") }
        var appear by remember { mutableStateOf(false) }
        TextField(value = searchText, onValueChange = { searchText = it })
        Button(modifier = modifier.padding(10.dp), onClick = { appear = true }) {
            Text("Search")
        }
        if (appear) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.verticalScroll(rememberScrollState()).padding(15.dp)
            ) {
                cards.forEach { item ->
                    if (searchText in item.second) {
                        BigBiteCard(Bite(R.string.starbucks, R.drawable.starbucks), navController)
                    }
                }
            }
        }
    }
}