package com.tamago.ui.components.textfields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.tamago.recipes_uikit.R
import com.tamago.recipesuikit.NutrienceHelperTheme

/**
 * Created by Igor Khoroshun on 20.08.2024.
 */

@Composable
fun EmailTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(stringResource(R.string.email)) },
        placeholder = { stringResource(R.string.email) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = stringResource(R.string.email)
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        modifier = modifier
            .fillMaxWidth()
    )
}

@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onDoneClickable: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var passwordVisibility by remember { mutableStateOf(false) }
    val icon = if (passwordVisibility) {
        painterResource(R.drawable.baseline_visibility_24)
    } else {
        painterResource(R.drawable.baseline_visibility_off_24)
    }
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(stringResource(R.string.password)) },
        placeholder = { Text(stringResource(R.string.password)) },
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = stringResource(R.string.password)
            )
        },
        trailingIcon = {
            IconButton(
                onClick = { passwordVisibility = !passwordVisibility }
            ) {
                Icon(
                    painter = icon,
                    contentDescription = stringResource(R.string.password)
                )
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = { onDoneClickable() }),
        modifier = modifier
            .fillMaxWidth()
    )
}

@Composable
fun RepeatPasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onDoneClickable: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var passwordVisibility by remember { mutableStateOf(false) }
    val icon = if (passwordVisibility) {
        painterResource(R.drawable.baseline_visibility_24)
    } else {
        painterResource(R.drawable.baseline_visibility_off_24)
    }
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(stringResource(R.string.password)) },
        placeholder = { Text(stringResource(R.string.password)) },
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = stringResource(R.string.password)
            )
        },
        trailingIcon = {
            IconButton(
                onClick = { passwordVisibility = !passwordVisibility }
            ) {
                Icon(
                    painter = icon,
                    contentDescription = stringResource(R.string.password)
                )
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = { onDoneClickable() }),
        modifier = modifier
            .fillMaxWidth()
    )
}

@Composable
fun NameTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(stringResource(R.string.name)) },
        placeholder = { Text(stringResource(R.string.name)) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = stringResource(R.string.name)
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        modifier = modifier
            .fillMaxWidth()
    )
}

@Preview
@Composable
fun NameTextFieldPreview() {
    NutrienceHelperTheme {
        NameTextField(
            value = "first name",
            onValueChange = { TODO() },
        )
    }
}

@Preview
@Composable
fun EmailTextFieldPreview() {
    NutrienceHelperTheme {
        EmailTextField(
            value = "email",
            onValueChange = { TODO() },
        )
    }
}

@Preview
@Composable
fun PasswordTextFieldPreview() {
    NutrienceHelperTheme {
        PasswordTextField(
            value = "password",
            onValueChange = { TODO() },
            onDoneClickable = { TODO() }
        )
    }
}

@Preview
@Composable
fun RepeatPasswordTextFieldPreview() {
    NutrienceHelperTheme {
        RepeatPasswordTextField(
            value = "password",
            onValueChange = { TODO() },
            onDoneClickable = { TODO() }
        )
    }
}
