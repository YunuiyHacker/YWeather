package yunuiy_hacker.ryzhaya_tetenka.yweather.domain.geocode.model

data class ReverseAddress(
    val village: String = "",
    val county: String = "",
    val state: String = "",
    val ISO3166_2_lvl4: String = "",
    val region: String = "",
    val postcode: String = "",
    val country: String = "",
    val country_code: String = ""
)
