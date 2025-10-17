package yunuiy_hacker.ryzhaya_tetenka.yweather.presentation.onboarding

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale
import yunuiy_hacker.ryzhaya_tetenka.yweather.R
import yunuiy_hacker.ryzhaya_tetenka.yweather.nav_graph.Route
import yunuiy_hacker.ryzhaya_tetenka.yweather.presentation.common.composable.TextIconButton
import yunuiy_hacker.ryzhaya_tetenka.yweather.presentation.common.composable.dialog.NeedOpenSettingsDialog
import yunuiy_hacker.ryzhaya_tetenka.yweather.presentation.onboarding.composable.PermissionBlock
import yunuiy_hacker.ryzhaya_tetenka.yweather.ui.theme.Primary

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalPermissionsApi::class)
@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun OnboardingScreen(
    navHostController: NavController, viewModel: OnboardingViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val density = LocalDensity.current
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    var cloudImageWidth by remember { mutableStateOf(0.dp) }
    var cloudImageHeight by remember { mutableStateOf(0.dp) }
    var cloudImageCenter by remember { mutableStateOf(0.dp) }
    var animate by remember(viewModel.state.animate) {
        mutableStateOf(viewModel.state.animate)
    }

    val locationPermissionState =
        rememberPermissionState(permission = Manifest.permission.ACCESS_FINE_LOCATION) { granted ->
            if (granted) {
                viewModel.onEvent(OnboardingEvent.LocationPermissionGrantedEvent)
            }
        }

    val notificationPermissionState =
        rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS) { granted ->
            if (granted) {
                viewModel.onEvent(OnboardingEvent.NotificationPermissionGrantedEvent)
            }
        }

    LaunchedEffect(Unit) {
        viewModel.onEvent(
            OnboardingEvent.LoadDataEvent(
                density, configuration, cloudImageWidth - 80.dp
            )
        )
    }

    viewModel.state.let { state ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Scaffold(modifier = Modifier, bottomBar = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                ) {
                    Spacer(modifier = Modifier.height(12.dp))
                    TextIconButton(
                        text = stringResource(R.string.continue_word),
                        icon = Icons.Rounded.ArrowForward,
                        onClick = {
                            navHostController.navigate(Route.HomeScreen.route)
                        },
                        enabled = locationPermissionState.status.isGranted && notificationPermissionState.status.isGranted
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(it)
                        .padding(horizontal = 24.dp)
                ) {
                    Spacer(modifier = Modifier.height(48.dp))
                    Image(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .align(Alignment.CenterHorizontally)
                            .onGloballyPositioned {
                                cloudImageWidth = with(density) { it.size.width.toDp() }
                                cloudImageHeight = with(density) { it.size.height.toDp() }
                                cloudImageCenter =
                                    (((48.dp + cloudImageHeight) - 48.dp) / 2) + 72.dp
                            },
                        painter = painterResource(R.drawable.cloud),
                        contentDescription = null,
                        alpha = 0f
                    )
                    Spacer(modifier = Modifier.height(48.dp))
                    Text(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Normal,
                        text = buildAnnotatedString {
                            append(stringResource(R.string.welcome_in))
                            withStyle(
                                style = SpanStyle(
                                    color = Primary, fontWeight = FontWeight.Bold
                                )
                            ) {
                                append(
                                    text = " ${stringResource(R.string.app_name)} \uD83D\uDC4B"
                                )
                            }
                        },
                        textAlign = TextAlign.Center,
                        lineHeight = 48.sp
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        text = stringResource(R.string.in_order_to_continue_you_need_to_give_the_following_permissions)
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        item {
                            PermissionBlock(
                                modifier = Modifier.fillMaxWidth(),
                                icon = Icons.Rounded.LocationOn,
                                title = stringResource(R.string.location),
                                onClick = {
                                    if (!locationPermissionState.status.isGranted && !locationPermissionState.status.shouldShowRationale) {
                                        locationPermissionState.launchPermissionRequest()
                                    } else if (!notificationPermissionState.status.isGranted && notificationPermissionState.status.shouldShowRationale) {
                                        viewModel.onEvent(OnboardingEvent.ShowNeedOpenSettingsDialog)
                                    }
                                },
                                isGranted = locationPermissionState.status.isGranted
                            )
                        }
                        item {
                            PermissionBlock(
                                modifier = Modifier.fillMaxWidth(),
                                icon = Icons.Rounded.Notifications,
                                title = stringResource(R.string.notification),
                                onClick = {
                                    if (!notificationPermissionState.status.isGranted && !notificationPermissionState.status.shouldShowRationale) {
                                        notificationPermissionState.launchPermissionRequest()
                                    } else if (!notificationPermissionState.status.isGranted && notificationPermissionState.status.shouldShowRationale) {
                                        viewModel.onEvent(OnboardingEvent.ShowNeedOpenSettingsDialog)
                                    }
                                },
                                isGranted = notificationPermissionState.status.isGranted
                            )
                        }
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .offset(y = cloudImageCenter)
            ) {
                state.snowflakes.forEach {
                    key(it) {
                        var snowflakeStartValue by remember { mutableStateOf(0.dp) }
                        var snowflakeTargetValue by remember { mutableStateOf(screenHeight + 100.dp) }

                        var snowflakeRotateStartValue by remember { mutableStateOf(0) }
                        var snowflakeRotateTargetValue by remember { mutableStateOf(360) }

                        val offset by animateDpAsState(
                            targetValue = if (!animate) snowflakeStartValue else snowflakeTargetValue,
                            animationSpec = tween(
                                if (snowflakeStartValue == 0.dp) it.speed else 0,
                                easing = LinearEasing,
                                delayMillis = it.delayMillis
                            ),
                            finishedListener = {
                                if (it == screenHeight + 100.dp) {
                                    snowflakeStartValue = screenHeight + 100.dp
                                    snowflakeTargetValue = 0.dp
                                } else {
                                    snowflakeStartValue = 0.dp
                                    snowflakeTargetValue = screenHeight + 100.dp
                                }
                            })
                        val rotation by animateIntAsState(
                            targetValue = if (!animate) snowflakeRotateStartValue else snowflakeRotateTargetValue,
                            animationSpec = tween(
                                it.rotationSpeed,
                                easing = LinearEasing,
                                delayMillis = it.delayMillis
                            ),
                            finishedListener = {
                                if (it == snowflakeRotateTargetValue) {
                                    snowflakeRotateStartValue = 360
                                    snowflakeRotateTargetValue = 0
                                } else {
                                    snowflakeRotateStartValue = 0
                                    snowflakeRotateTargetValue = 360
                                }
                            })

                        Icon(
                            modifier = Modifier
                                .size(it.size)
                                .offset(x = it.xOffset, y = offset)
                                .rotate(rotation.toFloat()),
                            painter = painterResource(R.drawable.ic_snowflake),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }
            Image(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .align(Alignment.TopCenter)
                    .offset(y = 60.dp),
                painter = painterResource(R.drawable.cloud),
                contentDescription = null
            )
        }

        if (state.showNeedOpenSettingsDialog) {
            NeedOpenSettingsDialog(onDismissRequest = {
                viewModel.onEvent(OnboardingEvent.HideNeedOpenSettingsDialog)
            }, onGoToRequest = {
                context.startActivity(Intent().apply {
                    action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                    data = Uri.parse("package:${context.packageName}")
                })

                viewModel.onEvent(OnboardingEvent.HideNeedOpenSettingsDialog)
            })
        }
    }
}