package com.example.budgetbitesapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun UserProfileScreen(navcontroller: NavController) {
    Column{
        UserCard(Bite(R.string.review_name_1, R.drawable.woman1))
        Cardbehind2(navcontroller = navcontroller)
    }

}
@Composable
fun UserCard(bite: Bite) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Column {
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
                Text(
                    text = "",
                    modifier = Modifier.padding(1.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                )
                Text(
                    text = stringResource(bite.stringResourceId),
                    modifier = Modifier.padding(1.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                )
                Text(
                    text = "",
                    modifier = Modifier.padding(1.dp),
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 6.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                )
                Text(
                    text = "Number of reviews: " ,
                    modifier = Modifier.padding(1.dp),
                    style = MaterialTheme.typography.headlineMedium ,
                    fontSize = 18.sp,
                )
                Text(
                    text = "4" ,
                    modifier = Modifier.padding(1.dp),
                    style = MaterialTheme.typography.headlineMedium ,
                    fontSize = 18.sp,
                )
            }
        }
    }
}

@Composable
fun MaryReviewedCard(Bite: Bite, total: Int, food: Int, price: Int, speed: Int, hygiene: Int){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.Black),
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Column(modifier = Modifier.width(190.dp)){
                Image(
                    painter = painterResource(Bite.imageResourceId),
                    contentDescription = stringResource(Bite.stringResourceId),
                    modifier = Modifier
                        .width(145.dp)
                        .height(145.dp)
                        .padding(10.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = stringResource(id =Bite.stringResourceId),
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
fun ReviewedList2(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(
                rememberScrollState() ,
            )
        //horizontalAlignment = Alignment.CenterHorizontally//
    ) {
        MaryReviewedCard(Bite(R.string.starbucks, R.drawable.starbucks),R.string.review_total_1, R.string.review_food_1, R.string.review_price_1,R.string.review_speed_1, R.string.review_hygiene_1 )
        MaryReviewedCard(Bite(R.string.choppaluna, R.drawable.choppaluna),R.string.review_total_2, R.string.review_food_2, R.string.review_price_1,R.string.review_speed_2,R.string.review_hygiene_1)
        MaryReviewedCard(Bite(R.string.cafe49, R.drawable.cafe49),R.string.review_total_4, R.string.review_food_4,R.string.review_price_1, R.string.review_speed_3,R.string.review_hygiene_1)
        MaryReviewedCard(Bite(R.string.rotiking, R.drawable.rotiking),R.string.review_total_4, R.string.review_food_4,R.string.review_price_1, R.string.review_speed_3,R.string.review_hygiene_1)
    }
}

@Composable
fun Cardbehind2(modifier: Modifier = Modifier, navcontroller: NavController){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)){
        Column(
            modifier = modifier
                .fillMaxWidth()
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
            }
            Row{
                ReviewedList2()
            }
        }
    }
}