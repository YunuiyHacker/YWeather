package yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.geocode

import kotlinx.serialization.Serializable

@Serializable
data class ReversePlace(
    val place_id: Int? = null,
    val license: String? = null,
    val osm_type: String? = null,
    val osm_id: Int? = null,
    val lat: String? = null,
    val lon: String? = null,
    val display_name: String? = null,
    val address: ReverseAddress? = null,
    val boundingbox: List<String>? = null,
)