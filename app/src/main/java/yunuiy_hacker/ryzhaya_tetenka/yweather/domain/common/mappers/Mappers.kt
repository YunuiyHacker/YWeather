package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.common.mappers

import yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.air_quality.AirQuality
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.air_quality.model.CurrentAirQuality
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.air_quality.model.CurrentAirQualityUnits
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.air_quality.model.HourlyAirQuality
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.air_quality.model.HourlyAirQualityUnits
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.geocode.model.ReverseAddress
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.geocode.model.ReversePlace
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.geocode.model.SearchPlace
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.open_meteo.model.CurrentWeather
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.open_meteo.model.CurrentWeatherUnits
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.open_meteo.model.DailyWeather
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.open_meteo.model.DailyWeatherUnits
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.open_meteo.model.Forecast
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.open_meteo.model.HourlyWeather
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.open_meteo.model.HourlyWeatherUnits
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.xras.model.GeomagneticData
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.xras.model.GeomagneticStorm

//air_quality
fun yunuiy_hacker.ryzhaya_tetenka.yweather.domain.air_quality.model.AirQuality.toData(): AirQuality {
    return AirQuality(
        latitude = latitude,
        longitude = longitude,
        generationtime_ms = generationtime_ms,
        utc_offset_seconds = utc_offset_seconds,
        timezone = timezone,
        timezone_abbreviation = timezone_abbreviation,
        elevation = elevation,
        current_units = current_units.toData(),
        current = current.toData(),
        hourly_units = hourly_units.toData(),
        hourly = hourly.toData()
    )
}

fun AirQuality.toDomain(): yunuiy_hacker.ryzhaya_tetenka.yweather.domain.air_quality.model.AirQuality {
    return yunuiy_hacker.ryzhaya_tetenka.yweather.domain.air_quality.model.AirQuality(
        latitude = latitude ?: 0.0,
        longitude = longitude ?: 0.0,
        generationtime_ms = generationtime_ms ?: 0.0,
        utc_offset_seconds = utc_offset_seconds ?: 0,
        timezone = timezone ?: "",
        timezone_abbreviation = timezone_abbreviation ?: "",
        elevation = elevation ?: 0,
        current_units = current_units?.toDomain() ?: CurrentAirQualityUnits(),
        current = current?.toDomain() ?: CurrentAirQuality(),
        hourly_units = hourly_units?.toDomain() ?: HourlyAirQualityUnits(),
        hourly = hourly?.toDomain() ?: HourlyAirQuality()
    )
}

fun CurrentAirQuality.toData(): yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.air_quality.CurrentAirQuality {
    return yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.air_quality.CurrentAirQuality(
        time = time,
        interval = interval,
        ragweed_pollen = ragweed_pollen,
        olive_pollen = olive_pollen,
        mugwort_pollen = mugwort_pollen,
        grass_pollen = grass_pollen,
        birch_pollen = birch_pollen,
        alder_pollen = alder_pollen,
        us_aqi = us_aqi,
        european_aqi = european_aqi
    )
}

fun yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.air_quality.CurrentAirQuality.toDomain(): CurrentAirQuality {
    return CurrentAirQuality(
        time = time ?: "",
        interval = interval ?: 0,
        ragweed_pollen = ragweed_pollen ?: "",
        olive_pollen = olive_pollen ?: "",
        mugwort_pollen = mugwort_pollen ?: "",
        grass_pollen = grass_pollen ?: "",
        birch_pollen = birch_pollen ?: "",
        alder_pollen = alder_pollen ?: "",
        us_aqi = us_aqi ?: 0,
        european_aqi = european_aqi ?: 0
    )
}

fun CurrentAirQualityUnits.toData(): yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.air_quality.CurrentAirQualityUnits {
    return yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.air_quality.CurrentAirQualityUnits(
        time = time,
        interval = interval,
        ragweed_pollen = ragweed_pollen,
        olive_pollen = olive_pollen,
        mugwort_pollen = mugwort_pollen,
        grass_pollen = grass_pollen,
        birch_pollen = birch_pollen,
        alder_pollen = alder_pollen,
        us_aqi = us_aqi,
        european_aqi = european_aqi
    )
}

