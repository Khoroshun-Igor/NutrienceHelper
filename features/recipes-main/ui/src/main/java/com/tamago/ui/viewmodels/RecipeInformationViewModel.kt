package com.tamago.ui.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamago.domain.model.RecipeInfoUI
import com.tamago.domain.usecases.GetRecipeByIdUseCase
import com.tamago.recipedata.RequestResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Igor Khoroshun on 01.08.2024.
 */

@HiltViewModel
class RecipeInformationViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getRecipeByIdUseCase: Provider<GetRecipeByIdUseCase>
) : ViewModel() {
    private val recipeId: Int = checkNotNull(savedStateHandle["recipeId"])

    val recipeUiState: StateFlow<RecipeInfoState> = getRecipeByIdUseCase.get().invoke(recipeId)
        .map { it.toRecipeInfoState() }
        .stateIn(viewModelScope, SharingStarted.Lazily, RecipeInfoState.None)
}

private fun RequestResult<RecipeInfoUI>.toRecipeInfoState(): RecipeInfoState {
    return when (this) {
        is RequestResult.Error -> com.tamago.ui.viewmodels.RecipeInfoState.Error()
        is RequestResult.InProgress -> com.tamago.ui.viewmodels.RecipeInfoState.Loading(data)
        is RequestResult.Success -> com.tamago.ui.viewmodels.RecipeInfoState.Success(data)
    }
}

sealed class RecipeInfoState(val recipe: RecipeInfoUI?) {
    data object None : RecipeInfoState(recipe = null)
    class Loading(recipe: RecipeInfoUI? = null) : RecipeInfoState(recipe)
    class Error(recipe: RecipeInfoUI? = null) : RecipeInfoState(recipe)
    class Success(recipe: RecipeInfoUI) : RecipeInfoState(recipe)
}
