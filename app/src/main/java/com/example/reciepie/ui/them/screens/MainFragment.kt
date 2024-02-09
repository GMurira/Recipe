package com.example.reciepie.ui.them.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reciepie.R
import com.example.reciepie.data.list
import com.example.reciepie.ui.theme.ReciepieTheme
import com.example.reciepie.ui.theme.Shapes

/**
 * Main page for the mobile application
 */
@Composable
fun MainFragementComposable(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
        {
             BasicInfo()
            DescriptionRow()
            ServiceCalculator()
            Ingridients()
            IngredientsList()

    }
}
/**
 * Basic Information row with icons
 */
@Composable
fun BasicInfo(modifier: Modifier = Modifier){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Icon(
            Icons.Default.AccountCircle,
            contentDescription = null
        )
        Icon(
            Icons.Default.AccountCircle,
            contentDescription = null
        )
        Icon(
            Icons.Default.Clear,
            contentDescription = null
        )
    }
}
/**
 * Description Composable
 */
@Composable
fun DescriptionRow(modifier: Modifier = Modifier){
    Text(
        text = stringResource(id = R.string.Sometext),
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
        )
}
/**
 * Service calculator
 */
@Composable
fun ServiceCalculator(modifier: Modifier = Modifier){
    //ChangeIcns to buttons to insert Logic
    var serviceValue by remember{ mutableStateOf(0)}
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .padding(
                vertical = dimensionResource(id = R.dimen.padding_medium),
                horizontal = dimensionResource(id = R.dimen.padding_small)
            )
            .background(Color.LightGray)
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.large)
    ){
        Text(text = stringResource(id = R.string.Orders,Modifier.weight(1f)), fontWeight = FontWeight.ExtraBold)
        Spacer(modifier = Modifier.weight(1f))
        Icon(Icons.Default.Add, contentDescription = null )
        Text(text = stringResource(id = R.string.Orders), Modifier.padding(16.dp))
        Icon(Icons.Default.ArrowForward, contentDescription = null)
    }
}
/**
 * Ingridients Row
 */
@Composable
fun Ingridients(modifier: Modifier = Modifier){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .padding(
                vertical = dimensionResource(id = R.dimen.padding_medium),
                horizontal = dimensionResource(id = R.dimen.padding_small)
            )
            .background(Color.LightGray)
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.large)
    ) {
        TabButton(active = true, text = stringResource(id = R.string.Sometext) )
        TabButton(active = false, text = stringResource(id = R.string.Sometext))
        TabButton(active = false, text = stringResource(id = R.string.Sometext))
    }
}
/**
 * Tab buttons
 */
@Composable
fun TabButton( active: Boolean,text:String,modifier: Modifier = Modifier){
    Button(
        onClick = { /*TODO*/ },
        colors = if (active){
            ButtonDefaults.buttonColors(
                containerColor = Color.Yellow,
                contentColor = Color.Black
            )
        }else  {
            ButtonDefaults.buttonColors(
                containerColor = Color.Gray,
                contentColor = Color.White
            )
        }
    ) {
        Text(text)
    }
    }
/**
 * Ingredients List
 */
@Composable
fun IngredientsList(){
    IngredientsListCard(
        cardIcon = R.drawable.nguyai,
        title = "Title",
        subtitle = "Sub_Title"
        )
}
/**
 * Easy Grid
 */
@Composable
fun <T>EasyGrid(
    nColumns: Int,
    items: list<T>,
    content: @Composable (T) -> Unit,
    modifier: Modifier = Modifier)
{
    Column (modifier = Modifier.padding(16.dp)){
        for (i in items.indices step nColumns){
            Row {
                for (j in 0 until nColumns){
                    if ()
                }
            }
        }
    }
}
/**
 * Ingredients Card
 */

@Composable
fun IngredientsListCard(
    @DrawableRes cardIcon: Int,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
){
   Column (
       horizontalAlignment = Alignment.CenterHorizontally,
       modifier = Modifier.padding(bottom = 16.dp)
   ){
       Card(
           shape = Shapes.large,
           modifier = Modifier
               .width(100.dp)
               .height(100.dp)
               .padding(bottom = 8.dp)
       ) {
           Image(
               painter = painterResource(id = cardIcon),
               contentDescription = null,
               modifier =  Modifier.padding(16.dp)
           )
           Text(
               text = title,
               modifier = Modifier
                   .width(100.dp),
               fontSize = 14.sp,
               fontWeight = FontWeight.Medium
               )
           Text(
               text = subtitle,
               modifier = Modifier.width(100.dp),
               color = Color.DarkGray,
               fontSize = 14.sp

           )
       }
   }
}
/**
 * Ingredients card preview
 */
@Preview
@Composable
fun IngredientsCardPreview(){
    //IngredientsListCard(cardIcon = )
}
/**
 * Main fragment composable preview
 */
@Preview(showBackground = true)
@Composable
fun MainFragmentComposablePreview(){
    ReciepieTheme {
        MainFragementComposable()
    }
}