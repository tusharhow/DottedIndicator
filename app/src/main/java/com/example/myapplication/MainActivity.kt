package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.dottedindicator.DottedIndicator

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DottedIndicator(
                        dotSize = 25f,
                        isGradient = true,
                        gradientColors = listOf(
                            androidx.compose.ui.graphics.Color(0xFFF12711),
                            androidx.compose.ui.graphics.Color(0xFFF5AF19),
                        ),
                        inactiveGradientColors = listOf(
                           androidx.compose.ui.graphics.Color.Companion.LightGray,
                            androidx.compose.ui.graphics.Color.Companion.LightGray,
                        ),
                    )
                }
            }
        }
    }
}

