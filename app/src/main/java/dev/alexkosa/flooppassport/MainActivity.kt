package dev.alexkosa.flooppassport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.alexkosa.flooppassport.ui.designsystem.FlopColors
import dev.alexkosa.flooppassport.ui.designsystem.FlopType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier.fillMaxSize().background(FlopColors.Base),
                contentAlignment = Alignment.Center,
            ) {
                Text("FLOOP PASSPORT", style = FlopType.h2, color = FlopColors.IceWhite)
            }
        }
    }
}