fun yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.air_quality.CurrentAirQualityUnits.toDomain(): CurrentAirQualityUnits {
    return CurrentAirQualityUnits(
        time = time ?: "",
        interval = interval ?: "",
        ragweed_pollen = ragweed_pollen ?: "",
        olive_pollen = olive_pollen ?: "",
        mugwort_pollen = mugwort_pollen ?: "",
        grass_pollen = grass_pollen ?: "",
        birch_pollen = birch_pollen ?: "",
        alder_pollen = alder_pollen ?: "",
        us_aqi = us_aqi ?: "",
        european_aqi = european_aqi ?: ""
    )
}

fun HourlyAirQuality.toData(): yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.air_quality.HourlyAirQuality {
    return yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.air_quality.HourlyAirQuality(
        time = time,
        ragweed_pollen = ragweed_pollen,
        olive_pollen = olive_pollen,
        mugwort_pollen = mugwort_pollen,
        grass_pollen = grass_pollen,
        birch_pollen = birch_pollen,
        alder_pollen = alder_pollen
    )
}

fun yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.air_quality.HourlyAirQuality.toDomain(): HourlyAirQuality {
    return HourlyAirQuality(
        time = time ?: listOf(),
        ragweed_pollen = ragweed_pollen ?: listOf(),
        olive_pollen = olive_pollen ?: listOf(),
        mugwort_pollen = mugwort_pollen ?: listOf(),
        grass_pollen = grass_pollen ?: listOf(),
        birch_pollen = birch_pollen ?: listOf(),
        alder_pollen = alder_pollen ?: listOf()
    )
}

fun HourlyAirQualityUnits.toData(): yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.air_quality.HourlyAirQualityUnits {
    return yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.air_quality.HourlyAirQualityUnits(
        time = time,
        ragweed_pollen = ragweed_pollen,
        olive_pollen = olive_pollen,
        mugwort_pollen = mugwort_pollen,
        grass_pollen = grass_pollen,
        birch_pollen = birch_pollen,
        alder_pollen = alder_pollen
    )
}

fun yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.air_quality.HourlyAirQualityUnits.toDomain(): HourlyAirQualityUnits {
    return HourlyAirQualityUnits(
        time = time ?: "",
        ragweed_pollen = ragweed_pollen ?: "",
        olive_pollen = olive_pollen ?: "",
        mugwort_pollen = mugwort_pollen ?: "",
        grass_pollen = grass_pollen ?: "",
        birch_pollen = birch_pollen ?: "",
        alder_pollen = alder_pollen ?: ""
    )
}

//geocode
fun ReverseAddress.toData(): yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.geocode.ReverseAddress {
    return yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.geocode.ReverseAddress(
        village = village,
        county = county,
        state = state,
        ISO3166_2_lvl4 = ISO3166_2_lvl4,
        region = region,
        postcode = postcode,
        country = county,
        country_code = country_code
    )
}

fun yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.geocode.ReverseAddress.toDomain(): ReverseAddress {
    return ReverseAddress(
        village = village ?: "",
        county = county ?: "",
        state = state ?: "",
        ISO3166_2_lvl4 = ISO3166_2_lvl4 ?: "",
        region = region ?: "",
        postcode = postcode ?: "",
        country = county ?: "",
        country_code = country_code ?: ""
    )
}

fun ReversePlace.toData(): yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.geocode.ReversePlace {
    return yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.geocode.ReversePlace(
        place_id = place_id,
        license = license,
        osm_type = osm_type,
        osm_id = osm_id,
        lat = lat,
        lon = lon,
        display_name = display_name,
        address = address.toData(),
        boundingbox = boundingbox
    )
}

fun yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.geocode.ReversePlace.toDomain(): ReversePlace {
    return ReversePlace(
        place_id = place_id ?: 0,
        license = license ?: "",
        osm_type = osm_type ?: "",
        osm_id = osm_id ?: 0,
        lat = lat ?: "",
        lon = lon ?: "",
        display_name = display_name ?: "",
        address = address?.toDomain() ?: ReverseAddress(),
        boundingbox = boundingbox ?: listOf()
    )
}

