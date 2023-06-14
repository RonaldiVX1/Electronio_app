package com.example.electronioproject.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.electronioproject.R
import com.example.electronioproject.ui.navigation.Screen
import com.example.electronioproject.ui.screen.article.ArticleScreen
import com.example.electronioproject.ui.screen.bottomBar.BottomNavigationBar
import com.example.electronioproject.ui.screen.component.ComponentScreen
import com.example.electronioproject.ui.screen.detail_article.DetailArticleScreen
import com.example.electronioproject.ui.screen.detail_component.DetailComponentScreen
import com.example.electronioproject.ui.screen.detail_scanner.DetailScannerScreen
import com.example.electronioproject.ui.screen.home.HomeScreen
import com.example.electronioproject.ui.screen.login.LoginScreen
import com.example.electronioproject.ui.screen.profile.ProfileScreen
import com.example.electronioproject.ui.screen.profile.profile_menu.help_center.HelpCenterScreen
import com.example.electronioproject.ui.screen.profile.profile_menu.privacy_policy.PrivacyAndPolicyScreen
import com.example.electronioproject.ui.screen.profile.profile_menu.terms_conditions.TermsAndConditionsScreen
import com.example.electronioproject.ui.screen.register.RegisterScreen
import com.example.electronioproject.ui.screen.scanner.CameraScreen
import com.example.electronioproject.ui.screen.scanner.ScannerScreen
import com.example.electronioproject.ui.theme.Grey2

@Composable
fun ElectronioApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        backgroundColor = Grey2,
        bottomBar = {
            if (currentRoute != Screen.Login.route && currentRoute != Screen.Register.route && currentRoute != Screen.Camera.route) {
                BottomNavigationBar(navController)
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton =
        {
            if (currentRoute != Screen.Login.route && currentRoute != Screen.Register.route && currentRoute != Screen.Camera.route) {

                FloatingActionButton(
                    shape = CircleShape,
                    onClick = {
                        navController.navigate(Screen.Scanner.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                        }
                    },
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_open_camera),
                        contentDescription = "open camera section",
                        modifier = modifier
                            .size(45.dp)
                    )
                }
            }
        }


    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Login.route) {
                LoginScreen(
                    navigateToRegister = {
                        navController.navigate(Screen.Register.route)
                    },
                    onNavigateToHome = {
                        navController.navigate(Screen.Home.route){
                            popUpTo(navController.graph.findStartDestination().id) {
                                inclusive = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable(Screen.Home.route) {
                HomeScreen(
                    onNavigateToArticle = {
                        navController.navigate(Screen.Article.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    },
                    onNavigateToComponent = {
                        navController.navigate(Screen.Component.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    },
                    onNavigateToScanner = {
                        navController.navigate(Screen.Scanner.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    },
                )
            }
            composable(Screen.Profile.route) {
                ProfileScreen(
                    onNavigateToLogin = {
                        navController.navigate(Screen.Login.route)
                    },
                    onNavigateToPAP = {
                        navController.navigate(Screen.PrivacyAndPolicy.route)
                    },
                    onNavigateToTAC = {
                        navController.navigate(Screen.TermsAndConditions.route)
                    },
                    onNavigateToHelpCenter = {
                        navController.navigate(Screen.HelpCenter.route)
                    },

                    )
            }
            composable(Screen.Register.route) {
                RegisterScreen(
                    onNavigateToLogin = {
                        navController.navigate(Screen.Login.route)
                    }
                )
            }
            composable(Screen.Camera.route) {
                CameraScreen()
            }
            composable(Screen.Component.route) {
                ComponentScreen(
                    navigateToDetail = { componentId ->
                        navController.navigate(Screen.DetailComponent.createRoute(componentId))
                    })

            }
            composable(Screen.Article.route) {
                ArticleScreen(
                    navigateToDetailArticle = { articleId ->
                        navController.navigate(Screen.DetailArticle.createRoute(articleId))
                    })
            }

            composable(Screen.Scanner.route) {
                ScannerScreen(
                    navigateToDetail = { componentId ->
                        navController.navigate(Screen.DetailComponent.createRoute(componentId))
                    })

            }
            composable(
                route = Screen.DetailComponent.route,
                arguments = listOf(navArgument("componentId") { type = NavType.LongType }),
            ) {
                val id = it.arguments?.getLong("componentId") ?: -1L
                DetailComponentScreen(componentId = id)

            }
            composable(
                route = Screen.DetailArticle.route,
                arguments = listOf(navArgument("articleId") { type = NavType.LongType }),
            ) {
                val id = it.arguments?.getLong("articleId") ?: -1L
                DetailArticleScreen(articleId = id)

            }
            composable(
                route = Screen.DetailScanner.route,
                arguments = listOf(navArgument("scanComponentId") { type = NavType.LongType }),
            ) {
                val id = it.arguments?.getLong("scanComponentId") ?: -1L
                DetailScannerScreen(scanComponentId = id)

            }
            composable(Screen.TermsAndConditions.route) {
                TermsAndConditionsScreen()
            }
            composable(Screen.PrivacyAndPolicy.route) {
                PrivacyAndPolicyScreen()
            }
            composable(Screen.HelpCenter.route) {
                HelpCenterScreen()
            }
        }
    }
}