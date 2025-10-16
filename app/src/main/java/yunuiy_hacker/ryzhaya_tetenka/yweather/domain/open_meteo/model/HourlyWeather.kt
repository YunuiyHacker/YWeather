package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.open_meteo.model

data class HourlyWeather(
    val time: List<String> = listOf(),
    val temperature_2m: List<Double> = listOf(),
    val weather_code: List<Int> = listOf(),
    val surface_pressure: List<Double> = listOf(),
    val cloud_cover: List<Int> = listOf(),
    val visibility: List<Int> = listOf(),
    val precipitation: List<Double> = listOf(),
    val precipitation_probability: List<Int> = listOf(),
    val wind_speed_10m: List<Double> = listOf(),
    val soil_temperature_0cm: List<Double> = listOf(),
    val soil_temperature_6cm: List<Double> = listOf(),
    val soil_temperature_18cm: List<Double> = listOf(),
    val soil_temperature_54cm: List<Double> = listOf(),
    val soil_moisture_0_to_1cm: List<Double> = listOf(),
    val soil_moisture_1_to_3cm: List<Double> = listOf(),
    val soil_moisture_3_to_9cm: List<Double> = listOf(),
    val soil_moisture_9_to_27cm: List<Double> = listOf(),
    val soil_moisture_27_to_81cm: List<Double> = listOf(),
    val relative_humidity_2m: List<Int> = listOf(),
    val wind_direction_10m: List<Int> = listOf(),
    val rain: List<Double> = listOf(),
    val showers: List<Double> = listOf(),
    val snowfall: List<Double> = listOf()
)
