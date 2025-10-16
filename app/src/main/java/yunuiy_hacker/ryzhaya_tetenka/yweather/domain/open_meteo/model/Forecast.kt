package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.open_meteo.model

data class Forecast(
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val generationtime_ms: Double = 0.0,
    val utc_offset_seconds: Int = 0,
    val timezone: String = "",
    val timezone_abbreviation: String = "",
    val elevation: Int = 0,
    val current_weather_units: CurrentWeatherUnits = CurrentWeatherUnits(),
    val current: CurrentWeather = CurrentWeather(),
    val hourly_weather_units: HourlyWeatherUnits = HourlyWeatherUnits(),
    val hourly: HourlyWeather = HourlyWeather(),
    val daily_weather_units: DailyWeatherUnits = DailyWeatherUnits(),
    val daily: DailyWeather = DailyWeather()
)