fun SearchPlace.toData(): yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.geocode.SearchPlace {
    return yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.geocode.SearchPlace(
        place_id = place_id,
        license = license,
        osm_type = osm_type,
        osm_id = osm_id,
        boundingbox = boundingbox,
        lat = lat,
        lon = lon,
        display_name = display_name,
        classs = classs,
        type = type,
        importance = importance
    )
}

fun yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.geocode.SearchPlace.toDomain(): SearchPlace {
    return SearchPlace(
        place_id = place_id ?: 0,
        license = license ?: "",
        osm_type = osm_type ?: "",
        osm_id = osm_id ?: 0,
        boundingbox = boundingbox ?: listOf(),
        lat = lat ?: "",
        lon = lon ?: "",
        display_name = display_name ?: "",
        classs = classs ?: "",
        type = type ?: "",
        importance = importance ?: 0
    )
}

//open_meteo
fun CurrentWeatherUnits.toData(): yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.CurrentWeatherUnits {
    return yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.CurrentWeatherUnits(
        time = time,
        interval = interval,
        precipitation = precipitation,
        apparent_temperature = apparent_temperature,
        relative_humidity_2m = relative_humidity_2m,
        temperature_2m = temperature_2m,
        cloud_cover = cloud_cover,
        surface_pressure = surface_pressure,
        wind_speed_10m = wind_speed_10m,
        wind_direction_10m = wind_direction_10m,
        wind_gusts_10m = wind_gusts_10m,
        rain = rain,
        showers = showers,
        snowfall = snowfall,
        is_day = is_day,
        weather_code = weather_code
    )
}

fun yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.CurrentWeatherUnits.toDomain(): CurrentWeatherUnits {
    return CurrentWeatherUnits(
        time = time ?: "",
        interval = interval ?: "",
        precipitation = precipitation ?: "",
        apparent_temperature = apparent_temperature ?: "",
        relative_humidity_2m = relative_humidity_2m ?: "",
        temperature_2m = temperature_2m ?: "",
        cloud_cover = cloud_cover ?: "",
        surface_pressure = surface_pressure ?: "",
        wind_speed_10m = wind_speed_10m ?: "",
        wind_direction_10m = wind_direction_10m ?: "",
        wind_gusts_10m = wind_gusts_10m ?: "",
        rain = rain ?: "",
        showers = showers ?: "",
        snowfall = snowfall ?: "",
        is_day = is_day ?: "",
        weather_code = weather_code ?: ""
    )
}

fun CurrentWeather.toData(): yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.CurrentWeather {
    return yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.CurrentWeather(
        time = time,
        interval = interval,
        precipitation = precipitation,
        apparent_temperature = apparent_temperature,
        relative_humidity_2m = relative_humidity_2m,
        temperature_2m = temperature_2m,
        cloud_cover = cloud_cover,
        surface_pressure = surface_pressure,
        wind_speed_10m = wind_speed_10m,
        wind_direction_10m = wind_direction_10m,
        wind_gusts_10m = wind_gusts_10m,
        rain = rain,
        showers = showers,
        snowfall = snowfall,
        is_day = is_day,
        weather_code = weather_code
    )
}

fun yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.CurrentWeather.toDomain(): CurrentWeather {
    return CurrentWeather(
        time = time ?: "",
        interval = interval ?: 0,
        precipitation = precipitation ?: 0.0,
        apparent_temperature = apparent_temperature ?: 0.0,
        relative_humidity_2m = relative_humidity_2m ?: 0,
        temperature_2m = temperature_2m ?: 0.0,
        cloud_cover = cloud_cover ?: 0,
        surface_pressure = surface_pressure ?: 0.0,
        wind_speed_10m = wind_speed_10m ?: 0.0,
        wind_direction_10m = wind_direction_10m ?: 0,
        wind_gusts_10m = wind_gusts_10m ?: 0.0,
        rain = rain ?: 0.0,
        showers = showers ?: 0.0,
        snowfall = snowfall ?: 0.0,
        is_day = is_day ?: 0,
        weather_code = weather_code ?: 0
    )
}

