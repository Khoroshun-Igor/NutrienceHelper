package com.tamago.recipedata.mappers

import com.tamago.recipe.database.models.RecipeDbo
import com.tamago.recipedata.model.Recipe
import com.tamago.spoonacularapi.models.RecipeDto

/**
 * Created by Igor Khoroshun on 31.05.2024.
 */

internal fun RecipeDbo.toRecipe(): Recipe {
    return Recipe(
        id = this.id,
        title = this.title,
        image = this.image,
        imageType = this.imageType
    )
}

internal fun RecipeDto.toRecipe(): Recipe {
    return Recipe(
        id = this.id,
        title = this.title,
        image = this.image,
        imageType = this.imageType
    )
}

internal fun RecipeDto.toRecipeDBO(): RecipeDbo {
    return RecipeDbo(
        id = this.id,
        title = this.title,
        image = this.image,
        imageType = this.imageType,
    )
}
