package com.tamago.ui.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tamago.domain.model.RecipeUI
import com.tamago.domain.usecases.GetAllRecipesUseCase
import com.tamago.recipedata.RequestResult
import com.tamago.ui.screens.main.State
import com.tamago.ui.screens.main.toState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Igor Khoroshun on 04.10.2024.
 */

@HiltViewModel
class RecipeSearchViewModel @Inject constructor(
    private val getAllRecipesUseCase: GetAllRecipesUseCase,
) : ViewModel() {
    var recipeList: MutableStateFlow<State> =
        MutableStateFlow(value = RequestResult.Success<List<RecipeUI>>(emptyList()).toState())

    private fun getRecipes(query: String) {
        viewModelScope.launch {
            getAllRecipesUseCase.invoke(query).collect { result ->
                recipeList.value = result.toState()
            }
        }
    }

    fun onSearchEvent(query: String) {
        getRecipes(query = query)
    }
}
