package com.example.budgetbitesapp

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.budgetbites.R

@Composable
fun MapScreen() {
    Image(
        painter = painterResource(id = R.drawable.map),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}