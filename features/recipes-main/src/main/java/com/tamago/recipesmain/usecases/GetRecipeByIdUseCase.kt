package com.tamago.recipesmain.usecases

import com.tamago.recipedata.RecipesRepository
import com.tamago.recipedata.RequestResult
import com.tamago.recipedata.map
import com.tamago.recipedata.model.RecipeInfo
import com.tamago.recipedata.model.RecipeInformationExtendedIngredientsInner as RecipeInformation
import com.tamago.recipesmain.model.RecipeInfoUI
import com.tamago.recipesmain.model.RecipeInformationExtendedIngredientsInnerUI as RecipeInformationUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by Igor Khoroshun on 01.08.2024.
 */
class GetRecipeByIdUseCase @Inject constructor(
    private val repository: RecipesRepository
) {
    operator fun invoke(id: Int): Flow<RequestResult<RecipeInfoUI>> {
        return repository.getRecipeByIdFromServer(id)
            .map { requestResult ->
                requestResult.map { recipeInfo -> recipeInfo.toRecipeInfoUI() }
            }
    }

    private fun RecipeInfo.toRecipeInfoUI(): RecipeInfoUI {
        return RecipeInfoUI(
            id = this.id,
            title = this.title,
            image = this.image,
            servings = this.servings,
            readyInMinutes = this.readyInMinutes,
            sourceUrl = this.sourceUrl,
            spoonacularSourceUrl = this.spoonacularSourceUrl,
            healthScore = this.healthScore,
            spoonacularScore = this.spoonacularScore,
//            analyzedInstructions = this.analyzedInstructions,
            cheap = this.cheap,
            creditsText = this.creditsText,
            cuisines = this.cuisines,
            dairyFree = this.dairyFree,
            diets = this.diets,
            gaps = this.gaps,
            glutenFree = this.glutenFree,
            instructions = this.instructions,
            lowFodmap = this.lowFodmap,
            occasions = this.occasions,
            sustainable = this.sustainable,
            vegan = this.vegan,
            vegetarian = this.vegetarian,
            veryHealthy = this.veryHealthy,
            veryPopular = this.veryPopular,
            weightWatcherSmartPoints = this.weightWatcherSmartPoints,
            dishTypes = this.dishTypes,
            extendedIngredients = this.extendedIngredients.toSetOfRecipeInformationUI(),
        )
    }
    fun Set<RecipeInformation>.toSetOfRecipeInformationUI(): Set<RecipeInformationUI> {
        return this.map {
            it.toRecipeInformationUI()
        }.toSet()
    }

    fun RecipeInformation.toRecipeInformationUI(): RecipeInformationUI {
        return RecipeInformationUI(
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
}