package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.xras.use_case

import yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.xras.GeomagneticStorm
import yunuiy_hacker.ryzhaya_tetenka.yweather.data.remote.xras.XrasApi

class GetGeomagneticStormOperator(private val xrasApi: XrasApi) {
    suspend operator fun invoke(): GeomagneticStorm? {
        return xrasApi.getGeomagneticStormForecastForMonth()
    }
}