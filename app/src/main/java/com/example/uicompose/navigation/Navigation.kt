package com.example.uicompose.navigation

import Setting
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.uicompose.view.Detail
import com.example.uicompose.view.Home
import com.example.uicompose.view.LoginScreen
import com.example.uicompose.view.MainDashboard
import com.example.uicompose.view.Notification
import com.example.uicompose.view.Profile

@Composable
fun NavigationRoute(navController: NavHostController) {
	NavHost(navController = navController, startDestination = ScreenRoute.LOGIN.name) {

		composable(ScreenRoute.LOGIN.name) {
			LoginScreen(navController = navController)
		}
		composable(ScreenRoute.HOME.name) {
			Home(nanController = navController)
		}
		composable(ScreenRoute.PROFILE.name) {
			Profile(navController = navController)
		}
		composable(ScreenRoute.NOTIFICATION.name) {
			Notification(navController = navController)
		}
		composable(ScreenRoute.SETTING.name) {
			Setting(navController = navController)
		}
		composable(ScreenRoute.MAIN_DASHBOARD.name) {
			MainDashboard(navController = navController)
		}
		composable(
			"${ScreenRoute.DETAIL.name}{message}",
			arguments = listOf(navArgument("message") { type = NavType.StringType })
		) {
			val itemId = it.arguments?.getString("message")
			Detail(nanController = navController, itemId.toString())
		}

		composable(
			ScreenRoute.SCREEN_B.name,
			arguments = listOf(navArgument("userId") { type = NavType.StringType })
		) {
			val itemId = it.arguments?.getString("userId")
			Detail(nanController = navController, itemId.toString())
		}
	}
}