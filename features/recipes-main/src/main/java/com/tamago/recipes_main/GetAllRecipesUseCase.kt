package com.tamago.recipes_main

import com.tamago.recipe_data.RecipesRepository
import com.tamago.recipe_data.RequestResult
import com.tamago.recipe_data.map
import com.tamago.recipes_main.model.RecipeUI
import jakarta.inject.Inject
import com.tamago.recipe_data.model.Recipe as DataRecipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

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

    private fun DataRecipe.toUiRecipe(): RecipeUI {
        return RecipeUI(
            id = this.id,
            title = this.title,
            image = this.image,
            imageType = this.imageType
        )
    }
}