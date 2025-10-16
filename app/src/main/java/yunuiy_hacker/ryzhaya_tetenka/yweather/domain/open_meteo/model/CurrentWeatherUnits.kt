package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.open_meteo.model

data class CurrentWeatherUnits(
    val time: String = "",
    val interval: String = "",
    val precipitation: String = "",
    val apparent_temperature: String = "",
    val relative_humidity_2m: String = "",
    val temperature_2m: String = "",
    val cloud_cover: String = "",
    val surface_pressure: String = "",
    val wind_speed_10m: String = "",
    val wind_direction_10m: String = "",
    val wind_gusts_10m: String = "",
    val rain: String = "",
    val showers: String = "",
    val snowfall: String = "",
    val is_day: String = "",
    val weather_code: String = ""
)
