package com.tamago.recipe.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class RecipeDbo(
    @PrimaryKey(autoGenerate = true)
    val dbId: Long = 0,
    @ColumnInfo("id")
    val id: Int,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("image")
    val image: String,
    @ColumnInfo("imageType")
    val imageType: String
)
