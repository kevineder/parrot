package hellokevin.features.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import hellokevin.features.mainscreen.bottombar.MainScreenBottomBarItem
import hellokevin.features.mainscreen.bottombar.MainScreenBottomBar

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {},
        bottomBar = {
            MainScreenBottomBar(navController)
        },
    ) { paddingValues ->
        Box(modifier = modifier.padding(bottom = paddingValues.calculateBottomPadding())) {
            MainScreenNavigationConfigurations(navController)
        }
    }
}

@Composable
private fun MainScreenNavigationConfigurations(
    navController: NavHostController
) {
    NavHost(navController, startDestination = Route.Home.value) {
        composable(MainScreenBottomBarItem.Home.route.value) {
            Box(modifier = Modifier.background(Color.Green).fillMaxSize()) {}
        }
        composable(MainScreenBottomBarItem.Create.route.value) {
            Box(modifier = Modifier.background(Color.Red).fillMaxSize()) {}
        }
        composable(MainScreenBottomBarItem.Video.route.value) {
            Box(modifier = Modifier.background(Color.Blue).fillMaxSize()) {}
        }
    }
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen()
}