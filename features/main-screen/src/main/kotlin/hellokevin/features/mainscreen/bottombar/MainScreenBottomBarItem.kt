package hellokevin.features.mainscreen.bottombar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import hellokevin.features.mainscreen.Route
import hellokevin.parrot.features.mainscreen.R

sealed class MainScreenBottomBarItem(val route: Route, @StringRes val name: Int, @DrawableRes val icon: Int) {
    object Home : MainScreenBottomBarItem(route = Route.Home, name = R.string.bottom_bar_item_name_home, icon = R.drawable.home)
    object Create : MainScreenBottomBarItem(route = Route.Create, name = R.string.bottom_bar_item_name_create, icon = R.drawable.parrot)
    object Video : MainScreenBottomBarItem(route = Route.Videos, name = R.string.bottom_bar_item_name_videos, icon = R.drawable.play_box)
}
