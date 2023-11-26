package com.example.budgetbitesapp 

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.budgetbites.R
import com.example.budgetbitesapp.model.Bite
import java.io.File
import java.io.FileInputStream
import java.math.BigDecimal
import java.math.RoundingMode


@Composable
fun ReviewCardChecker(navcontroller: NavController) {
    ReviewCheckCard(Bite(R.string.favourite1, R.drawable.starbucks), navcontroller = navcontroller)
}

@Composable
fun ReviewCheckCard(Bite: Bite, navcontroller: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp)
    ) {
        Row {
            Column {
                Image(
                    painter = painterResource(Bite.imageResourceId),
                    contentDescription = stringResource(Bite.stringResourceId),
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
                    text = stringResource(Bite.stringResourceId),
                    modifier = Modifier.padding(1.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 22.sp,
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
            ReviewCheck2(Bite(R.string.review_name_1, R.drawable.woman1), navcontroller)
        }
    }
}

@Composable
fun ReviewCheck2(Bite: Bite, navcontroller: NavController) {
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
            ReviewCardFill2()
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(80.dp)
        ){
            Column{
                CancelButton(onClick = {navcontroller.navigate(ScreenRoutes.WriteReview.route)})
            }
            Column{
                SubmitButton2(onClick = {navcontroller.navigate(ScreenRoutes.Restaurant.route)})
            }

        }
    }
}
@Composable
fun ReviewCardFill2() {
    Card(
        modifier = Modifier
            .width(400.dp)
            .height(325.dp)
            .padding(15.dp)
    ) {
        val path = LocalContext.current.filesDir
        val letDirectory = File(path, "Cave")
        val file1 = File(letDirectory, "Record.txt")
        val file2 = File(letDirectory, "Record2.txt")
        val file3 = File(letDirectory, "Record3.txt")
        val file4 = File(letDirectory, "Record4.txt")
        val inputAsString = FileInputStream(file1).bufferedReader().use{it.readText()}
        val inputAsString2 = FileInputStream(file2).bufferedReader().use{it.readText()}
        val inputAsString3 = FileInputStream(file3).bufferedReader().use{it.readText()}
        val inputAsString4 = FileInputStream(file4).bufferedReader().use{it.readText()}
        val total = ((inputAsString.toDouble() + inputAsString2.toDouble() + inputAsString3.toDouble() + inputAsString4.toDouble())/4.0)
        val rounded = BigDecimal(total).setScale(2, RoundingMode.HALF_EVEN)
        Column {
            Text(
                text = "REVIEW:",
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
            )
            Text(
                text = "",
                modifier = Modifier.padding(2.dp),
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 2.sp
            )
            Text(
                text = "Total: $rounded"+ "★",
                modifier = Modifier.padding(5.dp),
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,

                )
            Text(
                text = "",
                modifier = Modifier.padding(2.dp),
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 2.sp
            )
            Text(
                text = "Food: $inputAsString" + "★",
                modifier = Modifier.padding(5.dp),
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 22.sp
            )
            Text(
                text = "Price: $inputAsString2"+ "★",
                modifier = Modifier.padding(5.dp),
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 22.sp
            )
            Text(
                text = "Speed: $inputAsString3"+ "★",
                modifier = Modifier.padding(5.dp),
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 22.sp
            )
            Text(
                text = "Hygiene: $inputAsString4"+ "★",
                modifier = Modifier.padding(5.dp),
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 22.sp
            )
            Text(
                text = "Are you sure you want to submit? ",
                modifier = Modifier.padding(5.dp),
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 19.5.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )
        }
    }
}


@Composable
fun SubmitButton2(
    onClick:() -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .widthIn(min = 80.dp)
            .padding(10.dp)
    ) {
        Text("SUBMIT")
    }
}

@Composable
fun CancelButton(
    onClick:() -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .widthIn(min = 80.dp)
            .padding(10.dp)
    ) {
        Text("CANCEL")
    }
}