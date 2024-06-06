package com.tamago.recipes_main

import com.tamago.recipe_data.RecipesRepository
import com.tamago.recipe_data.RequestResult
import com.tamago.recipe_data.map
import com.tamago.recipes_main.model.Recipe
import jakarta.inject.Inject
import com.tamago.recipe_data.model.Recipe as DataRecipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Created by Igor Khoroshun on 04.06.2024.
 */
class GetAllRecipesUseCase @Inject constructor(
    private val repository: RecipesRepository,
) {
    operator fun invoke(): Flow<RequestResult<List<Recipe>>> {
        return repository.getAll()
            .map { requestResult ->
                requestResult.map { recipes -> recipes.map { it.toUiRecipe() } }
            }
    }

    private fun DataRecipe.toUiRecipe(): Recipe {
        TODO("Not yet implemented")
    }
}