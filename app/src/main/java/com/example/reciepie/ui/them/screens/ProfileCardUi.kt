package com.example.reciepie.ui.them.screens

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.reciepie.R
import com.example.reciepie.data.CardData
import com.example.reciepie.data.profiles

/**
 * Husty app top app bar
 */
@Composable
fun ProfilePage(){
    Scaffold (topBar = {HustyProfileTopAppBar()}){ it ->
        LazyColumn(contentPadding = it){
            items(profiles){
                HustyAppProfileCard(
                    cardData = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_large)))
            }
            }
        }
    }
/**
 * Husty Profiles top App bar
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HustyProfileTopAppBar( modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = stringResource(id = R.string.View))
            }
        },
        modifier = modifier
    )
}
/**
 * Composable for the Husty App Composable
 */
@Composable
fun HustyAppProfileCard(
    cardData: CardData,
    modifier: Modifier = Modifier){

    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(targetValue = if (expanded) Color.Cyan
    else    Color.LightGray){}
   OutlinedCard(
       modifier = Modifier,
       colors = CardDefaults.cardColors(
           containerColor = Color.LightGray
       )
   ) {
       Column (
           horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier
               .background(color = color)
               .fillMaxWidth()
               .padding(dimensionResource(id = R.dimen.padding_small))

       )
       {
           ProfilePicture(profilePicture = cardData.profilePictureId)
           BioInfo(userName = cardData.userName, bio = cardData.bioInfo)
           EmailIconAndButton(
               expanded = expanded,
               onClick = { expanded = !expanded}
           )
       }
       if (expanded){
           DescriptionInfo(
               desrciption = cardData.descriptionInfo,
               modifier = Modifier
                   .padding(
                       start = dimensionResource(id = R.dimen.padding_medium),
                       top = dimensionResource(id = R.dimen.padding_small),
                       end = dimensionResource(id = R.dimen.padding_medium),
                       bottom = dimensionResource(id = R.dimen.padding_medium)
                   )
           )
       }
   }
}
/**
 * Composable to describe the profile picture
 */
@Composable
fun ProfilePicture(
    @DrawableRes profilePicture: Int,
    modifier: Modifier = Modifier){
    Image(
        modifier = Modifier
            .size(dimensionResource(id = R.dimen.image_size))
            .padding(dimensionResource(id = R.dimen.padding_small))
            .clip(MaterialTheme.shapes.extraLarge),
        contentScale = ContentScale.Crop,
        painter = painterResource(id = profilePicture),
        contentDescription = null,
    )
}
/**
 * Displays the Bio Text
 */
@Composable
fun BioInfo(
    userName: Int,
    bio: Int,
    modifier: Modifier = Modifier){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_small))
    ){
        Text(
            text = stringResource(userName),
            fontWeight = FontWeight.ExtraBold
        )
        Text(text = stringResource(bio))
    }
}
/**
 * E-mail ican and view Profile button
 */
@Composable
private fun EmailIconAndButton(
    expanded: Boolean,
    onClick: () ->Unit,
    modifier: Modifier = Modifier){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary
            )
        Spacer(modifier = Modifier.weight(6f))
        IconButton(
            onClick = onClick,
            modifier = modifier
        ) {
            Icon(
                imageVector = if (expanded)Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary)
        }
    }
}
/**
 * Composable to describe more about the user
 */
@Composable
fun DescriptionInfo(
    desrciption: Int,
    modifier: Modifier = Modifier){
   Column(
       modifier = modifier
   ) {
       Text(
           text = stringResource(desrciption)
       )
   }
}
/**
 * Card Preview
 */
@Preview(showBackground = true)
@Composable
fun CardUiPreview(){
   // EmailIconAndButton(true)
}
/**
 * Page with cards preview
 */
@Preview
@Composable
fun ProfilePagePreview(){
    ProfilePage()
}
/**
 * Card preview
 */