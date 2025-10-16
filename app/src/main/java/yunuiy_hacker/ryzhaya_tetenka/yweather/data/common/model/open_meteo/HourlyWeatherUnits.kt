package yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo

import kotlinx.serialization.Serializable

@Serializable
data class HourlyWeatherUnits(
    val temperature_2m: String? = null,
    val weather_code: String? = null,
    val surface_pressure: String? = null,
    val cloud_cover: String? = null,
    val visibility: String? = null,
    val precipitation: String? = null,
    val precipitation_probability: String? = null,
    val wind_speed_10m: String? = null,
    val soil_temperature_0cm: String? = null,
    val soil_temperature_6cm: String? = null,
    val soil_temperature_18cm: String? = null,
    val soil_temperature_54cm: String? = null,
    val soil_moisture_0_to_1cm: String? = null,
    val soil_moisture_1_to_3cm: String? = null,
    val soil_moisture_3_to_9cm: String? = null,
    val soil_moisture_9_to_27cm: String? = null,
    val soil_moisture_27_to_81cm: String? = null,
    val relative_humidity_2m: String? = null,
    val wind_direction_10m: String? = null,
    val rain: String? = null,
    val showers: String? = null,
    val snowfall: String? = null
)


