package yunuiy_hacker.ryzhaya_tetenka.yweather.presentation.onboarding

import android.content.res.Configuration
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp

sealed class OnboardingEvent {
    data class LoadDataEvent(
        val density: Density,
        val configuration: Configuration,
        val cloudImageWidth: Dp
    ) : OnboardingEvent()

    data object LocationPermissionGrantedEvent : OnboardingEvent()
    data object NotificationPermissionGrantedEvent : OnboardingEvent()

    data object ShowNeedOpenSettingsDialog : OnboardingEvent()
    data object HideNeedOpenSettingsDialog : OnboardingEvent()
}