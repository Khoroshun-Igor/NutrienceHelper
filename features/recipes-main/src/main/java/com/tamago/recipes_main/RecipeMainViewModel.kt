package com.tamago.recipes_main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamago.recipe_data.RecipesRepository
import com.tamago.recipe_data.RequestResult
import com.tamago.recipe_data.map
import com.tamago.recipes_main.model.Recipe
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Igor Khoroshun on 31.05.2024.
 */

@HiltViewModel
internal class RecipeMainViewModel @Inject constructor(
    getAllRecipesUseCase: Provider<GetAllRecipesUseCase>,
//    private val repository: RecipesRepository,
) : ViewModel() {

    val state: StateFlow<State> = getAllRecipesUseCase.get().invoke()
        .map { it.toState() }
        .stateIn(viewModelScope, SharingStarted.Lazily, State.None)

    fun forceToUpdate(){
    }
}

private fun RequestResult<List<Recipe>>.toState(): State {
    return when (this) {
        is RequestResult.Error -> State.Error()
        is RequestResult.InProgress -> State.Loading(data)
        is RequestResult.Success -> State.Success(data)
    }
}

sealed class State {
    object None : State()
    class Loading(val recipes: List<Recipe>? = null) : State()
    class Error(val recipes: List<Recipe>? = null) : State()
    class Success(val recipes: List<Recipe>) : State()
}