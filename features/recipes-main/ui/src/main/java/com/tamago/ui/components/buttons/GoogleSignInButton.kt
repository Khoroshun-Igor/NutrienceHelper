package com.tamago.ui.components.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.tamago.recipes_uikit.R
import com.tamago.recipesuikit.NutrienceHelperTheme

/**
 * Created by Igor Khoroshun on 04.10.2024.
 */

@Composable
fun GoogleSignInButton(
    modifier: Modifier = Modifier,
) {
    Column {
        Text(
            stringResource(R.string.or_log_in_with),
            textAlign = TextAlign.Start,
            modifier = modifier
                .fillMaxWidth()
        )
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Icon(
                painterResource(R.drawable.ic_google_logo),
                contentDescription = stringResource(R.string.login_with_google)
            )
        }
    }
}

@Preview
@Composable
fun GoogleSignInButtonPreview() {
    NutrienceHelperTheme {
        GoogleSignInButton()
    }
}
