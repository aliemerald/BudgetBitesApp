package com.example.budgetbitesapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.budgetbites.R

@Composable
fun MapScreen() {
    // KEEPS TRACK OF THE ZOOM LEVEL
    var scale by remember { mutableStateOf(1f) }

    Image(
        painter = painterResource(id = R.drawable.map),
        contentDescription = null,
        //THE IMAGE FILLS THE ENTIRE SCREEN
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                // ALLOWS USER TO PAN - NOT ZOOM (unsure why)
                detectTransformGestures { _, pan, zoom, _ ->
                    // UPDATE SCALE
                    scale *= zoom
                }
            }
            .graphicsLayer(
                // ENSURES THE IMAGE DOESN'T GET MOVED OUT OF THE FRAME VIEW
                scaleX = maxOf(1f, minOf(scale, 5f)),
                scaleY = maxOf(1f, minOf(scale, 5f))
            )
            // ENABLE VERTICAL SCROLL (horizontal scroll is unusable due to image size being fit to full screen)
            .verticalScroll(rememberScrollState())
            .horizontalScroll(rememberScrollState())
    )
}
