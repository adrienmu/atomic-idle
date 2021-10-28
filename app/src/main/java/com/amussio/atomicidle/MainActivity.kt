package com.amussio.atomicidle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.amussio.atomicidle.ui.*
import com.amussio.atomicidle.ui.theme.AtomicIdleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AtomicIdleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Home()
                }
            }
        }
    }
}

@Composable
fun Home() {
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.background(Color.Black),
        topBar = {TopBar()},
        bottomBar = {BottomNavigationBar(navController)}
    ) {
        Navigation(navController = navController)
    }
}

@Composable
fun TopBar() {
    Surface(
        color = Color.Black,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column() {
            TotalRessource(name = "Energie", value = 5548)
            TotalRessource(name = "CO2", value = 71)
        }
    }

}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.MyWorld,
        NavigationItem.Build,
        NavigationItem.Improve,
        NavigationItem.Scientists,
        NavigationItem.Dashboard
    )
    BottomNavigation(
        backgroundColor = Color.Black,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = false,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.MyWorld.route) {
        composable(NavigationItem.MyWorld.route) {
            HomeScreen()
        }
        composable(NavigationItem.Build.route) {
            MusicScreen()
        }
        composable(NavigationItem.Improve.route) {
            MoviesScreen()
        }
        composable(NavigationItem.Scientists.route) {
            BooksScreen()
        }
        composable(NavigationItem.Dashboard.route) {
            ProfileScreen()
        }
    }
}

@Composable
fun TotalRessource(name: String, value: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(
                horizontal = 15.dp,
            vertical = 8.dp),
            text = "$name",
        color = Color.Blue)
        Text(text = "$value",
        color = Color.Red)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AtomicIdleTheme {
        Surface(color = Color.Black) {
            Home()
        }
    }
}