package yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo

import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherUnits(
    val time: String? = null,
    val interval: String? = null,
    val precipitation: String? = null,
    val apparent_temperature: String? = null,
    val relative_humidity_2m: String? = null,
    val temperature_2m: String? = null,
    val cloud_cover: String? = null,
    val surface_pressure: String? = null,
    val wind_speed_10m: String? = null,
    val wind_direction_10m: String? = null,
    val wind_gusts_10m: String? = null,
    val rain: String? = null,
    val showers: String? = null,
    val snowfall: String? = null,
    val is_day: String? = null,
    val weather_code: String? = null
)
