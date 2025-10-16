package yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo

import kotlinx.serialization.Serializable

@Serializable
data class DailyWeather(
    val time: List<String>? = null,
    val sunrise: List<String>? = null,
    val sunset: List<String>? = null,
    val daylight_duration: List<Double>? = null,
    val rain_sum: List<Double>? = null,
    val weather_code: List<Int>? = null,
    val uv_index_max: List<Double>? = null,
    val wind_direction_10m_dominant: List<Int>? = null,
    val wind_gusts_10m_max: List<Double>? = null,
    val wind_speed_10m_max: List<Double>? = null,
    val apparent_temperature_max: List<Double>? = null,
    val apparent_temperature_min: List<Double>? = null,
    val showers_sum: List<Double>? = null,
    val snowfall_sum: List<Double>? = null,
    val precipitation_sum: List<Double>? = null,
    val temperature_2m_max: List<Double>? = null,
    val temperature_2m_min: List<Double>? = null
)
