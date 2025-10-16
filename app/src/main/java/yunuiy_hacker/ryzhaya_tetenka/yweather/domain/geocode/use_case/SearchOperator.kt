package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.geocode

import yunuiy_hacker.ryzhaya_tetenka.yweather.BuildConfig
import yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.geocode.SearchPlace
import yunuiy_hacker.ryzhaya_tetenka.yweather.data.remote.geocode.GeocodeApi

class SearchOperator(private val geocodeApi: GeocodeApi) {
    suspend operator fun invoke(q: String): List<SearchPlace>? {
        return geocodeApi.search(apiKey = BuildConfig.GEOCODE_API_KEY, q = q)
    }
}