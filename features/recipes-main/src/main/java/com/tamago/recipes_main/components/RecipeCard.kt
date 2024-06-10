package com.tamago.recipes_main.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.tamago.recipes_main.model.RecipeUI

/**
 * Created by Igor Khoroshun on 10.06.2024.
 */

@Composable
internal fun RecipeCard(
    recipe: RecipeUI,
    modifier: Modifier = Modifier,
) {
    var isFavorite by remember {
        mutableStateOf(false)
    }
    var isAdded by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier.width(180.dp)
    ) {
        Box(
            contentAlignment = Alignment.TopCenter
        ) {
            SubcomposeAsyncImage(
                model = recipe.image,
                contentDescription = recipe.title,
                alignment = Alignment.Center,
                modifier = modifier
                    .padding(8.dp)
                    .size(164.dp),
                contentScale = ContentScale.Crop
            ) {
                val state = painter.state
                when (state) {
                    AsyncImagePainter.State.Empty -> Toast.makeText(
                        LocalContext.current,
                        "Empty",
                        Toast.LENGTH_LONG
                    ).show()

                    is AsyncImagePainter.State.Error -> Toast.makeText(
                        LocalContext.current, "Connection Error", Toast.LENGTH_LONG
                    ).show()

                    is AsyncImagePainter.State.Loading -> CircularProgressIndicator()
                    is AsyncImagePainter.State.Success -> SubcomposeAsyncImageContent()
                }
            }

            Row(
                verticalAlignment = Alignment.Top,
                modifier = modifier.padding(8.dp)
            ) {
                IconButton(
                    onClick = {
                        isAdded = !isAdded
                    },
                    modifier = modifier
                        .clip(RoundedCornerShape(32.dp))
                        .size(24.dp),
                    content = {
                        when {
                            isAdded -> Icon(
                                Icons.Default.Check,
                                contentDescription = "Add to menu plan"
                            )

                            !isAdded -> Icon(
                                Icons.Default.Add,
                                contentDescription = "Delete from menu plan"
                            )
                        }
                    }
                )
                Spacer(modifier = modifier.weight(1f))
                IconButton(
                    onClick = {
                        isFavorite = !isFavorite
                    },
                    modifier = modifier
                        .clip(RoundedCornerShape(32.dp))
                        .size(24.dp),
                    content = {
                        when {
                            isFavorite -> Icon(
                                Icons.Default.Favorite,
                                contentDescription = "Delete from favorite"
                            )

                            !isFavorite -> Icon(
                                Icons.Default.FavoriteBorder,
                                contentDescription = "Add to favorite"
                            )
                        }
                    }
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column(
                modifier = modifier.width(86.dp)
            ) {
                Text(
                    text = recipe.title,
                    modifier = modifier.width(86.dp),
                    softWrap = true,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}

@Preview
@Composable
fun RecipeCardPreview() {
    RecipeCard(
        recipe = RecipeUI(
            id = 2,
            title = "Unknown",
            image = "pig",
            imageType = "jpeg"
        )
    )
}