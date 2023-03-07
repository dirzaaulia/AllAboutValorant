package com.dirzaaulia.baseprojectcompose.utils

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.shimmer
import com.google.accompanist.placeholder.placeholder

fun Modifier.visible(visibility: Boolean): Modifier = this.then(alpha(if (visibility) 1f else 0f))

fun Modifier.fadePlaceholder(): Modifier = composed {
    this.then(
        placeholder(
            visible = true,
            color = MaterialTheme.colorScheme.surfaceVariant,
            highlight = PlaceholderHighlight.shimmer()
        )
    )
}
