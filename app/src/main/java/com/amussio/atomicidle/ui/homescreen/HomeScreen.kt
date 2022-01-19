package com.amussio.atomicidle.ui.homescreen

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
import com.amussio.atomicidle.ui.theme.*
import kotlinx.coroutines.*

@ExperimentalFoundationApi
@Composable
fun HomeScreen() {
    val stock = getMockStock()
    LazyVerticalGrid(
        cells = GridCells.Adaptive(Item1),
        contentPadding = PaddingValues(vertical = VerticalPadding, horizontal = HorizontalPadding
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
    var enable by remember { mutableStateOf(true) }
    val scope by remember { mutableStateOf(CoroutineScope(Dispatchers.Default)) }
    Card(
        backgroundColor = Color.Black,
        border= if (enable) { BorderStroke(Border1, Color.White) } else { null }, //todo faire un truc avec ça
        modifier = Modifier
            .padding(Layout1)
            .clickable {
                if (enable == true) {
                    enable = false
                    element.quantity += 1 //faire un repository
                    scope.launch {
                        delay(1000L)
                        enable = true
                    }
                }
            }) {
        Box {
            val imageResource = context.resources.getIdentifier(element.name.lowercase(), "drawable", context.packageName)
            Image(painter = painterResource(id = imageResource), contentDescription = element.name)
            Column(modifier = Modifier
                .padding(Layout2)
                .align(alignment = Alignment.TopCenter)) {
                Text(modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center, text = element.name)
                Text(modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center, text = "x ${element.quantity /*TODO faire un repository qui recupere la valeur*/}")
            }
            Text(modifier = Modifier
                .padding(Layout2)
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