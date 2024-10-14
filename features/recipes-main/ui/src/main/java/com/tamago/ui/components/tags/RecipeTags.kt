package com.tamago.ui.components.tags

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ContextualFlowRow
import androidx.compose.foundation.layout.ContextualFlowRowOverflow
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tamago.recipes_uikit.R

/**
 * Created by Igor Khoroshun on 06.10.2024.
 */

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RecipeTagList(
    tags: List<String>,
    modifier: Modifier = Modifier,
) {
    var overflowSelected by remember { mutableStateOf(false) }
    ContextualFlowRow(
        itemCount = tags.size,
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        maxLines = 3,
        overflow =
        if (overflowSelected) {
            ContextualFlowRowOverflow.Visible
        } else {
            ContextualFlowRowOverflow.expandIndicator {
                val remainingItems = tags.size - shownItemCount
                OverflowItem(
                    remainingItemsCount = remainingItems,
                    onOverflowItemSelected = { overflowSelected = true }
                )
            }
        }
    ) { index ->
        TagCustomBox(
            tag = tags[index],
            modifier = modifier,
        )
    }
}

@Composable
fun TagCustomBox(
    tag: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = tag,
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = CircleShape
            )
            .padding(
                vertical = dimensionResource(R.dimen.min_padding),
                horizontal = dimensionResource(R.dimen.min_padding)
            ),
        color = MaterialTheme.colorScheme.tertiary,
        style = MaterialTheme.typography.bodySmall,
    )
}

@Composable
private fun OverflowItem(
    remainingItemsCount: Int,
    onOverflowItemSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(R.string.show_more_items, remainingItemsCount),
        modifier = modifier
            .clickable(onClick = onOverflowItemSelected)
    )
}
