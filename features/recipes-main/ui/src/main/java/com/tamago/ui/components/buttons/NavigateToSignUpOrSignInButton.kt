package com.tamago.ui.components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.tamago.recipes_uikit.R

/**
 * Created by Igor Khoroshun on 05.10.2024.
 */

@Composable
fun NavigateToSignUpOrSignInButton(
    description: String,
    linkTitle: String,
    onNavigationClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = description,
            modifier.wrapContentSize(align = Alignment.Center),
        )
        Spacer(modifier = modifier.padding(dimensionResource(R.dimen.min_padding)))
        TextButton(
            onClick = onNavigationClick,
        ) {
            Text(linkTitle)
        }
    }
}
