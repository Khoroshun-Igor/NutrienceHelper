package com.tamago.recipe.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tamago.recipe.database.converters.Converters
import com.tamago.recipe.database.dao.RecipeDao
import com.tamago.recipe.database.models.IngredientDbo
import com.tamago.recipe.database.models.RecipeDbo
import com.tamago.recipe.database.models.RecipeInfoDbo

/**
 * Created by Igor Khoroshun on 31.05.2024.
 */

class RecipesDataBase internal constructor(private val dataBase: RecipesRoomDataBase) {
    val recipeDao: RecipeDao
        get() = dataBase.recipeDao()
}

@Database(
    entities = [
        RecipeDbo::class,
        RecipeInfoDbo::class,
        IngredientDbo::class
    ],
    version = 3
)
@TypeConverters(Converters::class)
internal abstract class RecipesRoomDataBase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}

fun RecipesDataBase(applicationContext: Context): RecipesDataBase {
    val newsRoomDataBase = Room.databaseBuilder(
        checkNotNull(applicationContext.applicationContext),
        RecipesRoomDataBase::class.java,
        "recipes"
    )
        .fallbackToDestructiveMigration()
        .build()
    return RecipesDataBase(newsRoomDataBase)
}
