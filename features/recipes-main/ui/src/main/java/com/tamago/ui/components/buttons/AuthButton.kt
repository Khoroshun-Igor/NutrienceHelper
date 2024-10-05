package com.tamago.ui.components.buttons

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tamago.recipesuikit.NutrienceHelperTheme

/**
 * Created by Igor Khoroshun on 23.09.2024.
 */

@Composable
fun AuthButton(
    title: String,
    onClick: () -> Unit,
    loading: Boolean,
    success: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
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
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Check Icon",
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Done")
                }
            }
        }
    }
}

@Preview
@Composable
fun SignInButtonPreview() {
    NutrienceHelperTheme {
        AuthButton(
            title = "sign in",
            onClick = { /*TODO*/ },
            loading = false,
            success = false,
        )
    }
}

@Preview
@Composable
fun SignInButtonLoadingPreview() {
    NutrienceHelperTheme {
        AuthButton(
            title = "sign in",
            onClick = { /*TODO*/ },
            loading = true,
            success = false,
        )
    }
}

@Preview
@Composable
fun SignInButtonSuccessPreview() {
    NutrienceHelperTheme {
        AuthButton(
            title = "sign in",
            onClick = { /*TODO*/ },
            loading = false,
            success = true,
        )
    }
}
