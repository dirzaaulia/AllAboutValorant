package com.dirzaaulia.smartphonespec.ui.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import com.dirzaaulia.smartphonespec.utils.visible

@Composable
fun CommonLoading(
    visibility: Boolean
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .visible(visibility)
    ) {
        val (loading) = createRefs()
        CircularProgressIndicator(
            modifier = Modifier
                .constrainAs(loading) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}