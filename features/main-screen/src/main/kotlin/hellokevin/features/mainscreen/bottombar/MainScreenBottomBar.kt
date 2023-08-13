package hellokevin.features.mainscreen.bottombar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreenBottomBar(
    navController: NavController
) {
    NavigationBar {
        val currentRoute = currentRoute(navController)
        val items = mutableListOf(
            MainScreenBottomBarItem.Home,
            MainScreenBottomBarItem.Create,
            MainScreenBottomBarItem.Video
        )

        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painterResource(item.icon),
                        contentDescription = stringResource(id = item.name)
                    )
                },
                label = { Text(stringResource(id = item.name)) },
                selected = currentRoute == item.route.value,
                onClick = {
                    // This if check gives us a "singleTop" behavior where we do not create a
                    // second instance of the composable if we are already on that destination
                    if (currentRoute != item.route.value) {
                        navController.navigate(item.route.value)
                    }
                }
            )
        }
    }
}

@Composable
private fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

@Preview
@Composable
fun PreviewMainScreenBottomBar() {
    MainScreenBottomBar(navController = rememberNavController())
}