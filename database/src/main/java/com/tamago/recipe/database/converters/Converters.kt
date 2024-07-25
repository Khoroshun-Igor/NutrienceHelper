package com.tamago.recipe.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tamago.recipe.database.models.RecipeInformationExtendedIngredientsInnerDbo
import java.lang.reflect.Type
import java.math.BigDecimal

/**
 * Created by Igor Khoroshun on 22.07.2024.
 */

class Converters {

    @TypeConverter
    fun fromBigDecimal(value: BigDecimal) = value.toString()

    @TypeConverter
    fun toBigDecimal(value: String) = BigDecimal(value)

    @TypeConverter
    fun fromListString(string: List<String>) = string.joinToString(", ")

    @TypeConverter
    fun toData(data: String) = data.split(",")

    @TypeConverter
    fun fromIngredientToJson(ingredientSet: Set<RecipeInformationExtendedIngredientsInnerDbo>) =
        Gson().toJson(ingredientSet)

    @TypeConverter
    fun fromJsonToIngredient(value: String): Set<RecipeInformationExtendedIngredientsInnerDbo> {
        val setIngredientDbo: Type =
            object : TypeToken<List<RecipeInformationExtendedIngredientsInnerDbo>>() {}.type
        return Gson().fromJson(value, setIngredientDbo)
    }
}
