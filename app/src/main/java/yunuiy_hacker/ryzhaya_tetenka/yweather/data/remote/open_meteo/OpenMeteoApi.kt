package yunuiy_hacker.ryzhaya_tetenka.yweather.data.remote.open_meteo

import retrofit2.http.GET
import retrofit2.http.Query
import yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.Forecast

interface OpenMeteoApi {
    @GET("forecast")
    suspend fun forecast(
        @Query("latitude") lat: String, @Query("longitude") lon: String,
        @Query("daily") daily: String = "sunrise,sunset,daylight_duration,rain_sum,weather_code,uv_index_max,wind_direction_10m_dominant,wind_gusts_10m_max,wind_speed_10m_max,apparent_temperature_max,apparent_temperature_min,showers_sum,snowfall_sum,precipitation_sum,temperature_2m_max,temperature_2m_min",
        @Query("hourly") hourly: String = "temperature_2m,weather_code,surface_pressure,cloud_cover,visibility,precipitation,precipitation_probability,wind_speed_10m,soil_temperature_0cm,soil_temperature_6cm,soil_temperature_18cm,soil_temperature_54cm,soil_moisture_0_to_1cm,soil_moisture_1_to_3cm,soil_moisture_3_to_9cm,soil_moisture_9_to_27cm,soil_moisture_27_to_81cm,relative_humidity_2m,wind_direction_10m,rain,showers,snowfall",
        @Query("current") current: String = "precipitation,apparent_temperature,relative_humidity_2m,temperature_2m,cloud_cover,surface_pressure,wind_speed_10m,wind_direction_10m,wind_gusts_10m,rain,showers,snowfall,is_day,weather_code",
        @Query("timezone") timezone: String = "auto",
        @Query("past_days") past_days: Int = 1,
        @Query("wind_speed_unit") wind_speed_unit: String = "ms"
    ): Forecast?
}