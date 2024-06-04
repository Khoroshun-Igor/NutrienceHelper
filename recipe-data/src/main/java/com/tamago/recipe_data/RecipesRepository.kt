package com.tamago.recipe_data

import com.tamago.recipe.database.RecipesDataBase
import com.tamago.recipe.database.models.RecipeDbo
import com.tamago.recipe_data.model.Recipe
import com.tamago.spoonacularapi.SpoonacularApi
import com.tamago.spoonacularapi.models.RecipeDto
import com.tamago.spoonacularapi.models.ResponseDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach

/**
 * Created by Igor Khoroshun on 31.05.2024.
 */
class RecipesRepository(
    private val dataBase: RecipesDataBase,
    private val api: SpoonacularApi,
//    private val mergeStrategy: MergeStrategy<RequestResult<List<Recipe>>>,
) {
    fun getAll(
        mergeStrategy: MergeStrategy<RequestResult<List<Recipe>>> = DefaultRequestResponseMergeStrategy(),
    ): Flow<RequestResult<List<Recipe>>> {
        val cachedRecipes = getAllFromDatabase()
            .map { result ->
                result.map { recipesDbos ->
                    recipesDbos.map { it.toRecipe() }
                }
            }

        val remoteRecipes = getAllFromServer()
            .map { result ->
                result.map { response ->
                    response.results.map { it.toRecipe() }
                }
            }

        return cachedRecipes.combine(remoteRecipes, mergeStrategy::merge)
            .flatMapLatest { result ->
                if(result is RequestResult.Success){
                    dataBase.recipeDao.observeAll()
                        .map { dbos -> dbos.map { it.toRecipe() } }
                        .map { RequestResult.Success(it) }
                } else{
                    flowOf(result)
                }
            }
    }

    fun getAllFromDatabase(): Flow<RequestResult<List<RecipeDbo>>> {
        val dbRequest = dataBase.recipeDao::getAll.asFlow()
            .map { RequestResult.Success(it) }

        val start = flowOf<RequestResult<List<RecipeDbo>>>(RequestResult.InProgress())
        return merge(start, dbRequest)
    }

    fun getAllFromServer(): Flow<RequestResult<ResponseDto<RecipeDto>>> {
        val apiRequest = flow { emit(api.searchRecipe()) }
            .onEach { result ->
                if (result.isSuccess) {
                    saveNetResponseToCache(checkNotNull(result.getOrThrow().results))
                }
            }
            .map { it.toRequestResult() }

        val start = flowOf<RequestResult<ResponseDto<RecipeDto>>>(RequestResult.InProgress())

        return merge(apiRequest, start)
    }

    private fun saveNetResponseToCache(data: Set<RecipeDto>) {
        val dbos = data
            .map { recipeDto -> recipeDto.toRecipeDBO() }
        dataBase.recipeDao.insert(dbos)
    }

    fun search(query: String): Flow<Recipe> {
        api.searchRecipe(query)
        TODO()
    }
}