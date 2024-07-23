package com.tamago.nutriencehelper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tamago.recipes_uikit.NutrienceHelperTheme
import com.tamago.recipes_main.RecipeMainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NutrienceHelperTheme {
                RecipeMainScreen()
            }
        }
    }
}