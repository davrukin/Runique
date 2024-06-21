package com.plcoding.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.run {
        buildFeatures {
            compose = true
        }

        dependencies {
            val bom = platform(findLibrary("androidx.compose.bom"))

            implementation(bom)
            androidTestImplementation(bom)
            debugImplementation(this@configureAndroidCompose, DependencyProvider.LIBRARY, "androidx.compose.ui.tooling.preview")
        }
    }
}