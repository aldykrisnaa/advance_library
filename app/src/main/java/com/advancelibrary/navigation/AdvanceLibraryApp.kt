package com.advancelibrary.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NotificationAdd
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.advancelibrary.R
import com.advancelibrary.alarm.shouldShowBottomBar
import com.advancelibrary.ui.theme.Kuning
import com.advancelibrary.ui.theme.screen.AlarmScreen
import com.advancelibrary.ui.theme.screen.BerandaScreen
import com.advancelibrary.ui.theme.screen.DetailBookFiksi
import com.advancelibrary.ui.theme.screen.DetailBookNonFiksi
import com.advancelibrary.ui.theme.screen.LoginScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdvanceLibraryApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route


    Scaffold(
        topBar = {
            AnimatedVisibility(
                visible = currentRoute.shouldShowBottomBar(),
            ) {
                TopAppBar(
                    title = { Text(text = "Advance Library") },
                    actions = {
                        IconButton(onClick = { navController.navigate(Screen.Alarm.route) }) {
                            Icon(
                                imageVector = Icons.Default.NotificationAdd,
                                tint = Kuning,
                                contentDescription = stringResource(id = R.string.alarm)
                            )
                        }
                    }
                )
            }
        },
        bottomBar = {
            AnimatedVisibility(
                visible = currentRoute.shouldShowBottomBar()
            ) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = modifier.padding(contentPadding)
        ) {
          composable(Screen.Login.route) {
              LoginScreen(navController)
           }

            composable(Screen.Beranda.route) {
                BerandaScreen(navController)
            }
            composable(
                Screen.DetailBookFiksi.route + "/{itemfiksiId}",
                arguments = listOf(navArgument("itemfiksiId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailBookFiksi(
                    navController = navController,
                    detailbooksfiksiId = navBackStackEntry.arguments?.getInt("itemfiksiId")
                )
            }
            composable(
                Screen.DetailBookNonFiksi.route + "/{itemnonfiksiId}",
                arguments = listOf(navArgument("itemnonfiksiId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailBookNonFiksi(
                    navController = navController,
                    detailbooksnonfiksiId = navBackStackEntry.arguments?.getInt("itemnonfiksiId")
                )
            }

            composable(Screen.Alarm.route) {
                AlarmScreen(navController = navController)
            }

        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier:Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_beranda),
                image = R.drawable.ic_beranda,
                screen = Screen.Beranda
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_search),
                image = R.drawable.ic_search,
                screen = Screen.Search
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_akun),
                image = R.drawable.ic_akun,
                screen = Screen.Akun
            )
        )

        navigationItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.image),
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(text = item.title)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AdvanceLibararyPrev() {
    AdvanceLibraryApp()
}