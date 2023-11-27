package com.example.budgetbitesapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.budgetbites.R
import com.example.budgetbitesapp.model.Bite

@Composable
fun HomeScreen(navcontroller: NavController){
    Column(
        modifier = Modifier.padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        )
    {
        Text(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
            text = "HOME",
            fontFamily= FontFamily.Serif,
            fontWeight = Bold,
            textAlign = TextAlign.Center,
            fontSize = 42.sp,
            lineHeight = 30.sp
        )
        Text(
            "New Bites",
            fontWeight=Bold,
            fontSize=20.sp,
            fontFamily= FontFamily.Serif,
            modifier = Modifier
                .padding(5.dp)
                .align(Alignment.Start)
        )
        BiteRow(navcontroller = navcontroller)
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            "Recommended Bites",
            fontWeight=Bold,
            fontSize=20.sp,
            fontFamily= FontFamily.Serif,
            modifier = Modifier
                .padding(5.dp)
                .align(Alignment.Start)
        )
        BiteRow(navcontroller = navcontroller)
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            "Recent Bites",
            fontWeight=Bold,
            fontSize=20.sp,
            fontFamily= FontFamily.Serif,
            modifier = Modifier
                .padding(5.dp)
                .align(Alignment.Start)
        )
        BiteRow(navcontroller = navcontroller)
    }
}

@Composable
fun SmallBiteCard(bite: Bite, navcontroller: NavController){
    Card(modifier= Modifier
        .clickable { navcontroller.navigate(ScreenRoutes.Restaurant.route) }
        .width(130.dp)
        .padding(5.dp)){
        Column{
            Image(
                painter=painterResource(bite.imageResourceId),
                contentDescription=stringResource(bite.stringResourceId),
                modifier= Modifier
                    .width(120.dp)
                    .height(120.dp)
                    .padding(5.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale= ContentScale.Crop
            )
            Text(
                text=stringResource(bite.stringResourceId),
                fontSize = 15.sp,
                fontWeight = Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(5.dp)
            )
        }
    }
}

@Composable
fun BiteRow(modifier:Modifier=Modifier, navcontroller: NavController) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = modifier) {
            SmallBiteCard(Bite(R.string.favourite1, R.drawable.starbucks), navcontroller)
            SmallBiteCard(Bite(R.string.favourite2, R.drawable.pizzaexpress), navcontroller)
            SmallBiteCard(Bite(R.string.favourite3, R.drawable.choppaluna), navcontroller)
            SmallBiteCard(Bite(R.string.favourite6, R.drawable.isolabella), navcontroller)
            SmallBiteCard(Bite(R.string.favourite7, R.drawable.rotiking), navcontroller)
            SmallBiteCard(Bite(R.string.favourite9, R.drawable.cafe49), navcontroller)
        }
    }
}