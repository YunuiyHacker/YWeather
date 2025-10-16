package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.air_quality.use_case

import yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.air_quality.AirQuality
import yunuiy_hacker.ryzhaya_tetenka.yweather.data.remote.air_quality.AirQualityApi

class GetAirQualityOperator(private val airQualityApi: AirQualityApi) {
    suspend operator fun invoke(lat: String, lon: String): AirQuality? {
        return airQualityApi.airQuality(lat = lat, lon = lon)
    }
}