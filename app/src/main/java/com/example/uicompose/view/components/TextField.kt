package com.example.uicompose.view.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp


@Composable
fun MyTextField(valueLabel: String, placeholder: String) {
	val text = remember {
		mutableStateOf((""))
	}
	BaseTextFieldWithIcons(
		text = text.value,
		onValueChange = {
			text.value = it
		},
		label = valueLabel,
		placeholder = placeholder
	).TextFieldWithIcons()
}

open class BaseTextFieldWithIcons(
	private var text: String,
	private var onValueChange: (String) -> Unit,
	private var label: String,
	private var placeholder: String? = null,
	private var leadingIcon: @Composable (() -> Unit)? = null,
	private var trailingIcon: @Composable (() -> Unit)? = null
) {
	@Composable
	open fun TextFieldWithIcons() {
		OutlinedTextField(
			modifier = Modifier
				.fillMaxWidth()
				.padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 8.dp),
			maxLines = 1,
			value = text,
			onValueChange = {
				onValueChange(it)
			},
			textStyle = TextStyle(color = Color.White),
			label = { Text(text = label, style = TextStyle(color = Color.White)) },
			placeholder = placeholder?.let { { Text(text = it) } },
			leadingIcon = leadingIcon,
			trailingIcon = trailingIcon,
			keyboardOptions = KeyboardOptions.Default.copy(
				imeAction = ImeAction.Done
			),
			keyboardActions = KeyboardActions(
				onDone = {
					// Handle keyboard done action if needed

				}
			)
		)
	}
}