package com.dirzaaulia.smartphonespec.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.dirzaaulia.smartphonespec.ui.latest.Latest
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@Composable
fun NavGraph(
  navHostController: NavHostController,
) {

  val actions = remember(navHostController) { NavActions(navHostController) }

  AnimatedNavHost(
    navController = navHostController,
    startDestination = NavScreen.Latest.route
  ) {
    composable(NavScreen.Latest.route) {
      Latest()
    }
  }
}