package com.example.electronioproject.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Component : Screen("component")
    object Article : Screen("article")
    object Profile : Screen("profile")


    object DetailArticle: Screen("article/{articleId}") {
        fun createRoute(articleId: Long) = "article/$articleId"
    }

    object DetailComponent : Screen("component/{componentId}") {
        fun createRoute(componentId: Long) = "component/$componentId"
    }
    object DetailScanner : Screen("scanner/{scannerId}"){
        fun createRoute(scannerId: Long) = "component/$scannerId"
    }

    object Camera : Screen("camera")

    object TermsAndConditions : Screen("profile/tac")

    object PrivacyAndPolicy : Screen("pap")

    object HelpCenter : Screen("help")

    object Scanner : Screen("scanner")

    object Register : Screen("register")

    object Login : Screen("login")

}
