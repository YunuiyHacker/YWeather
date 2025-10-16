package yunuiy_hacker.ryzhaya_tetenka.yweather.presentation.home

sealed class HomeEvent {
    data object LoadDataEvent : HomeEvent()
}