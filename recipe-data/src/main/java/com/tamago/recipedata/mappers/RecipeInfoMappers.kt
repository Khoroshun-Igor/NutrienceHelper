package com.tamago.recipedata.mappers

import com.tamago.recipe.database.models.RecipeInfoDbo
import com.tamago.recipedata.model.RecipeInfo
import com.tamago.spoonacularapi.models.RecipeInfoDto
import com.tamago.recipe.database.models.RecipeInformationExtendedIngredientsInnerDbo as IngredientsDbo
import com.tamago.recipedata.model.RecipeInformationExtendedIngredientsInner as Ingredients
import com.tamago.spoonacularapi.models.RecipeInformationExtendedIngredientsInnerDto as IngredientsDto

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

internal fun Set<IngredientsDto>.toSetOfRecipeInformationDBO(): Set<IngredientsDbo> {
    return this.map {
        it.toRecipeInformationDBO()
    }.toSet()
}

internal fun IngredientsDto.toRecipeInformationDBO(): IngredientsDbo {
    return IngredientsDbo(
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

internal fun Set<IngredientsDbo>.toSetOfRecipeInformation(): Set<Ingredients> {
    return this.map {
        it.toRecipeInformation()
    }.toSet()
}

internal fun IngredientsDbo.toRecipeInformation(): Ingredients {
    return Ingredients(
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

internal fun Set<IngredientsDto>.toSetOfRecipeInformation(): Set<Ingredients> {
    return this.map {
        it.toRecipeInformation()
    }.toSet()
}

internal fun IngredientsDto.toRecipeInformation(): Ingredients {
    return Ingredients(
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
