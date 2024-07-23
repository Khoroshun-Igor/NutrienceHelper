package com.tamago.recipe.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tamago.recipe.database.models.IngredientDbo
import java.lang.reflect.Type
import java.math.BigDecimal
import java.util.Arrays
import java.util.stream.Collectors

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
    fun fromIngredientToJson(ingredientSet: Set<IngredientDbo>) = Gson().toJson(ingredientSet)

    @TypeConverter
    fun fromJsonToIngredient(value: String): Set<IngredientDbo> {
        val setIngredientDbo: Type = object : TypeToken<List<IngredientDbo>>(){}.type
        return Gson().fromJson(value, setIngredientDbo)
    }
}