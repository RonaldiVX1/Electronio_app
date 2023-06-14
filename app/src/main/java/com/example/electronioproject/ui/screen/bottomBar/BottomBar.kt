package com.example.electronioproject.ui.screen.bottomBar

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.electronioproject.R
import com.example.electronioproject.ui.navigation.NavigationItem
import com.example.electronioproject.ui.navigation.Screen


@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    BottomAppBar(
        cutoutShape = CircleShape
    ) {
        BottomNavigation(
            modifier = modifier
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            val navigationItems = listOf(
                NavigationItem(
                    title = stringResource(R.string.menu_home),
                    icon = Icons.Default.Home,
                    screen = Screen.Home
                ),
                NavigationItem(
                    title = stringResource(R.string.menu_component),
                    icon = Icons.Default.Search,
                    screen = Screen.Component
                ),
                NavigationItem(
                    title = stringResource(R.string.menu_article),
                    icon = Icons.Default.Info,
                    screen = Screen.Article
                ),
                NavigationItem(
                    title = stringResource(R.string.menu_profile),
                    icon = Icons.Default.AccountCircle,
                    screen = Screen.Profile
                ),
            )
            BottomNavigation {
                navigationItems.map { item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title
                            )
                        },
                        label = { Text(item.title) },
                        selected = currentRoute == item.screen.route,
                        onClick = {
                            navController.navigate(item.screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                restoreState = true
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    }

}
