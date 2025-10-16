package yunuiy_hacker.ryzhaya_tetenka.yweather.presentation.home

import android.Manifest
import android.content.Context
import androidx.annotation.RequiresPermission
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.air_quality.use_case.AirQualityUseCase
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.common.mappers.toDomain
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.geocode.GeocodeUseCase
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.open_meteo.OpenMeteoUseCase
import yunuiy_hacker.ryzhaya_tetenka.yweather.domain.xras.use_case.XrasUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val geocodeUseCase: GeocodeUseCase,
    private val openMeteoUseCase: OpenMeteoUseCase,
    private val airQualityUseCase: AirQualityUseCase,
    private val xrasUseCase: XrasUseCase
) : ViewModel() {
    val state by mutableStateOf(HomeState())

    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.LoadDataEvent -> loadData()
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    private fun loadData() {
        state.contentState.isLoading.value = true

        var lat by mutableStateOf("")
        var lon by mutableStateOf("")

        GlobalScope.launch(Dispatchers.IO) {
            runBlocking {
                try {
                    val fusedLocationClient =
                        LocationServices.getFusedLocationProviderClient(context)

                    fusedLocationClient.lastLocation.addOnSuccessListener {
                        lat = it.latitude.toString()
                        lon = it.longitude.toString()
                    }.continueWith {
                        GlobalScope.launch(Dispatchers.IO) {
                            runBlocking {
                                try {
                                    if (lat.isNotEmpty() && lon.isNotEmpty()) {
                                        state.userPlace = geocodeUseCase.reverseOperator(
                                            lat = lat, lon = lon
                                        )?.toDomain()!!

                                        state.forecast = openMeteoUseCase.getForecastOperator(
                                            lat = lat, lon = lon
                                        )?.toDomain()!!

                                        state.airQuality = airQualityUseCase.getAirQualityOperator(
                                            lat = lat, lon = lon
                                        )?.toDomain()!!

                                        state.geomagneticStorm =
                                            xrasUseCase.getGeomagneticStormOperator()?.toDomain()!!
                                    }
                                } catch (e: Exception) {
                                    state.contentState.isLoading.value = false
                                }
                            }
                        }
                    }

                    state.contentState.isLoading.value = false
                } catch (e: Exception) {
                    state.contentState.isLoading.value = false
                }
            }
        }
    }
}