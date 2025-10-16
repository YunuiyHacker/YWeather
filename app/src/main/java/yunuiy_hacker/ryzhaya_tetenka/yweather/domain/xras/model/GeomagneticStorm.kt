package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.xras.model

data class GeomagneticStorm(
    val version: String = "",
    val type: String = "",
    val error: String = "",
    val tzone: String = "",
    val stime: String = "",
    val etime: String = "",
    val kpf_type: String = "",
    val N: String = "",
    val data: List<GeomagneticData> = listOf()
)
