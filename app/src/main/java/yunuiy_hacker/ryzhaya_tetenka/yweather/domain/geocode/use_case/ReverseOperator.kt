package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.geocode

import yunuiy_hacker.ryzhaya_tetenka.yweather.BuildConfig
import yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.geocode.ReversePlace
import yunuiy_hacker.ryzhaya_tetenka.yweather.data.remote.geocode.GeocodeApi

class ReverseOperator(private val geocodeApi: GeocodeApi) {
    suspend operator fun invoke(lat: String, lon: String): ReversePlace? {
        return geocodeApi.reverse(apiKey = BuildConfig.GEOCODE_API_KEY, lat = lat, lon = lon)
    }
}