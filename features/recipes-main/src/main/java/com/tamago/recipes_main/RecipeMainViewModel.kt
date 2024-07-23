package com.tamago.recipes_main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.`mutableStateOf`
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamago.recipe_data.RequestResult
import com.tamago.recipes_main.model.RecipeUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
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
) : ViewModel() {
    var query: String? by mutableStateOf(null)
    val state: StateFlow<State> = getAllRecipesUseCase.get().invoke(query)
        .map { it.toState() }
        .stateIn(viewModelScope, SharingStarted.Lazily, State.None)

    fun forceToUpdate(){
    }
}

private fun RequestResult<List<RecipeUI>>.toState(): State {
    return when (this) {
        is RequestResult.Error -> State.Error()
        is RequestResult.InProgress -> State.Loading(data)
        is RequestResult.Success -> State.Success(data)
    }
}

internal sealed class State(val recipes: List<RecipeUI>?) {
    data object None : State(recipes = null)
    class Loading(recipes: List<RecipeUI>? = null) : State(recipes)
    class Error(recipes: List<RecipeUI>? = null) : State(recipes)
    class Success(recipes: List<RecipeUI>) : State(recipes)
}