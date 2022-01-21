package com.amussio.atomicidle.ui.homescreen

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amussio.atomicidle.data.extensions.printProduction
import com.amussio.atomicidle.data.helpers.getMockStock
import com.amussio.atomicidle.data.models.Element
import com.amussio.atomicidle.data.models.Stock
import com.amussio.atomicidle.data.repository.StockRepository
import com.amussio.atomicidle.ui.theme.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ExperimentalFoundationApi
@Composable
fun HomeScreen(viewModel: HomeScreenViewModel) {
    val stock by viewModel.stock.collectAsState(initial = null)
    if (stock == null || stock?.elements == null || stock?.elements?.count() == 0) {
        Button(onClick = {
            viewModel.addItem(getMockStock())
        }) {
            Text("Add")
        }
    }
    LazyVerticalGrid(
        cells = GridCells.Adaptive(Item1),
        contentPadding = PaddingValues(vertical = VerticalPadding, horizontal = HorizontalPadding
        )) {
        items(stock?.elements?.count()?:0) {
            ItemElement(stock?.elements!!.get(it))
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
    HomeScreen(hiltViewModel())
}

@HiltViewModel
class HomeScreenViewModel @Inject constructor(var stockRepository: StockRepository): ViewModel() {
    fun addItem(stock: Stock) {
        viewModelScope.launch(Dispatchers.IO) {
            stockRepository.insert(stock)
        }
    }
    val stock = stockRepository.getInfiniteStockFlow()

}