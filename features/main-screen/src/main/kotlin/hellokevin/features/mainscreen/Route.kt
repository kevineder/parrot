package hellokevin.features.mainscreen

sealed class Route(val value: String) {
    object Home: Route("home")
    object Create: Route("create")
    object Videos: Route("videos")
}