fun DailyWeatherUnits.toData(): yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.DailyWeatherUnits {
    return yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.DailyWeatherUnits(
        time = time,
        sunrise = sunrise,
        sunset = sunset,
        daylight_duration = daylight_duration,
        rain_sum = rain_sum,
        weather_code = weather_code,
        uv_index_max = uv_index_max,
        wind_direction_10m_dominant = wind_direction_10m_dominant,
        wind_gusts_10m_max = wind_gusts_10m_max,
        wind_speed_10m_max = wind_speed_10m_max,
        apparent_temperature_max = apparent_temperature_max,
        apparent_temperature_min = apparent_temperature_min,
        showers_sum = showers_sum,
        snowfall_sum = snowfall_sum,
        precipitation_sum = precipitation_sum,
        temperature_2m_max = temperature_2m_max,
        temperature_2m_min = temperature_2m_min
    )
}

fun yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.DailyWeatherUnits.toDomain(): DailyWeatherUnits {
    return DailyWeatherUnits(
        time = time ?: "",
        sunrise = sunrise ?: "",
        sunset = sunset ?: "",
        daylight_duration = daylight_duration ?: "",
        rain_sum = rain_sum ?: "",
        weather_code = weather_code ?: "",
        uv_index_max = uv_index_max ?: "",
        wind_direction_10m_dominant = wind_direction_10m_dominant ?: "",
        wind_gusts_10m_max = wind_gusts_10m_max ?: "",
        wind_speed_10m_max = wind_speed_10m_max ?: "",
        apparent_temperature_max = apparent_temperature_max ?: "",
        apparent_temperature_min = apparent_temperature_min ?: "",
        showers_sum = showers_sum ?: "",
        snowfall_sum = snowfall_sum ?: "",
        precipitation_sum = precipitation_sum ?: "",
        temperature_2m_max = temperature_2m_max ?: "",
        temperature_2m_min = temperature_2m_min ?: ""
    )
}

fun DailyWeather.toData(): yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.DailyWeather {
    return yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.DailyWeather(
        time = time,
        sunrise = sunrise,
        sunset = sunset,
        daylight_duration = daylight_duration,
        rain_sum = rain_sum,
        weather_code = weather_code,
        uv_index_max = uv_index_max,
        wind_direction_10m_dominant = wind_direction_10m_dominant,
        wind_gusts_10m_max = wind_gusts_10m_max,
        wind_speed_10m_max = wind_speed_10m_max,
        apparent_temperature_max = apparent_temperature_max,
        apparent_temperature_min = apparent_temperature_min,
        showers_sum = showers_sum,
        snowfall_sum = snowfall_sum,
        precipitation_sum = precipitation_sum,
        temperature_2m_max = temperature_2m_max,
        temperature_2m_min = temperature_2m_min
    )
}

fun yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.DailyWeather.toDomain(): DailyWeather {
    return DailyWeather(
        time = time ?: listOf(),
        sunrise = sunrise ?: listOf(),
        sunset = sunset ?: listOf(),
        daylight_duration = daylight_duration ?: listOf(),
        rain_sum = rain_sum ?: listOf(),
        weather_code = weather_code ?: listOf(),
        uv_index_max = uv_index_max ?: listOf(),
        wind_direction_10m_dominant = wind_direction_10m_dominant ?: listOf(),
        wind_gusts_10m_max = wind_gusts_10m_max ?: listOf(),
        wind_speed_10m_max = wind_speed_10m_max ?: listOf(),
        apparent_temperature_max = apparent_temperature_max ?: listOf(),
        apparent_temperature_min = apparent_temperature_min ?: listOf(),
        showers_sum = showers_sum ?: listOf(),
        snowfall_sum = snowfall_sum ?: listOf(),
        precipitation_sum = precipitation_sum ?: listOf(),
        temperature_2m_max = temperature_2m_max ?: listOf(),
        temperature_2m_min = temperature_2m_min ?: listOf()
    )
}

