package com.tamago.recipesmain.components.images

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.tamago.recipes_uikit.R

/**
 * Created by Igor Khoroshun on 23.07.2024.
 */

@Composable
internal fun RecipeImageScreen(
    recipeImage: String,
    modifier: Modifier = Modifier
) {
    var isImageVisible by remember {
        mutableStateOf(true)
    }
    if (isImageVisible) {
        SubcomposeAsyncImage(
            model = recipeImage,
            onState = { state ->
                if (state is AsyncImagePainter.State.Error) {
                    isImageVisible = false
                }
            },
            contentDescription = stringResource(R.string.recipe_image),
            alignment = Alignment.Center,
            modifier = modifier
                .size(dimensionResource(R.dimen.recipe_image_size)),
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
                    LocalContext.current,
                    "Connection Error",
                    Toast.LENGTH_LONG
                ).show()

                is AsyncImagePainter.State.Loading -> CircularProgressIndicator()
                is AsyncImagePainter.State.Success -> SubcomposeAsyncImageContent()
            }
        }
    }
}
