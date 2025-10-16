package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.air_quality.model

data class CurrentAirQuality(
    val time: String = "",
    val interval: Int = 0,
    val ragweed_pollen: String = "",
    val olive_pollen: String = "",
    val mugwort_pollen: String = "",
    val grass_pollen: String = "",
    val birch_pollen: String = "",
    val alder_pollen: String = "",
    val us_aqi: Int = 0,
    val european_aqi: Int = 0
)
