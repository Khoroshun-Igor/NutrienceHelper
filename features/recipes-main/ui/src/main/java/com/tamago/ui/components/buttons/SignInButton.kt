package com.tamago.ui.components.buttons

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tamago.recipes_uikit.R

/**
 * Created by Igor Khoroshun on 23.09.2024.
 */

@Composable
fun SignInButton(
    title: String,
    onClick: () -> Unit,
    loading: Boolean,
    success: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.padding(dimensionResource(R.dimen.middle_padding))
    ) {
        Button(
            onClick = onClick,
        ) {
            AnimatedVisibility(
                visible = !loading && !success,
            ) {
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                )
            }
            AnimatedVisibility(
                visible = loading,
            ) {
                CircularProgressIndicator()
            }
            AnimatedVisibility(
                visible = success,
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Check Icon",
                        modifier = Modifier.size(22.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Done")
                }
            }
        }
    }
}
