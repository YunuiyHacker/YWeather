package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.open_meteo

import yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.Forecast
import yunuiy_hacker.ryzhaya_tetenka.yweather.data.remote.open_meteo.OpenMeteoApi

class GetForecastOperator(private val openMeteoApi: OpenMeteoApi) {
    suspend operator fun invoke(lat: String, lon: String): Forecast? {
        return openMeteoApi.forecast(lat = lat, lon = lon)
    }
}