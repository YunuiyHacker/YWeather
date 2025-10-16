package yunuiy_hacker.ryzhaya_tetenka.yweather.nav_graph

sealed class Route(val route: String) {
    data object HomeScreen : Route(route = "homeScreen")
}