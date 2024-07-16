package com.example.uicompose.view.components

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController

@Composable
fun KeyboardManager(onKeyboardDown: @Composable () -> Unit) {
	val keyboardController = LocalSoftwareKeyboardController.current
	val coroutineScope = rememberCoroutineScope()
	val textState by remember { mutableStateOf("") }
	val context = LocalContext.current

}