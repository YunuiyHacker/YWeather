package yunuiy_hacker.ryzhaya_tetenka.yweather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import yunuiy_hacker.ryzhaya_tetenka.yweather.nav_graph.NavGraph
import yunuiy_hacker.ryzhaya_tetenka.yweather.nav_graph.Route
import yunuiy_hacker.ryzhaya_tetenka.yweather.ui.theme.YWeatherTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YWeatherTheme {
                val navHostController = rememberNavController()
                val startDestination = Route.HomeScreen.route

                NavGraph(startDestination = startDestination, navHostController = navHostController)
            }
        }
    }
}