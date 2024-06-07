package com.tamago.recipe.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tamago.recipe.database.models.RecipeDbo
import kotlinx.coroutines.flow.Flow

/**
 * Created by Igor Khoroshun on 31.05.2024.
 */

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipes")
    suspend fun getAll(): List<RecipeDbo>

    @Query("SELECT * FROM recipes")
    fun observeAll(): Flow<List<RecipeDbo>>

    @Insert
    suspend fun insert(recipesDBO: List<RecipeDbo>)
}