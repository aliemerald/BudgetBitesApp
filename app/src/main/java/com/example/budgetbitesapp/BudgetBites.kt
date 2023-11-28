package com.example.budgetbitesapp

import android.app.Activity
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.budgetbites.R

@Composable
fun BudgetBitesNavigation(
    navController: NavHostController = rememberNavController(),
    padding: PaddingValues,
    context: Activity
) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.Login.route,
        modifier = Modifier.padding(padding)
    ) {
        composable(ScreenRoutes.Login.route) {
            LoginScreen(onLoginButtonClicked = {
                navController.navigate(ScreenRoutes.BottomBar.route) // CHANGES BUTTON END LOCATION
            },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        dimensionResource(R.dimen.padding_medium)
                    )
            )
        }
        navigation(
            route = ScreenRoutes.BottomBar.route,
            startDestination = BottomBarRoutes.Home.routes
        ) {
            composable(BottomBarRoutes.Home.routes) {
                HomeScreen(navController)
            }
            composable(BottomBarRoutes.Favourites.routes) {
                FavouritesScreen(navController)
            }
            composable(BottomBarRoutes.Profile.routes) {
                UserProfileScreen(navController)
            }
            composable(BottomBarRoutes.Search.routes) {
                SearchScreen(modifier = Modifier, navController)
            }
            composable(BottomBarRoutes.Map.routes) {
                MapScreen()
            }
        }
        composable(ScreenRoutes.Restaurant.route) {
            RestaurantProfileScreen(navController) {
                navController.popBackStack()
            }
        }
        composable(ScreenRoutes.WriteReview.route) {
            ReviewWritingScreen(navController) {
                navController.popBackStack()
            }
        }
        composable(ScreenRoutes.ReviewCheck.route) {
            ReviewCardChecker(navController) {
                navController.popBackStack()
            }
        }
    }
}
sealed class ScreenRoutes(val route: String) {
    data object Login : ScreenRoutes("/login")
    data object BottomBar : ScreenRoutes("/bottombar")
    data object Restaurant : ScreenRoutes("/restaurantprofile")
    data object WriteReview : ScreenRoutes("/reviewwriting")
    data object ReviewCheck : ScreenRoutes("/reviewcardchecker")
}

enum class BottomBarRoutes(
    val id: Int,
    @StringRes val title: Int,
    val routes: String,
    val icon: ImageVector
) {
    Map(5, R.string.bbs_5, "/map", Icons.Default.LocationOn),
    Search(4, R.string.bbs_4, "/search", Icons.Default.Search),
    Home(1, R.string.bbs_1, "/home", Icons.Default.Home),
    Favourites(2, R.string.bbs_2, "/notification", Icons.Default.Star),
    Profile(3, R.string.bbs_3, "/profile", Icons.Default.Person)
}