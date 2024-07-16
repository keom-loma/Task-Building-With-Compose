package com.example.uicompose.view


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.uicompose.R
import com.example.uicompose.navigation.ScreenRoute
import com.example.uicompose.view.components.MyButton
import com.example.uicompose.view.components.MyTextField
import com.skydoves.cloudy.Cloudy

@Composable
fun LoginScreen(navController: NavController) {
	val keyboardManager = LocalSoftwareKeyboardController.current
	Surface(onClick = {
		keyboardManager?.hide()
	}) {
		Box(
			modifier = Modifier
				.fillMaxSize()
				.background(color = Color.Cyan)
		) {
			Cloudy(radius = 25) {
				Image(
					painter = painterResource(id = R.drawable.getty),  // Replace with your background image resource
					contentDescription = null,
					modifier = Modifier
						.fillMaxSize(),
					contentScale = ContentScale.FillHeight

				)
			}
		}
		Box(modifier = Modifier.fillMaxSize()) {
			Column(
				modifier = Modifier.align(Alignment.Center),
				verticalArrangement = Arrangement.Bottom,
				horizontalAlignment = Alignment.End
			) {
				MyTextField("Email", "txtMutableString = txtEmail")
				MyTextField("Password", "Please enter your password")
				MyButton(
					onClick = {
						navController.navigate(ScreenRoute.MAIN_DASHBOARD.name)
					},
					labelTitle = "Login",
					enabled = true
				)

			}
		}

	}
}