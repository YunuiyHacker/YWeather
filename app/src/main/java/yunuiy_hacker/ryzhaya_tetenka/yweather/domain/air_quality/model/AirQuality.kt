package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.air_quality.model

data class AirQuality(
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val generationtime_ms: Double = 0.0,
    val utc_offset_seconds: Int = 0,
    val timezone: String = "",
    val timezone_abbreviation: String = "",
    val elevation: Int = 0,
    val current_units: CurrentAirQualityUnits = CurrentAirQualityUnits(),
    val current: CurrentAirQuality = CurrentAirQuality(),
    val hourly_units: HourlyAirQualityUnits = HourlyAirQualityUnits(),
    val hourly: HourlyAirQuality = HourlyAirQuality()
)
