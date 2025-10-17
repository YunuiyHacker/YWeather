package yunuiy_hacker.ryzhaya_tetenka.yweather

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import dagger.hilt.android.AndroidEntryPoint
import yunuiy_hacker.ryzhaya_tetenka.yweather.nav_graph.NavGraph
import yunuiy_hacker.ryzhaya_tetenka.yweather.nav_graph.Route
import yunuiy_hacker.ryzhaya_tetenka.yweather.ui.theme.YWeatherTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val locationPermissionState =
                rememberPermissionState(permission = Manifest.permission.ACCESS_FINE_LOCATION)
            val notificationPermissionState =
                rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)
            val permissionsAreGranted by remember { mutableStateOf(locationPermissionState.status.isGranted && notificationPermissionState.status.isGranted) }

            val startDestination =
                if (permissionsAreGranted) Route.HomeScreen.route else Route.OnboardingScreen.route

            YWeatherTheme {
                val navHostController = rememberNavController()

                NavGraph(startDestination = startDestination, navHostController = navHostController)
            }
        }
    }
}