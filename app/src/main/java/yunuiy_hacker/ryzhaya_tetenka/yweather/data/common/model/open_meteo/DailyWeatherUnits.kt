package yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo

import kotlinx.serialization.Serializable

@Serializable
data class DailyWeatherUnits(
    val time: String? = null,
    val sunrise: String? = null,
    val sunset: String? = null,
    val daylight_duration: String? = null,
    val rain_sum: String? = null,
    val weather_code: String? = null,
    val uv_index_max: String? = null,
    val wind_direction_10m_dominant: String? = null,
    val wind_gusts_10m_max: String? = null,
    val wind_speed_10m_max: String? = null,
    val apparent_temperature_max: String? = null,
    val apparent_temperature_min: String? = null,
    val showers_sum: String? = null,
    val snowfall_sum: String? = null,
    val precipitation_sum: String? = null,
    val temperature_2m_max: String? = null,
    val temperature_2m_min: String? = null
)
