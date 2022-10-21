/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.nowinandroid.feature.foryou.navigation

import android.net.Uri
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.google.samples.apps.nowinandroid.core.navigation.NiaNavigationDestination
import com.google.samples.apps.nowinandroid.feature.foryou.ForYouRoute

object ForYouDestination : NiaNavigationDestination {
    override val route = "for_you_route"
    override val destination = "for_you_destination"

    /**
     * Creates destination route for a topicId that could include special characters
     */
    fun createNavigationRoute(topicIdArg: String): String {
        val encodedId = Uri.encode(topicIdArg)
        return "foryou_route/$encodedId"
    }
}

fun NavGraphBuilder.forYouGraph(
    navigateToTopic: (String) -> Unit
) {
    navigation(
        route = ForYouDestination.route,
        startDestination = ForYouDestination.destination
    ) {
        composable(route = ForYouDestination.route) {
            ForYouRoute(navigateToTopic = navigateToTopic)
        }
    }
}