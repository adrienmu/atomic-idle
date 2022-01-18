package com.amussio.atomicidle.ui.homescreen

import android.widget.Space
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amussio.atomicidle.data.extensions.printProduction
import com.amussio.atomicidle.data.helpers.getMockStock
import com.amussio.atomicidle.data.models.Element

@ExperimentalFoundationApi
@Composable
fun HomeScreen() {
    val stock = getMockStock()
    LazyVerticalGrid(
        cells = GridCells.Adaptive(100.dp),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        )) {
        items(stock.elements.count()) {
            ItemElement(stock.elements.get(it))
        }
    }
}

@Composable
fun ItemGroup(name: String) {

}

@Composable
fun ItemElement(element: Element) {
    val context = LocalContext.current
    Card(
        backgroundColor = Color.Black,
        elevation = 1.dp,
        modifier = Modifier.padding(4.dp)) {
        Box {
            val imageResource = context.resources.getIdentifier(element.name.lowercase(), "drawable", context.packageName)
            Image(painter = painterResource(id = imageResource), contentDescription = element.name)
            Column(modifier = Modifier
                .padding(8.dp)
                .align(alignment = Alignment.TopCenter)) {
                Text(modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center, text = element.name)
                Text(modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center, text = "x ${element.quantity}")
            }
            Text(modifier = Modifier
                .padding(8.dp)
                .align(alignment = Alignment.BottomCenter),text="+ ${element.printProduction()} /s")

        }


    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}