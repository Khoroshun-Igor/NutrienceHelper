package com.tamago.ui.viewmodels

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamago.domain.model.RecipeUI
import com.tamago.domain.usecases.GetAllRecipesUseCase
import com.tamago.recipedata.RequestResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

/**
 * Created by Igor Khoroshun on 31.05.2024.
 */

@HiltViewModel
class RecipeMainViewModel @Inject constructor(
    private val getAllRecipesUseCase: GetAllRecipesUseCase,
) : ViewModel() {

    var query: String by mutableStateOf("")
    var state: StateFlow<State> = getAllRecipesUseCase.invoke(query)
        .map { it.toState() }
        .stateIn(viewModelScope, SharingStarted.Lazily, State.None)

    fun findRecipes() {
        state = getAllRecipesUseCase.findRecipesByQuery(query)
            .map { it.toState() }
            .stateIn(viewModelScope, SharingStarted.Lazily, State.None)
    }

//    fun onSearchUpdate(query: String?) {
//        findRecipes(query = query ?: "")
//    }
}

fun RequestResult<List<RecipeUI>>.toState(): State {
    return when (this) {
        is RequestResult.Error -> State.Error()
        is RequestResult.InProgress -> State.Loading(data)
        is RequestResult.Success -> State.Success(data)
    }
}

@Stable
sealed class State(open val recipes: List<RecipeUI>?) {

    @Immutable
    data object None : State(recipes = null)

    @Stable
    class Loading(recipes: List<RecipeUI>? = null) : State(recipes)

    @Stable
    class Error(recipes: List<RecipeUI>? = null) : State(recipes)

    @Stable
    class Success(override val recipes: List<RecipeUI>) : State(recipes)
}
