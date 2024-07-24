package com.tamago.recipe.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tamago.recipe.database.dao.RecipeDao
import com.tamago.recipe.database.models.RecipeDbo
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Igor Khoroshun on 14.06.2024.
 */

@RunWith(AndroidJUnit4::class)
class RecipesRoomDataBaseTest : TestCase() {
    private lateinit var db: RecipesRoomDataBase
    private lateinit var dao: RecipeDao

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, RecipesRoomDataBase::class.java).build()
        dao = db.recipeDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun writeAndReadRecipe() = runBlocking {
        val sandwich =
            RecipeDbo(dbId = 1, id = 1, title = "sandwich", image = "xxx.jpg", imageType = ".jpg")
        val recipesList = listOf(sandwich)
        dao.insert(recipesList)
        val recipe = dao.getRecipeById(1)
        assertThat(recipe.get(0), equalTo(sandwich))
    }
}