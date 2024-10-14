package com.tamago.domain.mappers

import com.tamago.domain.model.RecipeInfoUI
import com.tamago.domain.utils.Constants

/**
 * Created by Igor Khoroshun on 08.10.2024.
 */

fun RecipeInfoUI.toTagList(): List<String> {
    val listOfTags = emptyList<String>().toMutableList()
    listOfTags += cuisines
    listOfTags += dishTypes
    listOfTags += diets
    if (cheap) listOfTags += Constants.CHEAP
    if (dairyFree) listOfTags += Constants.DAIRY_FREE
    if (glutenFree) listOfTags += Constants.GLUTEN_FREE
    if (lowFodmap) listOfTags += Constants.LOW_FODMAP
    if (sustainable) listOfTags += Constants.SUSTAINABLE
    if (vegan) listOfTags += Constants.VEGAN
    if (vegetarian) listOfTags += Constants.VEGETARIAN
    if (veryHealthy) listOfTags += Constants.VERY_HEALTHY
    if (veryPopular) listOfTags += Constants.VERY_POPULAR
    return listOfTags
}
