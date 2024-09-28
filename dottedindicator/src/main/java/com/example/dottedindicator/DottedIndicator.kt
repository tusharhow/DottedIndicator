package com.example.dottedindicator


import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Surface
import androidx.compose.ui.draw.alpha

@Composable
fun DottedIndicator(
    dotColor: Color = Color.Gray,
    backgroundColor: Color = Color(0xFFE0E0E0),
    dotSize: Float = 8f,
    dotCount: Int = 3,
    durationMillis: Int = 300,
    padding: Float = 10f,
    borderRadius: RoundedCornerShape =  RoundedCornerShape(12.dp),
    dotSpacing: Float = 4f,
    isGradient: Boolean = false,
    gradientColors: List<Color> = listOf(Color.Gray, Color.Gray),
    inactiveDotColor: Color? = null,
    inactiveGradientColors: List<Color> = listOf(Color.LightGray, Color.Gray)
) {
    val transition = rememberInfiniteTransition()
    val dotStates = List(dotCount) { index ->
        transition.animateFloat(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = keyframes {
                    this.durationMillis = dotCount * durationMillis
                    0f at index * durationMillis
                    1f at (index + 1) * durationMillis
                    1f at dotCount * durationMillis
                    0f at dotCount * durationMillis + 1
                },
                repeatMode = RepeatMode.Restart
            ), label = ""
        )
    }

    Surface(
        color = backgroundColor,
        shape = borderRadius,
        modifier = Modifier.padding(padding.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(padding.dp)
        ) {
            dotStates.forEachIndexed { index, animatedValue ->
                if (index > 0) {
                    Spacer(modifier = Modifier.width(dotSpacing.dp))
                }

                Box(
                    modifier = Modifier
                        .size(dotSize.dp)
                        .clip(CircleShape)
                ) {
                    // Inactive dot
                    Surface(
                        color = inactiveDotColor ?: Color.Transparent,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        if (inactiveDotColor == null) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        Brush.horizontalGradient(inactiveGradientColors)
                                    )
                            )
                        }
                    }

                    // Active dot
                    Surface(
                        color = if (!isGradient) dotColor else Color.Transparent,
                        modifier = Modifier
                            .fillMaxSize()
                            .alpha(animatedValue.value)
                    ) {
                        if (isGradient) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        Brush.horizontalGradient(gradientColors)
                                    )
                            )
                        }
                    }
                }
            }
        }
    }
}