package yunuiy_hacker.ryzhaya_tetenka.yweather.data.remote.air_quality

import retrofit2.http.GET
import retrofit2.http.Query
import yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.air_quality.AirQuality

interface AirQualityApi {
    @GET("air-quality")
    suspend fun airQuality(
        @Query("latitude") lat: String,
        @Query("longitude") lon: String,
        @Query("hourly") hourly: String = "ragweed_pollen,olive_pollen,mugwort_pollen,grass_pollen,birch_pollen,alder_pollen",
        @Query("current") current: String = "ragweed_pollen,olive_pollen,mugwort_pollen,grass_pollen,birch_pollen,alder_pollen,us_aqi,european_aqi"
    ): AirQuality?
}