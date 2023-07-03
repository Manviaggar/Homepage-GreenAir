package com.example.animation.ui.theme

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.animation.R

@Composable
fun GradientButton(
    text:String,
    textColor: Color
){
    Button(
        colors=ButtonDefaults.buttonColors(Color.Transparent),
        contentPadding = PaddingValues(),
        onClick = { })
    {
        Box(modifier = Modifier
            .background(Pink80)
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center) {
               Text(text = text,color=textColor)
        }
    }
}

@Composable
fun Greeting( ) {
    val transition= rememberInfiniteTransition()
    val compose by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.ani))
    var isplaying by remember{ mutableStateOf(true) }

    val playing by animateLottieCompositionAsState(
        composition = compose,
        isPlaying = isplaying)
    LaunchedEffect(key1 = playing ){
        if(playing==0f)
        {
            isplaying=true
        }

    }
    LottieAnimation(modifier=Modifier,
        composition = compose,
        progress={ playing}
    )


}