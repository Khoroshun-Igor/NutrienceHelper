package com.tamago.ui.components.buttons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tamago.recipesuikit.NutrienceHelperTheme

/**
 * Created by Igor Khoroshun on 24.07.2024.
 */

@Composable
fun CustomIconButton(
    isAdded: Boolean,
    onClick: () -> Unit,
    addingIconsForButtonsEnum: IconsForButtonsEnum,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier,
        colors = IconButtonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContentColor = MaterialTheme.colorScheme.surfaceContainerHighest,
            disabledContainerColor = MaterialTheme.colorScheme.primary
        ),
        content = {
            when (addingIconsForButtonsEnum) {
                IconsForButtonsEnum.ADD_TO_FAVORITE -> {
                    if (isAdded) {
                        Icon(
                            Icons.Default.Check,
                            contentDescription = "Add to menu plan"
                        )
                    } else {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = "Delete from menu plan"
                        )
                    }
                }

                IconsForButtonsEnum.ADD_TO_RECIPES -> {
                    if (isAdded) {
                        Icon(
                            Icons.Default.Favorite,
                            contentDescription = "Delete from favorite"
                        )
                    } else {
                        Icon(
                            Icons.Default.FavoriteBorder,
                            contentDescription = "Add to favorite"
                        )
                    }
                }
            }
        }
    )
}

@Preview
@Composable
fun AddingIconButtonPreview() {
    NutrienceHelperTheme {
        CustomIconButton(
            isAdded = true,
            onClick = { /*TODO*/ },
            addingIconsForButtonsEnum = IconsForButtonsEnum.ADD_TO_RECIPES
        )
    }
}
