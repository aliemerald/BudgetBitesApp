package com.example.budgetbitesapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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

@Composable
fun RestaurantProfileScreen(navcontroller: NavController) {
    Column {
        RestaurantCard(Bite(R.string.favourite1, R.drawable.starbucks))
        Cardbehind(navcontroller = navcontroller)
    }

}
@Composable
fun RestaurantCard(bite: Bite) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Row {
            Column(
                modifier = Modifier.width(200.dp)
            ) {
                Image(
                    painter = painterResource(bite.imageResourceId),
                    contentDescription = stringResource(bite.stringResourceId),
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp)
                        .padding(5.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column {
                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    Column{
                        Text(
                            text = "",
                            modifier = Modifier.padding(1.dp),
                            style = MaterialTheme.typography.headlineMedium,
                            fontSize = 6.sp,
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
                    }
                    Column {
                        SwitchFavourite()
                    }
                }
                Row {
                    Column {
                        Text(
                            text = "4.3 ★ ",
                            modifier = Modifier.padding(1.dp),
                            style = MaterialTheme.typography.headlineMedium,
                            fontSize = 20.sp,
                        )
                        Text(
                            text = "Coffee Shop",
                            modifier = Modifier.padding(1.dp),
                            style = MaterialTheme.typography.headlineMedium,
                            fontSize = 18.sp,
                        )
                        Text(
                            text = "Lynton House",
                            modifier = Modifier.padding(1.dp),
                            style = MaterialTheme.typography.headlineMedium,
                            fontSize = 18.sp
                        )
                        Text(
                            text = "Tavistock Square",
                            modifier = Modifier.padding(1.dp),
                            style = MaterialTheme.typography.headlineMedium,
                            fontSize = 18.sp
                        )
                        Text(
                            text = "London WC1H 9LT",
                            modifier = Modifier.padding(1.dp),
                            style = MaterialTheme.typography.headlineMedium,
                            fontSize = 18.sp
                        )
                    }
                }
            }

        }
    }
}

@Composable
fun AddReviewButton(
    onClick:() -> Unit,
    modifier: Modifier = Modifier
){
    Button(
        onClick = onClick,
        modifier = modifier.widthIn(min = 80.dp)

    ){
        Text("+")
    }
}

@Composable
fun ReviewedCard(bite: Bite, total: Int, food: Int, price: Int, speed: Int, hygiene: Int){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.Black),
    ) {
        Row{
            Column(modifier = Modifier.width(190.dp)){
                Image(
                    painter = painterResource(bite.imageResourceId),
                    contentDescription = stringResource(bite.stringResourceId),
                    modifier = Modifier
                        .width(145.dp)
                        .height(145.dp)
                        .padding(10.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = stringResource(id =bite.stringResourceId),
                    modifier = Modifier.padding(8.dp),
                    fontSize = 24.sp,
                    style = MaterialTheme.typography.headlineMedium ,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                )

            }
            Column{
                Text(
                    text = "",
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 4.sp

                )
                Text(
                    text = "Total: " + stringResource(id = total),
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "",
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 2.sp
                )
                Text(
                    text = "Food: " + stringResource(id = food),
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    fontFamily= FontFamily.SansSerif,
                    fontSize = 18.sp
                )
                Text(
                    text = "Price: " +stringResource(id = price),
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.headlineMedium ,
                    fontSize = 18.sp
                )
                Text(
                    text = "Speed: " +stringResource(id = speed),
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 18.sp
                )
                Text(
                    text = "Hygiene: " +stringResource(id = hygiene),
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 18.sp
                )
            }
        }
    }
}
@Composable
fun ReviewedList(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(
                rememberScrollState() ,
            )
        //horizontalAlignment = Alignment.CenterHorizontally//
    ) {
        ReviewedCard(Bite(R.string.review_name_1, R.drawable.woman1),R.string.review_total_1, R.string.review_food_1, R.string.review_price_1,R.string.review_speed_1, R.string.review_hygiene_1 )
        ReviewedCard(Bite(R.string.review_name_2, R.drawable.man1),R.string.review_total_2, R.string.review_food_2, R.string.review_price_1,R.string.review_speed_2,R.string.review_hygiene_1)
        ReviewedCard(Bite(R.string.review_name_3, R.drawable.man2),R.string.review_total_3, R.string.review_food_3, R.string.review_price_1,R.string.review_speed_3,R.string.review_hygiene_1)
        ReviewedCard(Bite(R.string.review_name_4, R.drawable.woman2),R.string.review_total_4, R.string.review_food_4,R.string.review_price_1, R.string.review_speed_3,R.string.review_hygiene_1)
        ReviewedCard(Bite(R.string.review_name_5, R.drawable.woman3),R.string.review_total_4, R.string.review_food_4,R.string.review_price_1, R.string.review_speed_3,R.string.review_hygiene_1)
    }
}


@Composable
fun Cardbehind(modifier: Modifier = Modifier, navcontroller: NavController){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp)){
        Column(
            modifier = modifier
                .fillMaxWidth()
            //horizontalAlignment = Alignment.CenterHorizontally//
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(140.dp)
            ) {
                Column{
                    Text(
                        "REVIEWS",
                        fontWeight = FontWeight.Bold,
                        fontFamily= FontFamily.Serif,
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Column {
                    AddReviewButton(onClick = { navcontroller.navigate(ScreenRoutes.WriteReview.route) })
                }
            }
            Row{
                ReviewedList()
            }
        }
    }
}


@Composable
fun SwitchFavourite() {
    var checked by remember { mutableStateOf(false) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        },
        thumbContent = if (checked) {
            {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        } else {
            null
        }
    )
}