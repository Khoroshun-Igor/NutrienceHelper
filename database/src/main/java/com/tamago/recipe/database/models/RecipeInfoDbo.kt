package com.tamago.recipe.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.tamago.recipe.database.converters.Converters
import java.math.BigDecimal

/**
 * Created by Igor Khoroshun on 14.06.2024.
 */

@Entity(tableName = "favoriteRecipe")
data class RecipeInfoDbo(
    @PrimaryKey(autoGenerate = true)
    val dbId: Long = 0,
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("image")
    val image: String,
    @ColumnInfo("servings")
    @TypeConverters(Converters::class)
    val servings: BigDecimal,
    @ColumnInfo("readyInMinutes")
    val readyInMinutes: Int,
    @ColumnInfo("sourceUrl")
    val sourceUrl: String,
    @ColumnInfo(name = "spoonacularSourceUrl")
    val spoonacularSourceUrl: String,
    @ColumnInfo("healthScore")
    @TypeConverters(Converters::class)
    val healthScore: BigDecimal,
    @ColumnInfo("spoonacularScore")
    @TypeConverters(Converters::class)
    val spoonacularScore: BigDecimal,
    @ColumnInfo("analyzedInstructions")
    @TypeConverters(Converters::class)
    val analyzedInstructions: List<String>,
    @ColumnInfo("cheap")
    val cheap: Boolean,
    @ColumnInfo("creditsText")
    val creditsText: String,
    @ColumnInfo("cuisines")
    @TypeConverters(Converters::class)
    val cuisines: List<String>,
    @ColumnInfo("dairyFree")
    val dairyFree: Boolean,
    @ColumnInfo("diets")
    @TypeConverters(Converters::class)
    val diets: List<String>,
    @ColumnInfo("gaps")
    val gaps: String,
    @ColumnInfo("glutenFree")
    val glutenFree: Boolean,
    @ColumnInfo("instructions")
    val instructions: String,
    @ColumnInfo("ketogenic")
    val ketogenic: Boolean,
    @ColumnInfo("lowFodmap")
    val lowFodmap: Boolean,
    @ColumnInfo("occasions")
    @TypeConverters(Converters::class)
    val occasions: List<String>,
    @ColumnInfo("sustainable")
    val sustainable: Boolean,
    @ColumnInfo("vegan")
    val vegan: Boolean,
    @ColumnInfo("vegetarian")
    val vegetarian: Boolean,
    @ColumnInfo("veryHealthy")
    val veryHealthy: Boolean,
    @ColumnInfo("veryPopular")
    val veryPopular: Boolean,
    @ColumnInfo("whole30")
    val whole30: Boolean,
    @ColumnInfo("weightWatcherSmartPoints")
    @TypeConverters(Converters::class)
    val weightWatcherSmartPoints: BigDecimal,
    @ColumnInfo("dishTypes")
    @TypeConverters(Converters::class)
    val dishTypes: List<String>,
    @ColumnInfo("extendedIngredients")
    val extendedIngredients: Set<RecipeInformationExtendedIngredientsInnerDbo>,
)
