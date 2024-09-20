package com.tamago.ui.components.textfields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
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
    onDoneClickable: () -> Unit,
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
        keyboardActions = KeyboardActions(onDone = { onDoneClickable() }),
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.middle_padding))
    )
}

@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onDoneClickable: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(stringResource(R.string.password)) },
        placeholder = { Text(stringResource(R.string.password)) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = stringResource(R.string.password)
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = stringResource(R.string.password)
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = { onDoneClickable() }),
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.middle_padding))
    )
}

@Composable
fun RepeatPasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onDoneClickable: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(stringResource(R.string.repeate_password)) },
        placeholder = { Text(stringResource(R.string.repeate_password)) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = stringResource(R.string.repeate_password)
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = stringResource(R.string.repeate_password)
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = { onDoneClickable() }),
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.middle_padding))
    )
}

@Composable
fun NameTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onDoneClickable: () -> Unit,
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
        keyboardActions = KeyboardActions(onDone = { onDoneClickable() }),
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.middle_padding))
    )
}

@Preview
@Composable
fun NameTextFieldPreview() {
    NutrienceHelperTheme {
        NameTextField(
            value = "first name",
            onValueChange = { TODO() },
            onDoneClickable = { TODO() }
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
            onDoneClickable = { TODO() }
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
