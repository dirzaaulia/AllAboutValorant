package com.dirzaaulia.formulaone.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.dirzaaulia.formulaone.R
import com.dirzaaulia.formulaone.core.designsystem.icon.FormulaOneIcons
import com.dirzaaulia.formulaone.feature.home.R as homeR

/**
 * Type for the top level destinations in the application. Each of these destinations
 * can contain one or more screens (based on the window size). Navigation from one screen to the
 * next within a single destination will be handled directly in composables.
 */
enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {
    HOME(
        selectedIcon = FormulaOneIcons.Upcoming,
        unselectedIcon = FormulaOneIcons.UpcomingBorder,
        iconTextId = homeR.string.feature_home_title,
        titleTextId = R.string.app_name,
    ),
}
