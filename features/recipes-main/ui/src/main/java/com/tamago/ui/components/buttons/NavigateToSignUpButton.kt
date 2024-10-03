package com.tamago.ui.components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Created by Igor Khoroshun on 25.09.2024.
 */

@Composable
fun NavigateToSignUpButton(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
    ) {
        Button(
            onClick = onClick,
        ) {
            Text(text = title)
        }
    }
}
