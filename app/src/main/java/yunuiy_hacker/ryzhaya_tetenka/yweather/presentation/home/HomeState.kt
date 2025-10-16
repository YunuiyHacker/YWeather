package yunuiy_hacker.ryzhaya_tetenka.yweather.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.air_quality.model.AirQuality
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.geocode.model.ReversePlace
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.open_meteo.model.Forecast
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.xras.model.GeomagneticStorm
import yunuiy_hacker.ryzhaya_tetenka.yweather.presentation.common.composable.state.ContentState

class HomeState {
    var userPlace by mutableStateOf(ReversePlace())
    var forecast by mutableStateOf(Forecast())
    var airQuality by mutableStateOf(AirQuality())
    var geomagneticStorm by mutableStateOf(GeomagneticStorm())

    val contentState by mutableStateOf(ContentState())
}