fun HourlyWeatherUnits.toData(): yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.HourlyWeatherUnits {
    return yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.HourlyWeatherUnits(
        temperature_2m = temperature_2m,
        weather_code = weather_code,
        surface_pressure = surface_pressure,
        cloud_cover = cloud_cover,
        visibility = visibility,
        precipitation = precipitation,
        precipitation_probability = precipitation_probability,
        wind_speed_10m = wind_speed_10m,
        soil_temperature_0cm = soil_temperature_0cm,
        soil_temperature_6cm = soil_temperature_6cm,
        soil_temperature_18cm = soil_temperature_18cm,
        soil_temperature_54cm = soil_temperature_54cm,
        soil_moisture_0_to_1cm = soil_moisture_0_to_1cm,
        soil_moisture_1_to_3cm = soil_moisture_1_to_3cm,
        soil_moisture_3_to_9cm = soil_moisture_3_to_9cm,
        soil_moisture_9_to_27cm = soil_moisture_9_to_27cm,
        soil_moisture_27_to_81cm = soil_moisture_27_to_81cm,
        relative_humidity_2m = relative_humidity_2m,
        wind_direction_10m = wind_direction_10m,
        rain = rain,
        showers = showers,
        snowfall = snowfall
    )
}

fun yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.HourlyWeatherUnits.toDomain(): HourlyWeatherUnits {
    return HourlyWeatherUnits(
        temperature_2m = temperature_2m ?: "",
        weather_code = weather_code ?: "",
        surface_pressure = surface_pressure ?: "",
        cloud_cover = cloud_cover ?: "",
        visibility = visibility ?: "",
        precipitation = precipitation ?: "",
        precipitation_probability = precipitation_probability ?: "",
        wind_speed_10m = wind_speed_10m ?: "",
        soil_temperature_0cm = soil_temperature_0cm ?: "",
        soil_temperature_6cm = soil_temperature_6cm ?: "",
        soil_temperature_18cm = soil_temperature_18cm ?: "",
        soil_temperature_54cm = soil_temperature_54cm ?: "",
        soil_moisture_0_to_1cm = soil_moisture_0_to_1cm ?: "",
        soil_moisture_1_to_3cm = soil_moisture_1_to_3cm ?: "",
        soil_moisture_3_to_9cm = soil_moisture_3_to_9cm ?: "",
        soil_moisture_9_to_27cm = soil_moisture_9_to_27cm ?: "",
        soil_moisture_27_to_81cm = soil_moisture_27_to_81cm ?: "",
        relative_humidity_2m = relative_humidity_2m ?: "",
        wind_direction_10m = wind_direction_10m ?: "",
        rain = rain ?: "",
        showers = showers ?: "",
        snowfall = snowfall ?: ""
    )
}

fun HourlyWeather.toData(): yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.HourlyWeather {
    return yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.HourlyWeather(
        temperature_2m = temperature_2m,
        weather_code = weather_code,
        surface_pressure = surface_pressure,
        cloud_cover = cloud_cover,
        visibility = visibility,
        precipitation = precipitation,
        precipitation_probability = precipitation_probability,
        wind_speed_10m = wind_speed_10m,
        soil_temperature_0cm = soil_temperature_0cm,
        soil_temperature_6cm = soil_temperature_6cm,
        soil_temperature_18cm = soil_temperature_18cm,
        soil_temperature_54cm = soil_temperature_54cm,
        soil_moisture_0_to_1cm = soil_moisture_0_to_1cm,
        soil_moisture_1_to_3cm = soil_moisture_1_to_3cm,
        soil_moisture_3_to_9cm = soil_moisture_3_to_9cm,
        soil_moisture_9_to_27cm = soil_moisture_9_to_27cm,
        soil_moisture_27_to_81cm = soil_moisture_27_to_81cm,
        relative_humidity_2m = relative_humidity_2m,
        wind_direction_10m = wind_direction_10m,
        rain = rain,
        showers = showers,
        snowfall = snowfall
    )
}

