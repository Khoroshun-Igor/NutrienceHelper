package com.tamago.recipes_main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamago.recipe_data.RecipesRepository
import com.tamago.recipe_data.RequestResult
import com.tamago.recipe_data.map
import com.tamago.recipes_main.model.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

/**
 * Created by Igor Khoroshun on 31.05.2024.
 */
internal class RecipeMainViewModel(
    private val getAllRecipesUseCase: GetAllRecipesUseCase
) : ViewModel() {

    val state: StateFlow<State> = getAllRecipesUseCase()
        .map { it.toState() }
        .stateIn(viewModelScope, SharingStarted.Lazily, State.None)
}

private fun RequestResult<List<Recipe>>.toState(): State {
    return when (this) {
        is RequestResult.Error -> State.Error()
        is RequestResult.InProgress -> State.Loading(data)
        is RequestResult.Success -> State.Success(checkNotNull(data))
    }
}

sealed class State {
    object None : State()
    class Loading(val recipes: List<Recipe>?) : State()
    class Error : State()
    class Success(val recipes: List<Recipe>) : State()
}