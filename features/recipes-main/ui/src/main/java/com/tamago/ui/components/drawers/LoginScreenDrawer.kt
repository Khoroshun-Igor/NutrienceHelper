package com.tamago.ui.components.drawers

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.tamago.recipes_uikit.R
import com.tamago.recipesuikit.NutrienceHelperTheme
import com.tamago.ui.components.textfields.CustomTextField

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
        CustomTextField(
            value = email,
            fieldTitle = stringResource(R.string.email),
            onValueChange = { email = it },
            onDoneClickable = { /*TODO*/ },
        )

        CustomTextField(
            value = password,
            fieldTitle = stringResource(R.string.password),
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
