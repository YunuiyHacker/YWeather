package yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.air_quality

import kotlinx.serialization.Serializable

@Serializable
data class HourlyAirQualityUnits(
    val time: String? = null,
    val ragweed_pollen: String? = null,
    val olive_pollen: String? = null,
    val mugwort_pollen: String? = null,
    val grass_pollen: String? = null,
    val birch_pollen: String? = null,
    val alder_pollen: String? = null
)
