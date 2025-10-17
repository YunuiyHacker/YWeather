package yunuiy_hacker.ryzhaya_tetenka.yweather.nav_graph

sealed class Route(val route: String) {
    data object OnboardingScreen : Route(route = "onboardingScreen")
    data object HomeScreen : Route(route = "homeScreen")
}