fun yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.HourlyWeather.toDomain(): HourlyWeather {
    return HourlyWeather(
        temperature_2m = temperature_2m ?: listOf(),
        weather_code = weather_code ?: listOf(),
        surface_pressure = surface_pressure ?: listOf(),
        cloud_cover = cloud_cover ?: listOf(),
        visibility = visibility ?: listOf(),
        precipitation = precipitation ?: listOf(),
        precipitation_probability = precipitation_probability ?: listOf(),
        wind_speed_10m = wind_speed_10m ?: listOf(),
        soil_temperature_0cm = soil_temperature_0cm ?: listOf(),
        soil_temperature_6cm = soil_temperature_6cm ?: listOf(),
        soil_temperature_18cm = soil_temperature_18cm ?: listOf(),
        soil_temperature_54cm = soil_temperature_54cm ?: listOf(),
        soil_moisture_0_to_1cm = soil_moisture_0_to_1cm ?: listOf(),
        soil_moisture_1_to_3cm = soil_moisture_1_to_3cm ?: listOf(),
        soil_moisture_3_to_9cm = soil_moisture_3_to_9cm ?: listOf(),
        soil_moisture_9_to_27cm = soil_moisture_9_to_27cm ?: listOf(),
        soil_moisture_27_to_81cm = soil_moisture_27_to_81cm ?: listOf(),
        relative_humidity_2m = relative_humidity_2m ?: listOf(),
        wind_direction_10m = wind_direction_10m ?: listOf(),
        rain = rain ?: listOf(),
        showers = showers ?: listOf(),
        snowfall = snowfall ?: listOf()
    )
}

fun Forecast.toData(): yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.Forecast {
    return yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.Forecast(
        latitude = latitude,
        longitude = longitude,
        generationtime_ms = generationtime_ms,
        utc_offset_seconds = utc_offset_seconds,
        timezone = timezone,
        timezone_abbreviation = timezone_abbreviation,
        elevation = elevation,
        current_units = current_weather_units.toData(),
        current = current.toData(),
        hourly_units = hourly_weather_units.toData(),
        hourly = hourly.toData(),
        daily_units = daily_weather_units.toData(),
        daily = daily.toData()
    )
}

fun yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.open_meteo.Forecast.toDomain(): Forecast {
    return Forecast(
        latitude = latitude ?: 0.0,
        longitude = longitude ?: 0.0,
        generationtime_ms = generationtime_ms ?: 0.0,
        utc_offset_seconds = utc_offset_seconds ?: 0,
        timezone = timezone ?: "",
        timezone_abbreviation = timezone_abbreviation ?: "",
        elevation = elevation ?: 0,
        current_weather_units = current_units?.toDomain() ?: CurrentWeatherUnits(),
        current = current?.toDomain() ?: CurrentWeather(),
        hourly_weather_units = hourly_units?.toDomain() ?: HourlyWeatherUnits(),
        hourly = hourly?.toDomain() ?: HourlyWeather(),
        daily_weather_units = daily_units?.toDomain() ?: DailyWeatherUnits(),
        daily = daily?.toDomain() ?: DailyWeather()
    )
}

//xras
fun GeomagneticData.toData(): yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.xras.GeomagneticData {
    return yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.xras.GeomagneticData(
        time = time, f10 = f10, ap = ap, max_kp = max_kp
    )
}

fun yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.xras.GeomagneticData.toDomain(): GeomagneticData {
    return GeomagneticData(
        time = time ?: "", f10 = f10 ?: "", ap = ap ?: "", max_kp = max_kp ?: ""
    )
}

fun GeomagneticStorm.toData(): yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.xras.GeomagneticStorm {
    return yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.xras.GeomagneticStorm(
        version = version,
        type = type,
        error = error,
        tzone = tzone,
        stime = stime,
        etime = etime,
        kpf_type = kpf_type,
        N = N,
        data = data.map { it.toData() })
}

fun yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.xras.GeomagneticStorm.toDomain(): GeomagneticStorm {
    return GeomagneticStorm(
        version = version ?: "",
        type = type ?: "",
        error = error ?: "",
        tzone = tzone ?: "",
        stime = stime ?: "",
        etime = etime ?: "",
        kpf_type = kpf_type ?: "",
        N = N ?: "",
        data = data?.map { it.toDomain() } ?: listOf())
}