package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.geocode.model

data class SearchPlace(
    val place_id: Int = 0,
    val license: String = "",
    val osm_type: String = "",
    val osm_id: Int = 0,
    val boundingbox: List<String> = listOf(),
    val lat: String = "",
    val lon: String = "",
    val display_name: String = "",
    val classs: String = "",
    val type: String = "",
    val importance: Int = 0
)