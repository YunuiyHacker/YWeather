package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.air_quality.model

data class HourlyAirQuality(
    val time: List<String> = listOf(),
    val ragweed_pollen: List<String> = listOf(),
    val olive_pollen: List<String> = listOf(),
    val mugwort_pollen: List<String> = listOf(),
    val grass_pollen: List<String> = listOf(),
    val birch_pollen: List<String> = listOf(),
    val alder_pollen: List<String> = listOf()
)
