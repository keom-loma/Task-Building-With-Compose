package com.example.uicompose.view.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyButton( labelTitle: String, onClick: () -> Unit, enabled: Boolean) {
	BuildButton(
		onClick ={onClick()},
		enabled = enabled,
		labelTitle =labelTitle
	).Button()
}

open class BuildButton(
	private var onClick: () -> Unit,
	private var enabled: Boolean,
	private var labelTitle: String


) {
	@Composable
	open fun Button() {
		Button(
			modifier = Modifier
				.fillMaxWidth()
				.padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 8.dp),
			onClick = { onClick() },
			enabled = enabled,
			colors = ButtonDefaults.buttonColors(
				//containerColor = Color.LightGray,
				disabledContainerColor = Color.LightGray
			),
			elevation = ButtonDefaults.buttonElevation(0.dp),
			shape = ButtonDefaults.outlinedShape,

		) {
			Text(text = labelTitle)
		}
	}
}