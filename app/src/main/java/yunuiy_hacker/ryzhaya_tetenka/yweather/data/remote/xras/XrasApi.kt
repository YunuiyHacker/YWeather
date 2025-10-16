package yunuiy_hacker.ryzhaya_tetenka.yweather.data.remote.xras

import retrofit2.http.GET
import yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.xras.GeomagneticStorm

interface XrasApi {
    @GET("txt/kpfl_L59E.json")
    suspend fun getGeomagneticStormForecastForMonth(): GeomagneticStorm?
}