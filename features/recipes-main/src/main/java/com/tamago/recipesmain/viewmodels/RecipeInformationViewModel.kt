package com.tamago.recipesmain.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamago.recipedata.RequestResult
import com.tamago.recipesmain.model.RecipeInfoUI
import com.tamago.recipesmain.usecases.GetRecipeByIdUseCase
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
internal class RecipeInformationViewModel @Inject constructor(
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
        is RequestResult.Error -> RecipeInfoState.Error()
        is RequestResult.InProgress -> RecipeInfoState.Loading(data)
        is RequestResult.Success -> RecipeInfoState.Success(data)
    }
}

internal sealed class RecipeInfoState(val recipe: RecipeInfoUI?) {
    data object None : RecipeInfoState(recipe = null)
    class Loading(recipe: RecipeInfoUI? = null) : RecipeInfoState(recipe)
    class Error(recipe: RecipeInfoUI? = null) : RecipeInfoState(recipe)
    class Success(recipe: RecipeInfoUI) : RecipeInfoState(recipe)
}
