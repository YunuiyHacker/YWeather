package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.geocode.model

data class ReversePlace(
    val place_id: Int = 0,
    val license: String = "",
    val osm_type: String = "",
    val osm_id: Int = 0,
    val lat: String = "",
    val lon: String = "",
    val display_name: String = "",
    val address: ReverseAddress = ReverseAddress(),
    val boundingbox: List<String> = listOf(),
)