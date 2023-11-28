package com.example.budgetbitesapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.budgetbitesapp.model.Bite
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.budgetbites.R

@Composable
fun FavouritesScreen(navcontroller: NavController) {
    BiteColumn(navcontroller = navcontroller)
}
@Composable
fun BigBiteCard(bite: Bite, navcontroller: NavController){
    Card(modifier = Modifier
        .clickable {navcontroller.navigate(ScreenRoutes.Restaurant.route)}
        .width(200.dp)
        .padding(5.dp)) {
        Column {
            Image(
                painter = painterResource(bite.imageResourceId),
                contentDescription = stringResource(bite.stringResourceId),
                modifier = Modifier
                    .width(190.dp)
                    .height(190.dp)
                    .padding(5.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(bite.stringResourceId),
                fontSize = 20.sp,
                fontFamily= FontFamily.Serif,
                fontWeight = Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

@Composable
fun BiteColumn(modifier: Modifier = Modifier, navcontroller: NavController) {
    Column(
        modifier = modifier
            .padding(15.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier
        ){
            Text(
                modifier = modifier
                    .padding(10.dp),
                text = "FAVOURITES",
                fontFamily= FontFamily.Serif,
                fontWeight = Bold,
                textAlign = TextAlign.Center,
                fontSize = 42.sp,
                lineHeight = 30.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        Row (
            horizontalArrangement = Arrangement.SpaceEvenly
        )
        {
            Column(modifier = modifier) {
                BigBiteCard(Bite(R.string.starbucks, R.drawable.starbucks),navcontroller)
                BigBiteCard(Bite(R.string.rotiking, R.drawable.rotiking),navcontroller)
                BigBiteCard(Bite(R.string.wingwing, R.drawable.wingwing),navcontroller)
                BigBiteCard(Bite(R.string.choppaluna, R.drawable.choppaluna),navcontroller)
                BigBiteCard(Bite(R.string.kingfalafel, R.drawable.kingfalafel),navcontroller)

            }
            Column(modifier = modifier) {

                BigBiteCard(Bite(R.string.isolabella, R.drawable.isolabella),navcontroller)
                BigBiteCard(Bite(R.string.cafe49, R.drawable.cafe49),navcontroller)
                BigBiteCard(Bite(R.string.mastercuisine, R.drawable.mastercuisine),navcontroller)
                BigBiteCard(Bite(R.string.pizzaexpress, R.drawable.pizzaexpress), navcontroller)
                BigBiteCard(Bite(R.string.haretortoise, R.drawable.haretortoise),navcontroller)
            }
        }
    }
}

