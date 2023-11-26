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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.budgetbites.R

@Composable
fun FavouritesScreen(navcontroller: NavController) {
    BiteList(navcontroller = navcontroller)
}
@Composable
fun BiteCard(bite: Bite, navcontroller: NavController){
    Card(modifier = Modifier
        .clickable {
            navcontroller.navigate(ScreenRoutes.Restaurant.route)
        }
        .width(200.dp)
        .padding(5.dp)) {
        Column {
            Image(
                painter = painterResource(bite.imageResourceId),
                contentDescription = stringResource(bite.stringResourceId),
                modifier = Modifier
                    .width(190.dp)
                    .height(190.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(bite.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

@Composable
fun BiteList(modifier: Modifier = Modifier,navcontroller: NavController) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
    ) {
        Row(
            modifier = modifier
        ){
            Text(
                modifier = modifier
                    .padding(10.dp),
                text = "FAVOURITE BITES",
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
                BiteCard(Bite(R.string.favourite1, R.drawable.starbucks),navcontroller)
                BiteCard(Bite(R.string.favourite7, R.drawable.rotiking),navcontroller)
                BiteCard(Bite(R.string.favourite10, R.drawable.wingwing),navcontroller)
                BiteCard(Bite(R.string.favourite3, R.drawable.choppaluna),navcontroller)
                BiteCard(Bite(R.string.favourite8, R.drawable.kingfalafel),navcontroller)

            }
            Column(modifier = modifier) {

                BiteCard(Bite(R.string.favourite6, R.drawable.isolabella),navcontroller)
                BiteCard(Bite(R.string.favourite9, R.drawable.cafe49),navcontroller)
                BiteCard(Bite(R.string.favourite4, R.drawable.mastercuisine),navcontroller)
                BiteCard(Bite(R.string.favourite2, R.drawable.costa), navcontroller)
                BiteCard(Bite(R.string.favourite5, R.drawable.haretortoise),navcontroller)
            }
        }
    }
}

