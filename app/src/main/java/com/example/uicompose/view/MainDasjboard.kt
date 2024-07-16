package com.example.uicompose.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import com.example.uicompose.BottomNavItem
import com.example.uicompose.navigation.ScreenRoute

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainDashboard(navController: NavHostController) {
	val scope = rememberCoroutineScope()
	Scaffold(
		modifier = Modifier
			.fillMaxSize()
			.background(color = Color.Cyan),
		topBar = {
			MyAppBar(title = "Compose Build UI")
		},
		bottomBar = { MyBottomAppBar(navController = navController) }) {
		Greeting(navController = navController)

	}

}

@Composable
fun Greeting(modifier: Modifier = Modifier, navController: NavHostController) {
	Box(
		modifier = Modifier
			.fillMaxSize()
			.background(color = Color.Cyan)
	) {
		Column {
			// NavigationRoute(navController = navController)
		}
	}
}

@Composable
fun MyBottomAppBar(navController: NavHostController) {
	val item = listOf(
		BottomNavItem.Home,
		BottomNavItem.Profile,
		BottomNavItem.Notification,
		BottomNavItem.Setting,
	)
	BottomAppBar(
		actions =
		{
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween
			) {
				item.forEach {
					IconButton(onClick = {
						println("This is route: ${it.route}")
						when (it.route) {
							ScreenRoute.DETAIL.name -> {
								navController.navigate(ScreenRoute.DETAIL.name)
							}

							ScreenRoute.HOME.name -> {
								navController.navigate(ScreenRoute.HOME.name)
							}

							ScreenRoute.SETTING.name -> {
								navController.navigate(ScreenRoute.SETTING.name)
							}

							ScreenRoute.PROFILE.name -> {
								navController.navigate(ScreenRoute.PROFILE.name)
							}

							ScreenRoute.NOTIFICATION.name -> {
								navController.navigate(ScreenRoute.NOTIFICATION.name)
							}

							else -> {
								///
							}
						}
						// navController.navigate(it.route)
					}) {
						Icon(
							imageVector = it.icon,
							contentDescription = it.contentDescription
						)
					}
				}
			}
		}
	)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppBar(
	title: String,
	navigationIcon: ImageVector? = null,
	actions: @Composable RowScope.() -> Unit = {}
) {
	TopAppBar(
		modifier = Modifier.fillMaxWidth(),
		title = { Text(text = title) },
		actions = actions,
		colors = TopAppBarDefaults.topAppBarColors(
			containerColor = MaterialTheme.colorScheme.primaryContainer,
			titleContentColor = MaterialTheme.colorScheme.primary,
		),
	)
}
