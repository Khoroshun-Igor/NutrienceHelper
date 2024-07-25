@file:Suppress("MaximumLineLength", "MaxLineLength")

package com.tamago.recipedata.mappers

import com.tamago.recipe.database.models.RecipeInfoDbo
import com.tamago.recipe.database.models.RecipeInformationExtendedIngredientsInnerDbo
import com.tamago.recipedata.model.RecipeInfo
import com.tamago.recipedata.model.RecipeInformationExtendedIngredientsInner
import com.tamago.spoonacularapi.models.RecipeInfoDto
import com.tamago.spoonacularapi.models.RecipeInformationExtendedIngredientsInnerDto

internal fun RecipeInfoDto.toRecipeInfoDBO(): RecipeInfoDbo {
    return RecipeInfoDbo(
        id = this.id,
        title = this.title,
        image = this.image,
        servings = this.servings,
        readyInMinutes = this.readyInMinutes,
        sourceUrl = this.sourceUrl,
        spoonacularSourceUrl = this.spoonacularSourceUrl,
        healthScore = this.healthScore,
        spoonacularScore = this.spoonacularScore,
        analyzedInstructions = this.analyzedInstructions,
        cheap = this.cheap,
        creditsText = this.creditsText,
        cuisines = this.cuisines,
        dairyFree = this.dairyFree,
        diets = this.diets,
        gaps = this.gaps,
        glutenFree = this.glutenFree,
        instructions = this.instructions,
        ketogenic = this.ketogenic,
        lowFodmap = this.lowFodmap,
        occasions = this.occasions,
        sustainable = this.sustainable,
        vegan = this.vegan,
        vegetarian = this.vegetarian,
        veryHealthy = this.veryHealthy,
        veryPopular = this.veryPopular,
        whole30 = this.whole30,
        weightWatcherSmartPoints = this.weightWatcherSmartPoints,
        dishTypes = this.dishTypes,
        extendedIngredients = this.extendedIngredients.toSetOfRecipeInformationDBO(),
    )
}

internal fun Set<RecipeInformationExtendedIngredientsInnerDto>.toSetOfRecipeInformationDBO(): Set<RecipeInformationExtendedIngredientsInnerDbo> {
    return this.map {
        it.toRecipeInformationDBO()
    }.toSet()
}

internal fun RecipeInformationExtendedIngredientsInnerDto.toRecipeInformationDBO(): RecipeInformationExtendedIngredientsInnerDbo {
    return RecipeInformationExtendedIngredientsInnerDbo(
        aisle = this.aisle,
        amount = this.amount,
        consistency = this.consistency,
        id = this.id,
        image = this.image,
        name = this.name,
        original = this.original,
        originalName = this.originalName,
        unit = this.unit
    )
}

internal fun RecipeInfoDto.toRecipeInfo(): RecipeInfo {
    return RecipeInfo(
        id = this.id,
        title = this.title,
        image = this.image,
        servings = this.servings,
        readyInMinutes = this.readyInMinutes,
        sourceUrl = this.sourceUrl,
        spoonacularSourceUrl = this.spoonacularSourceUrl,
        healthScore = this.healthScore,
        spoonacularScore = this.spoonacularScore,
        analyzedInstructions = this.analyzedInstructions,
        cheap = this.cheap,
        creditsText = this.creditsText,
        cuisines = this.cuisines,
        dairyFree = this.dairyFree,
        diets = this.diets,
        gaps = this.gaps,
        glutenFree = this.glutenFree,
        instructions = this.instructions,
        ketogenic = this.ketogenic,
        lowFodmap = this.lowFodmap,
        occasions = this.occasions,
        sustainable = this.sustainable,
        vegan = this.vegan,
        vegetarian = this.vegetarian,
        veryHealthy = this.veryHealthy,
        veryPopular = this.veryPopular,
        whole30 = this.whole30,
        weightWatcherSmartPoints = this.weightWatcherSmartPoints,
        dishTypes = this.dishTypes,
        extendedIngredients = this.extendedIngredients.toSetOfRecipeInformation(),
    )
}

internal fun RecipeInfoDbo.toRecipeInfo(): RecipeInfo {
    return RecipeInfo(
        id = this.id,
        title = this.title,
        image = this.image,
        servings = this.servings,
        readyInMinutes = this.readyInMinutes,
        sourceUrl = this.sourceUrl,
        spoonacularSourceUrl = this.spoonacularSourceUrl,
        healthScore = this.healthScore,
        spoonacularScore = this.spoonacularScore,
        analyzedInstructions = this.analyzedInstructions,
        cheap = this.cheap,
        creditsText = this.creditsText,
        cuisines = this.cuisines,
        dairyFree = this.dairyFree,
        diets = this.diets,
        gaps = this.gaps,
        glutenFree = this.glutenFree,
        instructions = this.instructions,
        ketogenic = this.ketogenic,
        lowFodmap = this.lowFodmap,
        occasions = this.occasions,
        sustainable = this.sustainable,
        vegan = this.vegan,
        vegetarian = this.vegetarian,
        veryHealthy = this.veryHealthy,
        veryPopular = this.veryPopular,
        whole30 = this.whole30,
        weightWatcherSmartPoints = this.weightWatcherSmartPoints,
        dishTypes = this.dishTypes,
        extendedIngredients = this.extendedIngredients.toSetOfRecipeInformation(),
    )
}

internal fun Set<RecipeInformationExtendedIngredientsInnerDbo>.toSetOfRecipeInformation(): Set<RecipeInformationExtendedIngredientsInner> {
    return this.map {
        it.toRecipeInformation()
    }.toSet()
}

internal fun RecipeInformationExtendedIngredientsInnerDbo.toRecipeInformation(): RecipeInformationExtendedIngredientsInner {
    return RecipeInformationExtendedIngredientsInner(
        aisle = this.aisle,
        amount = this.amount,
        consistency = this.consistency,
        id = this.id,
        image = this.image,
        name = this.name,
        original = this.original,
        originalName = this.originalName,
        unit = this.unit
    )
}

internal fun Set<RecipeInformationExtendedIngredientsInnerDto>.toSetOfRecipeInformation(): Set<RecipeInformationExtendedIngredientsInner> {
    return this.map {
        it.toRecipeInformation()
    }.toSet()
}

internal fun RecipeInformationExtendedIngredientsInnerDto.toRecipeInformation(): RecipeInformationExtendedIngredientsInner {
    return RecipeInformationExtendedIngredientsInner(
        aisle = this.aisle,
        amount = this.amount,
        consistency = this.consistency,
        id = this.id,
        image = this.image,
        name = this.name,
        original = this.original,
        originalName = this.originalName,
        unit = this.unit
    )
}
