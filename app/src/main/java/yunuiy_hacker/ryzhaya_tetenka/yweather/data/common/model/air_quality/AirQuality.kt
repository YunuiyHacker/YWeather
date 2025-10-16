package yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.air_quality

import kotlinx.serialization.Serializable

@Serializable
data class AirQuality(
    val latitude: Double? = null,
    val longitude: Double? = null,
    val generationtime_ms: Double? = null,
    val utc_offset_seconds: Int? = null,
    val timezone: String? = null,
    val timezone_abbreviation: String? = null,
    val elevation: Int? = null,
    val current_units: CurrentAirQualityUnits? = CurrentAirQualityUnits(),
    val current: CurrentAirQuality? = CurrentAirQuality(),
    val hourly_units: HourlyAirQualityUnits? = HourlyAirQualityUnits(),
    val hourly: HourlyAirQuality? = HourlyAirQuality()
)
