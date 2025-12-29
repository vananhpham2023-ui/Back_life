package com.linghui.app.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.linghui.core.ui.navigation.AppRoutes
import com.linghui.feature.home.HomeRoute
import com.linghui.feature.logs.LogsRoute
import com.linghui.feature.me.MeRoute
import com.linghui.feature.tasks.TaskDetailRoute
import com.linghui.feature.tasks.TasksRoute

@Composable
@Suppress("FunctionName")
fun AppNavHost() {
    val navController = rememberNavController()
    val items =
        listOf(
            BottomNavItem(AppRoutes.HOME, "Home", Icons.Default.Home),
            BottomNavItem(AppRoutes.TASKS, "Tasks", Icons.Default.List),
            BottomNavItem(AppRoutes.LOGS, "Logs", Icons.Default.BarChart),
            BottomNavItem(AppRoutes.ME, "Me", Icons.Default.Person),
        )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEach { item ->
                    val selected = currentDestination?.hierarchy?.any { it.route == item.route } == true
                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                        label = { Text(text = item.label) },
                    )
                }
            }
        },
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = AppRoutes.HOME,
            modifier = Modifier.padding(padding),
        ) {
            composable(AppRoutes.HOME) {
                HomeRoute()
            }
            composable(AppRoutes.TASKS) {
                TasksRoute(
                    onNavigateToDetail = { taskId ->
                        navController.navigate(AppRoutes.taskDetail(taskId))
                    },
                )
            }
            composable(AppRoutes.LOGS) {
                LogsRoute()
            }
            composable(AppRoutes.ME) {
                MeRoute()
            }
            composable(
                route = AppRoutes.TASK_DETAIL,
                arguments = listOf(navArgument(AppRoutes.ARG_TASK_ID) { type = NavType.StringType }),
            ) { backStackEntry ->
                val taskId = backStackEntry.arguments?.getString(AppRoutes.ARG_TASK_ID).orEmpty()
                TaskDetailRoute(
                    taskId = taskId,
                    onBack = { navController.popBackStack() },
                )
            }
        }
    }
}

private data class BottomNavItem(
    val route: String,
    val label: String,
    val icon: ImageVector,
)
