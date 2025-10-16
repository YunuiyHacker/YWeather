package yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo

import kotlinx.serialization.Serializable

@Serializable
data class HourlyWeather(
    val time: List<String>? = null,
    val temperature_2m: List<Double>? = null,
    val weather_code: List<Int>? = null,
    val surface_pressure: List<Double>? = null,
    val cloud_cover: List<Int>? = null,
    val visibility: List<Int>? = null,
    val precipitation: List<Double>? = null,
    val precipitation_probability: List<Int>? = null,
    val wind_speed_10m: List<Double>? = null,
    val soil_temperature_0cm: List<Double>? = null,
    val soil_temperature_6cm: List<Double>? = null,
    val soil_temperature_18cm: List<Double>? = null,
    val soil_temperature_54cm: List<Double>? = null,
    val soil_moisture_0_to_1cm: List<Double>? = null,
    val soil_moisture_1_to_3cm: List<Double>? = null,
    val soil_moisture_3_to_9cm: List<Double>? = null,
    val soil_moisture_9_to_27cm: List<Double>? = null,
    val soil_moisture_27_to_81cm: List<Double>? = null,
    val relative_humidity_2m: List<Int>? = null,
    val wind_direction_10m: List<Int>? = null,
    val rain: List<Double>? = null,
    val showers: List<Double>? = null,
    val snowfall: List<Double>? = null
)
