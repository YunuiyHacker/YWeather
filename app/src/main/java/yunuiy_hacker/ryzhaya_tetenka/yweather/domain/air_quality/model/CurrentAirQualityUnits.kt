package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.air_quality.model

data class CurrentAirQualityUnits(
    val time: String = "",
    val interval: String = "",
    val ragweed_pollen: String = "",
    val olive_pollen: String = "",
    val mugwort_pollen: String = "",
    val grass_pollen: String = "",
    val birch_pollen: String = "",
    val alder_pollen: String = "",
    val us_aqi: String = "",
    val european_aqi: String = ""
)
