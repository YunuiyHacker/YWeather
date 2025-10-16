package yunuiy_hacker.ryzhaya_tetenka.yweather.data.remote.geocode

import retrofit2.http.GET
import retrofit2.http.Query
import yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.geocode.ReversePlace
import yunuiy_hacker.ryzhaya_tetenka.yweather.data.common.model.geocode.SearchPlace

interface GeocodeApi {
    @GET("/reverse")
    suspend fun reverse(
        @Query("api_key") apiKey: String,
        @Query("lat") lat: String,
        @Query("lon") lon: String
    ): ReversePlace?

    @GET("/search")
    suspend fun search(
        @Query("api_key") apiKey: String,
        @Query("q") q: String
    ): List<SearchPlace>?
}