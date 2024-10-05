package com.tamago.spoonacularapi

import androidx.annotation.IntRange
import com.tamago.spoonacularapi.models.RecipeDto
import com.tamago.spoonacularapi.models.RecipeInfoDto
import com.tamago.spoonacularapi.models.ResponseDto
import com.tamago.spoonacularapi.models.Sort
import com.tamago.spoonacularapi.models.SortDirection
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * API Documentation (https://spoonacular.com/food-api/docs)
 */
interface SpoonacularApi {
    /**
     * API Details (https://api.spoonacular.com/recipes/complexSearch)
     */
    @GET("/recipes/complexSearch")
    suspend fun searchRecipe(
        @Query("query") query: String?,
        @Query("number") @IntRange(from = 1, to = 100) number: Int = 10,
        @Query("sort") sort: Sort? = null,
        @Query("sortDirection") sortDirection: SortDirection? = null,
    ): Result<ResponseDto<RecipeDto>>

    @GET("/recipes/{id}/information")
    suspend fun searchRecipeById(
        @Path("id") id: Int,
        @Query("includeNutrition") includeNutrition: Boolean = false,
        @Query("addWinePairing") addWinePairing: Boolean = false,
        @Query("addTasteData") addTasteData: Boolean = false,
    ): Result<RecipeInfoDto>
}
