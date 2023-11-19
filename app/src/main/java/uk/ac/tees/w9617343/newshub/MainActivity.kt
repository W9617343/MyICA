package uk.ac.tees.w9617343.newshub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import uk.ac.tees.w9617343.newshub.navigation.AppGraphs
import uk.ac.tees.w9617343.newshub.screens.AppScreens
import uk.ac.tees.w9617343.newshub.screens.auth.CreateAccountScreen
import uk.ac.tees.w9617343.newshub.screens.auth.LogInScreen
import uk.ac.tees.w9617343.newshub.screens.main.MainScreen
import uk.ac.tees.w9617343.newshub.screens.splash.SplashScreen
import uk.ac.tees.w9617343.newshub.ui.theme.FireNewsTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FireNewsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    TransparentSystemBars()
                    AppNavigation()
                }
            }
        }
    }

}

@Composable
fun TransparentSystemBars() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    val isDarkTheme = isSystemInDarkTheme()
    SideEffect {
        if (isDarkTheme) {
            systemUiController.setSystemBarsColor(
                color = Color.Black,
                darkIcons = useDarkIcons
            )
        } else {
            systemUiController.setSystemBarsColor(
                color = Color.Transparent,
                darkIcons = useDarkIcons
            )
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.name) {
        composable(AppScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        navigation(startDestination = AppScreens.LogInScreen.name, route = AppGraphs.Auth.name) {
            composable(AppScreens.LogInScreen.name) {
                LogInScreen(navController = navController)
            }
            composable(AppScreens.CreateAccountScreen.name) {
                CreateAccountScreen(navController = navController)
            }
        }
        navigation(startDestination = AppScreens.MainScreen.name, route = AppGraphs.Main.name) {
            composable(AppScreens.MainScreen.name) {
                MainScreen(mainNavController = navController)
            }
        }
    }
}
