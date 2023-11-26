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
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.budgetbites.R
import com.example.budgetbitesapp.model.Bite

@Composable
fun HomeScreen(navcontroller: NavController){
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(id = R.dimen.padding_medium)
        )
    ) {
        Row{
            Text(
                modifier = Modifier.padding(10.dp),
                text = "HOME",
                fontFamily= FontFamily.Serif,
                fontWeight = Bold,
                textAlign = TextAlign.Center,
                fontSize = 42.sp,
                lineHeight = 30.sp
            )
        }
        Text(
            "Recent Bites",
            fontWeight=Bold,
            fontSize=20.sp,
            textAlign= TextAlign.Left,
            modifier = Modifier.padding(15.dp)
        )
        BiteRow(navcontroller = navcontroller)
        Text(
            "Recommended Bites",
            fontWeight=Bold,
            fontSize=20.sp,
            textAlign= TextAlign.Left,
            modifier = Modifier.padding(15.dp)
        )
        BiteRow(navcontroller = navcontroller)
        Text(
            "Recent Bites",
            fontWeight=Bold,
            fontSize=20.sp,
            textAlign= TextAlign.Left,
            modifier = Modifier.padding(15.dp)
        )
        BiteRow(navcontroller = navcontroller)
    }
}

@Composable
fun SmallBiteCard(bite: Bite, navcontroller: NavController){
    Card(modifier= Modifier
        .clickable {navcontroller.navigate(ScreenRoutes.Restaurant.route)}
        .width(120.dp)
        .padding(5.dp)){
        Column{
            Image(
                painter=painterResource(bite.imageResourceId),
                contentDescription=stringResource(bite.stringResourceId),
                modifier= Modifier
                    .width(100.dp)
                    .height(100.dp),
                contentScale= ContentScale.Crop
            )
            Text(
                text=stringResource(bite.stringResourceId),
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun BiteRow(modifier:Modifier=Modifier, navcontroller: NavController){
    Column(
        modifier= modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ){
        Spacer(modifier=Modifier.height(8.dp))
        Row(modifier=modifier){
            SmallBiteCard(Bite(R.string.favourite1,R.drawable.starbucks), navcontroller)
            SmallBiteCard(Bite(R.string.favourite2,R.drawable.starbucks), navcontroller)
            SmallBiteCard(Bite(R.string.favourite1,R.drawable.starbucks), navcontroller)
            SmallBiteCard(Bite(R.string.favourite2,R.drawable.starbucks), navcontroller)
            SmallBiteCard(Bite(R.string.favourite1,R.drawable.starbucks), navcontroller)
        }
    }
}