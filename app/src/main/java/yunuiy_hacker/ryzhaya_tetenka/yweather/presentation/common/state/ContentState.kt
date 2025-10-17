package yunuiy_hacker.ryzhaya_tetenka.yweather.presentation.common.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class ContentState(
    var isLoading: MutableState<Boolean> = mutableStateOf(false),
    var internetIsNotAvailable: MutableState<Boolean> = mutableStateOf(false),
    var isNoConnectionToServer: MutableState<Boolean> = mutableStateOf(false)
)
