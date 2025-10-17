package yunuiy_hacker.ryzhaya_tetenka.yweather.presentation.home

import androidx.annotation.RequiresPermission
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController

@RequiresPermission(allOf = [android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION])
@Composable
fun HomeScreen(navHostController: NavController, viewModel: HomeViewModel = hiltViewModel()) {

//    LaunchedEffect(Unit) {
//        viewModel.onEvent(HomeEvent.LoadDataEvent)
//    }

    viewModel.state.let { state ->
        Scaffold() {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(it)
            ) {

            }
        }
    }
}