package yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo

import kotlinx.serialization.Serializable

@Serializable
data class Forecast(
    val latitude: Double? = null,
    val longitude: Double? = null,
    val generationtime_ms: Double? = null,
    val utc_offset_seconds: Int? = null,
    val timezone: String? = null,
    val timezone_abbreviation: String? = null,
    val elevation: Int? = null,
    val current_units: CurrentWeatherUnits? = null,
    val current: CurrentWeather? = null,
    val hourly_units: HourlyWeatherUnits? = null,
    val hourly: HourlyWeather? = null,
    val daily_units: DailyWeatherUnits? = null,
    val daily: DailyWeather? = null
)
