package yunuiy_hacker.ryzhaya_tetenka.yweather.presentation.onboarding

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.common.model.Snowflake
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    @ApplicationContext private val context: Context
) : ViewModel() {
    val state by mutableStateOf(OnboardingState())

    fun onEvent(event: OnboardingEvent) {
        when (event) {
            is OnboardingEvent.LoadDataEvent -> {
                state.density = event.density
                state.configuration = event.configuration
                state.cloudImageWidth = event.cloudImageWidth

                loadData()
            }

            is OnboardingEvent.LocationPermissionGrantedEvent -> {
                state.locationPermissionIsGranted = true
            }

            is OnboardingEvent.NotificationPermissionGrantedEvent -> {
                state.notificationPermissionIsGranted = true
            }

            is OnboardingEvent.ShowNeedOpenSettingsDialog -> {
                state.showNeedOpenSettingsDialog = true
            }

            is OnboardingEvent.HideNeedOpenSettingsDialog -> {
                state.showNeedOpenSettingsDialog = false
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun loadData() {
        state.contentState.isLoading.value = true

        val screenWidth = state.configuration?.screenWidthDp?.dp!!
        val cloudStart = (screenWidth / 2) - (state.cloudImageWidth / 2)
        val cloudEnd = (screenWidth / 2) + (state.cloudImageWidth / 2)

        GlobalScope.launch(Dispatchers.IO) {
            runBlocking {
                try {
                    for (i in 0..<17) {
                        state.snowflakes.add(
                            Snowflake(
                                size = Random.nextInt(12, 48).dp,
                                xOffset = Random.nextInt(
                                    cloudStart.value.toInt(), cloudEnd.value.toInt()
                                ).dp,
                                speed = Random.nextInt(5000, 17000),
                                rotationSpeed = Random.nextInt(7000, 14000),
                                delayMillis = Random.nextInt(100, 5000)
                            )
                        )
                    }
                    delay(100)
                    state.animate = true

                    state.contentState.isLoading.value = false
                } catch (e: Exception) {
                    state.contentState.isLoading.value = false
                }
            }
        }
    }
}