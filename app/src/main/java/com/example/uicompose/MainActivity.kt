package com.example.uicompose
//noinspection UsingMaterialAndMaterial3Libraries
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.uicompose.navigation.NavigationRoute
import com.example.uicompose.ui.theme.UIComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()

		setContent {
			val navController = rememberNavController()
			UIComposeTheme {
				NavigationRoute(navController = navController)


//				Scaffold(
//					modifier = Modifier
//						.fillMaxSize()
//						.background(color = Color.Cyan),
//					topBar = {
//						MyAppBar(title = "Compose Build UI")
//					},
//					bottomBar = { MyBottomAppBar(navController = navController) }) { innerPadding ->
//					Greeting(
//						name = "Android",
//						modifier = Modifier.padding(innerPadding),
//						navController = navController
//					)
//				}
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
							navController.navigate(it.route)
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

	@Composable
	fun Greeting(name: String, modifier: Modifier = Modifier, navController: NavHostController) {
		NavigationRoute(navController = navController)
	}

	@Preview(showBackground = false)
	@Composable
	fun GreetingPreview() {
		UIComposeTheme {
			// Greeting("Android")
		}
	}
}

sealed class BottomNavItem(
	val route: String,
	val icon: ImageVector,
	val contentDescription: String
) {
	data object Home : BottomNavItem("HOME", Icons.Default.Home, "Home Icon")
	data object Profile : BottomNavItem("PROFILE", Icons.Default.Person, "Profile Icon")
	data object Notification :
		BottomNavItem("NOTIFICATION", Icons.Default.Notifications, "Notification Icon")

	data object Setting : BottomNavItem("SETTING", Icons.Default.Settings, "Setting Icon")
}

sealed class ScreenRoute1(val name: String) {
	data object HOME : ScreenRoute1("HOME")
	data object PROFILE : ScreenRoute1("PROFILE")
	data object NOTIFICATION : ScreenRoute1("NOTIFICATION")
	data object SETTING : ScreenRoute1("SETTING")
	data object ScreenB : ScreenRoute1("SCREEN_B/{data}") {
		fun createRoute(data: String) = "SCREEN_B/$data"
	}
}

