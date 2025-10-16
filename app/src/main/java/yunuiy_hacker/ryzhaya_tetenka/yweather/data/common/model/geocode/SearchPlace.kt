package yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.geocode

import kotlinx.serialization.SerialName

data class SearchPlace(
    val place_id: Int? = null,
    val license: String? = null,
    val osm_type: String? = null,
    val osm_id: Int? = null,
    val boundingbox: List<String>? = null,
    val lat: String? = null,
    val lon: String? = null,
    val display_name: String? = null,
    @SerialName("class") val classs: String? = null,
    val type: String? = null,
    val importance: Int? = null
)