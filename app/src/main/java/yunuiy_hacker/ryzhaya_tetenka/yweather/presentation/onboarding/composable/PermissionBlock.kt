package yunuiy_hacker.ryzhaya_tetenka.yweather.presentation.onboarding.composable

import android.graphics.RenderEffect
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PermissionBlock(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String,
    onClick: () -> Unit,
    isGranted: Boolean
) {
    val density = LocalDensity.current

    val roundedCornerShape = RoundedCornerShape(20.dp)

    var height by remember { mutableStateOf(0.dp) }

    Box(
        modifier = modifier
            .clip(roundedCornerShape)
            .onGloballyPositioned {
                height = with(density) { it.size.height.toDp() }
            }) {

        Box(
            modifier = modifier
                .height(height)
                .blur(30.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(height / 2)
                    .background(MaterialTheme.colorScheme.primary)
                    .align(Alignment.TopStart)
            )
            Box(
                modifier = Modifier
                    .size(height / 2)
                    .background(MaterialTheme.colorScheme.primary)
                    .align(Alignment.BottomEnd)
            )
        }
        Row(
            modifier = modifier
                .clip(roundedCornerShape)
                .background(
                    MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f), roundedCornerShape
                )
                .border(
                    width = 0.1.dp,
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.9f),
                    shape = roundedCornerShape
                )
                .clickable {
                    onClick()
                }) {
            Row(
                modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(24.dp))
                Text(
                    text = title,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = if (isGranted) Icons.Rounded.Done else Icons.Rounded.Close,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}