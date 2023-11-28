package com.example.budgetbitesapp

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip //FOR THE CIRCLE
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.budgetbites.R

@SuppressLint("SuspiciousIndentation")
@Composable
fun LoginScreen(
    onLoginButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        //SCROLLABLE
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))
        ) {
            //LOGO ON TOP OF SCREEN
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            Image(
                painter = painterResource(R.drawable.bb_logo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(120.dp)
                    .height(70.dp)
                    .clip(RectangleShape)
            )

            // USING MODIFIER.CLIP TO CREATE CIRCLE SHAPE
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            Image(
                painter = painterResource(R.drawable.userimage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
            Text(
                text = stringResource(R.string.login),
                style = MaterialTheme.typography.headlineSmall
            )
            //STORES + HOLDS INPUT VALUE
            var username by remember { mutableStateOf("") }
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(text = "Username") }
            )

            var isPasswordVisible by remember { mutableStateOf(false) }
            var keyboardType = KeyboardType.Password // Built in function
            if (isPasswordVisible) {
                keyboardType = KeyboardType.Text // Text input will be shown as text
            }


            var password by remember { mutableStateOf("") }
            TextField(
                value = password,
                onValueChange = { password = it }, // storing values
                label = { Text(text = "Password") },
                // TEXT ISN'T HIDDEN IF PASSWORD VISIBLE IS SELECTED
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
            )

            // TOGGLE HIDE/SHOW PASSWORD BUTTON
            Button(
                onClick = {
                    isPasswordVisible = !isPasswordVisible
                }
            ) {
                Text(if (isPasswordVisible) "Hide password" else "Show password") // text on button
            }


            var showErrorDialog by remember { mutableStateOf(false) } // the message is constant, therefore change = false
            var errorMessage by remember { mutableStateOf("") } // mutableStateOf = if the variable changes quantities

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
            Button(
                onClick = {
                    if (username == "MarySmith" && password == "BudgetBites") {
                        // .invoke() = callback to navHost in blank.kt
                        onLoginButtonClicked.invoke()
                    } else {
                        //error message
                        errorMessage = when {
                            username != "MarySmith" && password != "BudgetBites" -> {
                                "Both username and password are incorrect"
                            }

                            username != "MarySmith" -> {
                                "Username is incorrect"
                            }

                            password != "BudgetBites" -> {
                                "Password is incorrect"
                            }

                            else -> ""
                        }
                        showErrorDialog = true
                    }
                },
                modifier = Modifier
                    .padding(vertical = dimensionResource(R.dimen.padding_small))
                    .height(70.dp) // Set the desired height
                    .width(250.dp)
            ) {
                Text(text = "Login")
            }
            if (showErrorDialog) {
                // ALERT DIALOGUE IS A POP-UP WINDOW
                AlertDialog(
                    onDismissRequest = {
                        showErrorDialog = false
                    },
                    title = {
                        Text(text = "Try Again")
                    },
                    // TEXT SHOWN UPON ERROR
                    text = {
                        Text(errorMessage)
                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                showErrorDialog = false
                            }
                        ) {
                            Text("OK")
                        }
                    }
                )
            }
        }
    }
}