//package com.dirzaaulia.formulaone.core.ui
//
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.DisposableEffect
//import com.google.samples.apps.nowinandroid.core.analytics.AnalyticsEvent
//import com.google.samples.apps.nowinandroid.core.analytics.AnalyticsEvent.Param
//import com.google.samples.apps.nowinandroid.core.analytics.AnalyticsEvent.ParamKeys
//import com.google.samples.apps.nowinandroid.core.analytics.AnalyticsEvent.Types
//import com.google.samples.apps.nowinandroid.core.analytics.AnalyticsHelper
//import com.google.samples.apps.nowinandroid.core.analytics.LocalAnalyticsHelper
//
///**
// * Classes and functions associated with analytics events for the UI.
// */
//fun AnalyticsHelper.logScreenView(screenName: String) {
//    logEvent(
//        AnalyticsEvent(
//            type = Types.SCREEN_VIEW,
//            extras = listOf(
//                Param(ParamKeys.SCREEN_NAME, screenName),
//            ),
//        ),
//    )
//}
//
//fun AnalyticsHelper.logNewsResourceOpened(newsResourceId: String) {
//    logEvent(
//        event = AnalyticsEvent(
//            type = "news_resource_opened",
//            extras = listOf(
//                Param("opened_news_resource", newsResourceId),
//            ),
//        ),
//    )
//}
//
///**
// * A side-effect which records a screen view event.
// */
//@Composable
//fun TrackScreenViewEvent(
//    screenName: String,
//    analyticsHelper: AnalyticsHelper = LocalAnalyticsHelper.current,
//) = DisposableEffect(Unit) {
//    analyticsHelper.logScreenView(screenName)
//    onDispose {}
//}
