package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.open_meteo.model

data class DailyWeatherUnits(
    val time: String = "",
    val sunrise: String = "",
    val sunset: String = "",
    val daylight_duration: String = "",
    val rain_sum: String = "",
    val weather_code: String = "",
    val uv_index_max: String = "",
    val wind_direction_10m_dominant: String = "",
    val wind_gusts_10m_max: String = "",
    val wind_speed_10m_max: String = "",
    val apparent_temperature_max: String = "",
    val apparent_temperature_min: String = "",
    val showers_sum: String = "",
    val snowfall_sum: String = "",
    val precipitation_sum: String = "",
    val temperature_2m_max: String = "",
    val temperature_2m_min: String = ""
)
