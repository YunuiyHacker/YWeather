package yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo

import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeather(
    val time: String? = null,
    val interval: Int? = null,
    val precipitation: Double? = null,
    val apparent_temperature: Double? = null,
    val relative_humidity_2m: Int? = null,
    val temperature_2m: Double? = null,
    val cloud_cover: Int? = null,
    val surface_pressure: Double? = null,
    val wind_speed_10m: Double? = null,
    val wind_direction_10m: Int? = null,
    val wind_gusts_10m: Double? = null,
    val rain: Double? = null,
    val showers: Double? = null,
    val snowfall: Double? = null,
    val is_day: Int? = null,
    val weather_code: Int? = null
)
