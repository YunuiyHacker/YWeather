package yunuiy_hacker.ryzhaya_tetenka.yweather.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import yunuiy_hacker.ryzhaya_tetenka.yweather.BuildConfig
import yunuiy_hacker.ryzhaya_tetenka.yweather.data.remote.air_quality.AirQualityApi
import yunuiy_hacker.ryzhaya_tetenka.yweather.data.remote.geocode.GeocodeApi
import yunuiy_hacker.ryzhaya_tetenka.yweather.data.remote.open_meteo.OpenMeteoApi
import yunuiy_hacker.ryzhaya_tetenka.yweather.data.remote.xras.XrasApi
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.air_quality.use_case.AirQualityUseCase
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.air_quality.use_case.GetAirQualityOperator
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.geocode.GeocodeUseCase
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.geocode.ReverseOperator
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.geocode.SearchOperator
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.open_meteo.GetForecastOperator
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.open_meteo.OpenMeteoUseCase
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.xras.use_case.GetGeomagneticStormOperator
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.xras.use_case.XrasUseCase
import yunuiy_hacker.ryzhaya_tetenka.yweather.utils.Constants
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(Constants.CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(Constants.READ_TIMEOUT, TimeUnit.MILLISECONDS).writeTimeout(
                Constants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS
            ).build()
    }

    @Provides
    @Singleton
    fun provideGeocodeApi(okHttpClient: OkHttpClient): GeocodeApi {
        return Retrofit.Builder().baseUrl(BuildConfig.GEOCODE_URL).client(okHttpClient)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
            .create(GeocodeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideOpenMeteoApi(okHttpClient: OkHttpClient): OpenMeteoApi {
        return Retrofit.Builder().baseUrl(BuildConfig.OPEN_METEO_URL).client(okHttpClient)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
            .create(OpenMeteoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAirQualityApi(okHttpClient: OkHttpClient): AirQualityApi {
        return Retrofit.Builder().baseUrl(BuildConfig.AIR_QUALITY_URL).client(okHttpClient)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
            .create(AirQualityApi::class.java)
    }

    @Provides
    @Singleton
    fun provideXrasApi(okHttpClient: OkHttpClient): XrasApi {
        return Retrofit.Builder().baseUrl(BuildConfig.XRAS_URL).client(okHttpClient)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
            .create(XrasApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGeocodeUseCase(geocodeApi: GeocodeApi): GeocodeUseCase {
        return GeocodeUseCase(
            reverseOperator = ReverseOperator(geocodeApi),
            searchOperator = SearchOperator(geocodeApi)
        )
    }

    @Provides
    @Singleton
    fun provideOpenMeteoUseCase(openMeteoApi: OpenMeteoApi): OpenMeteoUseCase {
        return OpenMeteoUseCase(getForecastOperator = GetForecastOperator(openMeteoApi))
    }

    @Provides
    @Singleton
    fun provideAirQualityUseCase(airQualityApi: AirQualityApi): AirQualityUseCase {
        return AirQualityUseCase(getAirQualityOperator = GetAirQualityOperator(airQualityApi))
    }

    @Provides
    @Singleton
    fun provideXrasUseCase(xrasApi: XrasApi): XrasUseCase {
        return XrasUseCase(getGeomagneticStormOperator = GetGeomagneticStormOperator(xrasApi))
    }
}