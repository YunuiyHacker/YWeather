package yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.geocode

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReverseAddress(
    val village: String? = null,
    val county: String? = null,
    val state: String? = null,
    @SerialName("ISO3166-2-lvl4") val ISO3166_2_lvl4: String? = null,
    val region: String? = null,
    val postcode: String? = null,
    val country: String? = null,
    val country_code: String? = null
)
