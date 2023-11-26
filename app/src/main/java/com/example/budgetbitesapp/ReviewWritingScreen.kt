package com.example.budgetbitesapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.budgetbites.R
import com.example.budgetbitesapp.model.Bite
import java.io.File
import java.io.BufferedWriter
import java.io.FileWriter


@Composable
fun ReviewWritingScreen(navcontroller: NavController) {
    RestaurantCard2(Bite(R.string.favourite1, R.drawable.starbucks), navcontroller = navcontroller)
}

@Composable
fun RestaurantCard2(bite: Bite, navcontroller: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp)
    ) {
        Row {
            Column {
                Image(
                    painter = painterResource(bite.imageResourceId),
                    contentDescription = stringResource(bite.stringResourceId),
                    modifier = Modifier
                        .width(170.dp)
                        .height(170.dp)
                        .padding(10.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column {
                Text(
                    text = "",
                    modifier = Modifier.padding(1.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 4.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                )
                Text(
                    text = stringResource(bite.stringResourceId),
                    modifier = Modifier.padding(1.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                )
                Text(
                    text = "",
                    modifier = Modifier.padding(1.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 3.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                )
                Text(
                    text = "Coffee Shop" ,
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 18.sp
                )
                Text(
                    text = "Lynton House" ,
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 18.sp
                )
                Text(
                    text = "Tavistock Square" ,
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 18.sp
                )
                Text(
                    text = "London WC1H 9LT" ,
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 18.sp
                )
            }
        }
        Row{
            ReviewCard2(Bite(R.string.review_name_1, R.drawable.woman1), navcontroller)
        }
    }
}

@Composable
fun ReviewCard2(Bite: Bite, navcontroller: NavController) {
    Card(
        modifier = Modifier
            .width(400.dp)
            .height(700.dp)
            .padding(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.Black),

        ) {
        Row {
            Column {
                Image(
                    painter = painterResource(Bite.imageResourceId),
                    contentDescription = stringResource(Bite.stringResourceId),
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp)
                        .padding(10.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column {
                Text(
                    text = stringResource(Bite.stringResourceId),
                    modifier = Modifier.padding(20.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                )
            }
        }
        Row {
            ReviewCardFill()
        }
        Row{
            Column(
                modifier = Modifier
                    .width(210.dp)
            ){}
            Column {
                SubmitButton(onClick = { navcontroller.navigate(ScreenRoutes.ReviewCheck.route) })
            }
        }
    }
}
@Composable
fun ReviewCardFill() {
    Card(
        modifier = Modifier
            .width(400.dp)
            .height(325.dp)
            .padding(15.dp)
    ) {
        Column {
            Text(
                text = "REVIEW:",
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
            )
            Column(
                verticalArrangement = Arrangement.Center
            )
            {
                val context = LocalContext.current
                val file = File(context.filesDir, "info.txt")
                EditFoodField(file = file)
                EditPriceField(file = file)
                EditSpeedField(file = file)
                EditHygieneField(file = file)
            }
        }
    }
}

@Composable
fun EditFoodField(modifier: Modifier = Modifier, file: File) {
    var amountInput by remember { mutableStateOf("")}
    OutlinedTextField(
        value = amountInput,
        onValueChange = { amountInput = it },
        modifier = Modifier
            .height(60.dp)
            .width(275.dp),
        maxLines = 1,
        label = {Text(stringResource(R.string.food))},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        /*textStyle = TextStyle.Default.copy(fontSize = 28.sp))*/
    )
    appendLineToFile(amountInput.toString(), file)
}
@Composable
fun EditPriceField(modifier: Modifier = Modifier, file: File) {
    var amountInput by remember { mutableStateOf("")}
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    OutlinedTextField(
        value = amountInput,
        onValueChange = { amountInput = it },
        modifier = modifier
            .height(60.dp)
            .width(275.dp),
        label = {Text(stringResource(R.string.price))},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        maxLines = 1,
    )
    appendLineToFile(amountInput.toString(), file)
}
@Composable
fun EditSpeedField(modifier: Modifier = Modifier, file: File) {
    var amountInput by remember { mutableStateOf("")}
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    OutlinedTextField(
        value = amountInput,
        onValueChange = { amountInput = it },
        modifier = modifier
            .height(60.dp)
            .width(275.dp),
        maxLines = 1,
        label = {Text(stringResource(R.string.speed))},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    )
    appendLineToFile(amountInput.toString(), file)
}
@Composable
fun EditHygieneField(modifier: Modifier = Modifier, file: File) {
    var amountInput by remember { mutableStateOf("")}
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    OutlinedTextField(
        value = amountInput,
        onValueChange = { amountInput = it },
        modifier = modifier
            .height(60.dp)
            .width(275.dp),
        maxLines = 1,
        label = {Text(stringResource(R.string.hygiene))},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    )
    appendLineToFile(amountInput.toString(), file)
}

@Composable
fun SubmitButton(
    onClick:() -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .widthIn(min = 80.dp)
            .height(50.dp)
            .padding(5.dp),
    ) {
        Text("SUBMIT")
    }
}

fun appendLineToFile(line: String, filePath: File) {
    try {
        val fileWriter = FileWriter(filePath, true) // Set the second parameter to true for append mode
        val bufferedWriter = BufferedWriter(fileWriter)
        bufferedWriter.write(line)
        bufferedWriter.newLine() // Add a newline character after the line
        bufferedWriter.close()
        println("Line appended to file: $filePath")
    } catch (e: Exception) {
        println("Error appending line to file: ${e.message}")
    }
}