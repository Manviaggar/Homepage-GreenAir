package com.example.animation

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.animation.ui.theme.AnimationTheme
import com.example.animation.ui.theme.GradientButton
import com.example.animation.ui.theme.Purple40
import com.example.animation.ui.theme.Purple80
import com.example.animation.ui.theme.PurpleGrey80
import com.example.animation.ui.theme.white

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContent {
            AnimationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = white
                ) {
                       Animated()
                }
            }
        }
    }
}
@Composable
fun Animated() {
    Box(
        modifier=Modifier.fillMaxSize(),
    contentAlignment= Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.backgroundimage3),
            contentDescription = "null",
            modifier=Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha=0.8f
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .fillMaxHeight(),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Greeting()
            Spacer(
                modifier = Modifier
                    .height(40.dp)
            )
            GradientButton(
                text = "Register",
                textColor = white
            )
            Spacer(modifier = Modifier.height(20.dp))
            GradientButton(
                text = "Login",
                textColor = white,
            )
        }
    }
}

@Composable
fun Greeting( ) {
val composition= rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation1))
val progress by animateLottieCompositionAsState(
    composition = composition.value,
       iterations = LottieConstants.IterateForever
    )
    LottieAnimation(modifier=Modifier.size(400.dp),
        composition = composition.value,
        progress = { progress})
    Alignment.Center
    Arrangement.Center
    }


@Composable
fun buttonclick(text:String){
    Button(onClick = { },modifier = Modifier.fillMaxWidth()) {
        Text(text, Modifier.padding(vertical = 8.dp))
        }
}
