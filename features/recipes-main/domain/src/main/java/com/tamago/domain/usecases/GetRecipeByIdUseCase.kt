package com.tamago.domain.usecases

import com.tamago.domain.model.RecipeInfoUI
import com.tamago.recipedata.model.RecipeInfo
import com.tamago.recipedata.repositories.RecipesRepositoryImpl
import com.tamago.recipedata.util.RequestResult
import com.tamago.recipedata.util.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import com.tamago.domain.model.RecipeInformationExtendedIngredientsInnerUI as RecipeInformationUI
import com.tamago.recipedata.model.RecipeInformationExtendedIngredientsInner as RecipeInformation

/**
 * Created by Igor Khoroshun on 29.09.2024.
 */

class GetRecipeByIdUseCase @Inject constructor(
    private val repository: RecipesRepositoryImpl
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
    private fun Set<RecipeInformation>.toSetOfRecipeInformationUI(): Set<RecipeInformationUI> {
        return this.map {
            it.toRecipeInformationUI()
        }.toSet()
    }

    private fun RecipeInformation.toRecipeInformationUI(): RecipeInformationUI {
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
