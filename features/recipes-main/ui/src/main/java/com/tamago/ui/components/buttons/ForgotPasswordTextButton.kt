package com.tamago.ui.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.tamago.recipes_uikit.R

/**
 * Created by Igor Khoroshun on 05.10.2024.
 */

@Composable
fun ForgotPasswordTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        contentPadding = PaddingValues(dimensionResource(R.dimen.null_padding))
    ) {
        Text(
            stringResource(R.string.forgot_password),
            textAlign = TextAlign.Start,
            modifier = modifier
                .fillMaxWidth()
        )
    }
}
