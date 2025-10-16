package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.open_meteo.model

data class DailyWeather(
    val time: List<String> = listOf(),
    val sunrise: List<String> = listOf(),
    val sunset: List<String> = listOf(),
    val daylight_duration: List<Double> = listOf(),
    val rain_sum: List<Double> = listOf(),
    val weather_code: List<Int> = listOf(),
    val uv_index_max: List<Double> = listOf(),
    val wind_direction_10m_dominant: List<Int> = listOf(),
    val wind_gusts_10m_max: List<Double> = listOf(),
    val wind_speed_10m_max: List<Double> = listOf(),
    val apparent_temperature_max: List<Double> = listOf(),
    val apparent_temperature_min: List<Double> = listOf(),
    val showers_sum: List<Double> = listOf(),
    val snowfall_sum: List<Double> = listOf(),
    val precipitation_sum: List<Double> = listOf(),
    val temperature_2m_max: List<Double> = listOf(),
    val temperature_2m_min: List<Double> = listOf()
)
