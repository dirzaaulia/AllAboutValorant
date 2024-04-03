package com.dirzaaulia.formulaone.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink

const val HOME_ROUTE = "home_route}"

fun NavController.navigateForHome(navOptions: NavOptions) = navigate(HOME_ROUTE, navOptions)

fun NavGraphBuilder.homeScreen() {
    composable(
        route = HOME_ROUTE,
//        deepLinks = listOf(
//            navDeepLink { uriPattern = DEEP_LINK_URI_PATTERN },
//        ),
//        arguments = listOf(
//            navArgument(LINKED_NEWS_RESOURCE_ID) { type = NavType.StringType },
//        ),
    ) {
    }
}
