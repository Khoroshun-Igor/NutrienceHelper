package com.tamago.recipesmain.components.drawers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tamago.recipes_uikit.R

/**
 * Created by Igor Khoroshun on 24.07.2024.
 */

@Composable
fun DrawerContent(
    modifier: Modifier = Modifier
) {
    val items = listOf(
        DrawerNavigationItems.Home,
        DrawerNavigationItems.Favorite,
        DrawerNavigationItems.MealPlan,
        DrawerNavigationItems.SignOut
    )
    Column(
        modifier = modifier
            .width(320.dp)
            .padding(32.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically

        ) {
            Image(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = stringResource(R.string.account),
                modifier = modifier
                    .padding(8.dp)
                    .size(60.dp)
            )
            Text(
                text = stringResource(R.string.guest),
                modifier = modifier.padding(8.dp)
            )
        }
        HorizontalDivider(
            modifier = modifier
                .padding(16.dp)
        )
        items.forEach { item ->
            if (item.text == stringResource(R.string.sign_out)) {
                Spacer(modifier = modifier.weight(1f))
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    item.icon,
                    item.text,
                    modifier = modifier
                        .padding(8.dp)
                        .size(32.dp)
                )
                Text(
                    item.text,
                    modifier = modifier
                        .padding(8.dp)
                )
            }
        }
    }
}
