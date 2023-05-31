package com.example.electronioproject.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Component : Screen("Component")
    object Article : Screen("Article")
    object Profile : Screen("profile")
    object DetailProduct : Screen("Component/{Component}") {
        fun createRoute(productId: Long) = "Component/$productId"
    }
}
