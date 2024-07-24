package com.tamago.recipesmain

import com.tamago.recipedata.RecipesRepository
import com.tamago.recipedata.RequestResult
import com.tamago.recipedata.map
import com.tamago.recipesmain.model.RecipeUI
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.tamago.recipedata.model.Recipe as DataRecipe

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
