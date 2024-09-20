package com.tamago.ui.components.drawers

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tamago.recipesuikit.NutrienceHelperTheme
import com.tamago.ui.components.textfields.EmailTextField
import com.tamago.ui.components.textfields.NameTextField
import com.tamago.ui.components.textfields.PasswordTextField
import com.tamago.ui.components.textfields.RepeatPasswordTextField

/**
 * Created by Igor Khoroshun on 20.09.2024.
 */

@Composable
fun RegistrationScreenDrawer(
    modifier: Modifier = Modifier
) {
    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var repeatedPassword by remember {
        mutableStateOf("")
    }

    Column(
        modifier = modifier
    ) {
        NameTextField(
            value = name,
            onValueChange = { name = it },
            onDoneClickable = { /*TODO*/ }
        )
        EmailTextField(
            value = email,
            onValueChange = { email = it },
            onDoneClickable = { /*TODO*/ },
        )

        PasswordTextField(
            value = password,
            onValueChange = { password = it },
            onDoneClickable = { /*TODO*/ }
        )
        RepeatPasswordTextField(
            value = repeatedPassword,
            onValueChange = { repeatedPassword = it },
            onDoneClickable = { /*TODO*/ }
        )
    }
}

@Preview
@Composable
fun RegistrationScreenDrawerPreview() {
    NutrienceHelperTheme {
        RegistrationScreenDrawer()
    }
}
