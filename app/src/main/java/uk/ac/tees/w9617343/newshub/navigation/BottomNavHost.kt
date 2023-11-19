package uk.ac.tees.w9617343.newshub.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uk.ac.tees.w9617343.newshub.screens.home.HomeScreen
import uk.ac.tees.w9617343.newshub.screens.AppScreens
import uk.ac.tees.w9617343.newshub.screens.saved.SavedScreen
import uk.ac.tees.w9617343.newshub.screens.search.SearchScreen
import uk.ac.tees.w9617343.newshub.screens.setting.SettingScreen


@Composable
fun BottomNavHost(
    mainNavController:NavHostController,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {


    NavHost(
        navController = navController,
        startDestination = AppScreens.HomeScreen.name,
        modifier = modifier
    ) {

        composable(AppScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(AppScreens.SavedScreen.name) {
            SavedScreen(navController)
        }
        composable(AppScreens.SettingScreen.name) {
            SettingScreen(navController=navController, mainNavController = mainNavController)
        }
        composable(AppScreens.SearchScreen.name) {
            SearchScreen(navController= navController)
        }
    }
}