package yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.xras

import kotlinx.serialization.Serializable

@Serializable
data class GeomagneticData(
    val time: String? = null,
    val f10: String? = null,
    val ap: String? = null,
    val max_kp: String? = null
)
