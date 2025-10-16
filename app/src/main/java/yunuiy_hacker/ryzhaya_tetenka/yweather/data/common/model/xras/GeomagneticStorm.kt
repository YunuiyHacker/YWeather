package yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.xras

import kotlinx.serialization.Serializable

@Serializable
data class GeomagneticStorm(
    val version: String? = null,
    val type: String? = null,
    val error: String? = null,
    val tzone: String? = null,
    val stime: String? = null,
    val etime: String? = null,
    val kpf_type: String? = null,
    val N: String? = null,
    val data: List<GeomagneticData>? = null
)
