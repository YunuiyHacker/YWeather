package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.open_meteo.model

data class HourlyWeatherUnits(
    val temperature_2m: String = "",
    val weather_code: String = "",
    val surface_pressure: String = "",
    val cloud_cover: String = "",
    val visibility: String = "",
    val precipitation: String = "",
    val precipitation_probability: String = "",
    val wind_speed_10m: String = "",
    val soil_temperature_0cm: String = "",
    val soil_temperature_6cm: String = "",
    val soil_temperature_18cm: String = "",
    val soil_temperature_54cm: String = "",
    val soil_moisture_0_to_1cm: String = "",
    val soil_moisture_1_to_3cm: String = "",
    val soil_moisture_3_to_9cm: String = "",
    val soil_moisture_9_to_27cm: String = "",
    val soil_moisture_27_to_81cm: String = "",
    val relative_humidity_2m: String = "",
    val wind_direction_10m: String = "",
    val rain: String = "",
    val showers: String = "",
    val snowfall: String = ""
)


