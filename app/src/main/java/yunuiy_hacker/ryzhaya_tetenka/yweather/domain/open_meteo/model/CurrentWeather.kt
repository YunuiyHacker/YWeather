package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.open_meteo.model

data class CurrentWeather(
    val time: String = "",
    val interval: Int = 0,
    val precipitation: Double = 0.0,
    val apparent_temperature: Double = 0.0,
    val relative_humidity_2m: Int = 0,
    val temperature_2m: Double = 0.0,
    val cloud_cover: Int = 0,
    val surface_pressure: Double = 0.0,
    val wind_speed_10m: Double = 0.0,
    val wind_direction_10m: Int = 0,
    val wind_gusts_10m: Double = 0.0,
    val rain: Double = 0.0,
    val showers: Double = 0.0,
    val snowfall: Double = 0.0,
    val is_day: Int = 0,
    val weather_code: Int = 0
)
