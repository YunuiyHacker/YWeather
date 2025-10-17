package yunuiy_hacker.ryzhaya_tetenka.yweather.presentation.onboarding

import android.content.res.Configuration
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.common.model.Snowflake
import yunuiy_hacker.ryzhaya_tetenka.yweather.presentation.common.state.ContentState

class OnboardingState {
    var density by mutableStateOf<Density?>(null)
    var configuration by mutableStateOf<Configuration?>(null)
    var cloudImageWidth by mutableStateOf(0.dp)
    var snowflakes: MutableList<Snowflake> = mutableStateListOf()
    var locationPermissionIsGranted by mutableStateOf(false)
    var notificationPermissionIsGranted by mutableStateOf(false)

    var animate by mutableStateOf(false)

    var valid by mutableStateOf(false)

    var showNeedOpenSettingsDialog by mutableStateOf(false)

    val contentState by mutableStateOf(ContentState())
}