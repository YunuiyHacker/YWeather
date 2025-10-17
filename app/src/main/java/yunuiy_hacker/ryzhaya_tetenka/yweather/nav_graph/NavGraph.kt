package yunuiy_hacker.ryzhaya_tetenka.yweather.nav_graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import yunuiy_hacker.ryzhaya_tetenka.yweather.presentation.home.HomeScreen
import yunuiy_hacker.ryzhaya_tetenka.yweather.presentation.onboarding.OnboardingScreen

@Composable
fun NavGraph(startDestination: String, navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = startDestination) {
        composable(route = Route.OnboardingScreen.route) {
            OnboardingScreen(navHostController = navHostController)
        }
        composable(route = Route.HomeScreen.route) {
            HomeScreen(navHostController = navHostController)
        }
    }
}