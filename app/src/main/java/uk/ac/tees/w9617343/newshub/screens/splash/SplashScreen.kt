package uk.ac.tees.w9617343.newshub.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import uk.ac.tees.w9617343.newshub.R
import uk.ac.tees.w9617343.newshub.navigation.AppGraphs
import uk.ac.tees.w9617343.newshub.screens.AppScreens
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

@Composable
fun SplashScreen (navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Lottie(
            modifier = Modifier
                .size(250.dp)
                .align(Alignment.Center)
        )
    }


    LaunchedEffect(key1 = true) {
        delay(2500L)
        FirebaseAuth.getInstance().signOut()
        if (FirebaseAuth.getInstance().currentUser != null) {
            navController.navigate(AppGraphs.Main.name) {
                popUpTo(AppScreens.SplashScreen.name) {
                    inclusive = true
                }
            }
        } else {
            navController.navigate(AppGraphs.Auth.name) {
                popUpTo(AppScreens.SplashScreen.name) {
                    inclusive = true
                }
            }
        }

    }

}

@Composable
fun Lottie(modifier: Modifier = Modifier) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.splash_lottie))
    LottieAnimation(
        composition = composition,
        iterations = 1,
        modifier = modifier,
        speed = 2f
    )
}