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
import com.tamago.ui.components.textfields.PasswordTextField

/**
 * Created by Igor Khoroshun on 22.08.2024.
 */

@Composable
fun LoginScreenDrawer(
    modifier: Modifier = Modifier
) {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }
    Column(
        modifier = modifier
    ) {
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
    }
}

@Preview
@Composable
fun LoginScreenDrawerPreview() {
    NutrienceHelperTheme {
        LoginScreenDrawer()
    }
}
