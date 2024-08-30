package com.tamago.recipe.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

/**
 * Created by Igor Khoroshun on 17.06.2024.
 */

@Entity(tableName = "ingredients")
data class RecipeInformationExtendedIngredientsInnerDbo(
    @PrimaryKey(autoGenerate = true)
    val dbId: Long = 0,
    @ColumnInfo(name = "aisle")
    val aisle: String,
    @ColumnInfo(name = "amount")
    val amount: BigDecimal,
    @ColumnInfo(name = "consistency")
    val consistency: String,
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "original")
    val original: String,
    @ColumnInfo(name = "originalName")
    val originalName: String,
    @ColumnInfo(name = "unit")
    val unit: String
)
