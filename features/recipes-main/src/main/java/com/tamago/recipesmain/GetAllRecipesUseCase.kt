package com.tamago.recipesmain

import com.tamago.recipedata.RecipesRepository
import com.tamago.recipedata.RequestResult
import com.tamago.recipedata.map
import com.tamago.recipesmain.model.RecipeInfoUI
import com.tamago.recipesmain.model.RecipeUI
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.tamago.recipedata.model.Recipe as DataRecipe
import com.tamago.recipedata.model.RecipeInfo as DataRecipeInfo
import com.tamago.recipedata.model.RecipeInformationExtendedIngredientsInner as Ingredients
import com.tamago.recipesmain.model.RecipeInformationExtendedIngredientsInnerUI as IngredientsUI

/**
 * Created by Igor Khoroshun on 04.06.2024.
 */
internal class GetAllRecipesUseCase @Inject constructor(
    private val repository: RecipesRepository,
) {
    operator fun invoke(query: String?): Flow<RequestResult<List<RecipeUI>>> {
        return repository.getAll(query)
            .map { requestResult ->
                requestResult.map { recipes -> recipes.map { it.toUiRecipe() } }
            }
    }

    fun getRecipeById(id: Int): Flow<RequestResult<RecipeInfoUI>> {
        return repository.getRecipeByIdFromServer(id)
            .map { requestResult ->
                requestResult.map { recipeInfo -> recipeInfo.toRecipeInfoUI() }
            }
    }

    private fun DataRecipe.toUiRecipe(): RecipeUI {
        return RecipeUI(
            id = this.id,
            title = this.title,
            image = this.image,
            imageType = this.imageType
        )
    }

    private fun DataRecipeInfo.toRecipeInfoUI(): RecipeInfoUI {
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
            extendedIngredients = this.extendedIngredients.toSetOfRecipeInformationUI(),
        )
    }
    fun Set<Ingredients>.toSetOfRecipeInformationUI(): Set<IngredientsUI> {
        return this.map {
            it.toRecipeInformationUI()
        }.toSet()
    }

    fun Ingredients.toRecipeInformationUI(): IngredientsUI {
        return IngredientsUI(
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
