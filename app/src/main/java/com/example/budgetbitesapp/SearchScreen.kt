package com.example.budgetbitesapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

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
fun SearchScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally){
        var searchText by remember{ mutableStateOf("") }
        var appear by remember{mutableStateOf(false)}
        TextField(value = searchText, onValueChange = {searchText = it})
        Button(modifier = modifier, onClick = { appear = true }){
            Text("Search")
        }
        if (appear) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                cards.forEach { item ->
                    if (searchText == item.second) {
                        Card() {
                            Text(text = item.second)
                        }
                    }
                }
            }
        }
    }
}