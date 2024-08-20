package com.tamago.recipesmain.components.drawers

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.tamago.recipesuikit.NutrienceHelperTheme

/**
 * Created by Igor Khoroshun on 20.08.2024.
 */

@Composable
fun CustomTextField(
    value: String,
    fieldTitle: String,
    onValueChange: (String) -> Unit,
    onDoneClickable: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(text = fieldTitle) },
        placeholder = { Text(text = fieldTitle) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = fieldTitle
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = { onDoneClickable() }),
        modifier = modifier.fillMaxWidth()
    )
}

@Preview
@Composable
fun CustomTextFieldPreview() {
    NutrienceHelperTheme {
        CustomTextField(
            value = "email",
            fieldTitle = "email",
            onValueChange = { TODO() },
            onDoneClickable = { TODO() }
        )
    }
}
