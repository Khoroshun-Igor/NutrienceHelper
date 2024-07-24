@file:Suppress("UnusedParameter")

package com.tamago.recipedata

import com.tamago.common.Logger
import com.tamago.recipe.database.RecipesDataBase
import com.tamago.recipe.database.models.RecipeDbo
import com.tamago.recipedata.model.Recipe
import com.tamago.spoonacularapi.SpoonacularApi
import com.tamago.spoonacularapi.models.RecipeDto
import com.tamago.spoonacularapi.models.ResponseDto
import jakarta.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.catch
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

class RecipesRepository @Inject constructor(
    private val dataBase: RecipesDataBase,
    private val api: SpoonacularApi,
    private val logger: Logger
) {
    @OptIn(ExperimentalCoroutinesApi::class)
    fun getAll(
        query: String?,
        mergeStrategy: MergeStrategy<RequestResult<List<Recipe>>> = DefaultRequestResponseMergeStrategy(),
    ): Flow<RequestResult<List<Recipe>>> {
        val cachedRecipes = getAllFromDatabase()

        val remoteRecipes = getAllFromServer(query)

        return cachedRecipes.combine(remoteRecipes, mergeStrategy::merge)
            .flatMapLatest { result ->
                if (result is RequestResult.Success) {
                    dataBase.recipeDao.observeAll()
                        .map { dbos -> dbos.map { it.toRecipe() } }
                        .map { RequestResult.Success(it) }
                } else {
                    flowOf(result)
                }
            }
    }

    fun getAllFromDatabase(): Flow<RequestResult<List<Recipe>>> {
        val dbRequest = dataBase.recipeDao::getAll.asFlow()
            .map { RequestResult.Success(it) }
            .catch {
                RequestResult.Error<List<RecipeDbo>>(error = it)
                logger.e(LOGTAG, "Error getting from database = $it")
            }

        val start = flowOf<RequestResult<List<RecipeDbo>>>(RequestResult.InProgress())
        return merge(start, dbRequest).map { result ->
            result.map { recipesDbos ->
                recipesDbos.map { it.toRecipe() }
            }
        }
    }

    fun getAllFromServer(query: String?): Flow<RequestResult<List<Recipe>>> {
        val apiRequest = flow { emit(api.searchRecipe(query)) }
            .onEach { result ->
                if (result.isSuccess) {
                    saveNetResponseToCache(result.getOrThrow().results)
                }
            }
            .onEach { result ->
                if (result.isFailure) {
                    logger.e(LOGTAG, "Error getting from server = ${result.exceptionOrNull()}")
                }
            }
            .map { it.toRequestResult() }

        val start = flowOf<RequestResult<ResponseDto<RecipeDto>>>(RequestResult.InProgress())

        return merge(apiRequest, start).map { result ->
            result.map { response ->
                response.results.map { it.toRecipe() }
            }
        }
    }

//    fun getRecipeByIdFromServer(id: Int): Flow<RequestResult<Recipe>> {
//        val apiRequest = flow { emit(api.searchRecipeById(id)) }
//            .map { it.toRequestResult() }
//        return apiRequest.map { result ->
//            result.map { response ->
//                response.toRecipeInfo
//            }
//        }
//    }

    private suspend fun saveNetResponseToCache(data: Set<RecipeDto>) {
        val dbos = data
            .map { recipeDto -> recipeDto.toRecipeDBO() }
        dataBase.recipeDao.insert(dbos)
    }

    @Suppress("UnusedPrivateMember")
    private suspend fun saveRecipeToCache(recipeDto: RecipeDto) {
        val dbos = recipeDto.toRecipeDBO()
        dataBase.recipeDao.insertRecipe(dbos)
    }

    private companion object {
        const val LOGTAG = "RecipesRepository"
    }

//    fun fetchLatest(): Flow<RequestResult<List<Recipe>>> {
//        return getAllFromServer()
//    }
}
