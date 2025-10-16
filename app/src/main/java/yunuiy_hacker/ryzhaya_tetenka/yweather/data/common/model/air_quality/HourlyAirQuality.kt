package yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.air_quality

import kotlinx.serialization.Serializable

@Serializable
data class HourlyAirQuality(
    val time: List<String>? = null,
    val ragweed_pollen: List<String>? = null,
    val olive_pollen: List<String>? = null,
    val mugwort_pollen: List<String>? = null,
    val grass_pollen: List<String>? = null,
    val birch_pollen: List<String>? = null,
    val alder_pollen: List<String>? = null
)
