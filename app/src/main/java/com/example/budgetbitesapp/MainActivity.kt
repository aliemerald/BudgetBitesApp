/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.budgetbitesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.unit.dp
import com.example.budgetbitesapp.ui.theme.BudgetBitesAppTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BudgetBitesAppTheme {
                val appState = rememberAppState()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            if (appState.shouldShowBottomBar)
                                BottomAppBar(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    contentPadding = PaddingValues(horizontal = 20.dp),
                                    modifier = Modifier
                                        .height(70.dp)
                                        .clip(
                                            RoundedCornerShape(
                                                topStart = 24.dp, topEnd = 24.dp
                                            )
                                        )
                                ) {
                                    BottomBarRow(
                                        navHostController = appState.navHostController,
                                    )
                                }
                        }
                    ) { innerPadding ->
                        BudgetBitesNavigation(
                            navController = appState.navHostController,
                            padding = innerPadding,
                            this
                        )
                    }
                }
            }
        }
    }
}