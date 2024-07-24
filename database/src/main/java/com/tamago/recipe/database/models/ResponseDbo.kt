package com.tamago.recipe.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ResponseDbo<E>(
    @PrimaryKey(autoGenerate = true)
    val dbId: Long = 0,
    @ColumnInfo("offset")
    val offset: Int,
    @ColumnInfo("number")
    val number: Int,
    @ColumnInfo("results")
    val results: Set<E>,
    @ColumnInfo("totalResults")
    val totalResults: Int
)
