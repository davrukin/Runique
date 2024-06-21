package com.plcoding.convention

import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project

fun DependencyHandlerScope.addUiLayerDependencies(project: Project) {
    implementation(":core:presentation:ui")
    implementation(":core:presentation:designsystem")

    implementation(project, DependencyProvider.BUNDLE, "koin.compose")
    implementation(project, DependencyProvider.BUNDLE, "compose")
    debugImplementation(project, DependencyProvider.BUNDLE, "compose.debug")
    androidTestImplementation(project, DependencyProvider.LIBRARY, "androidx.compose.ui.test.junit4")
}

private const val IMPLEMENTATION = "implementation"
private const val DEBUG_IMPLEMENTATION = "debugImplementation"
private const val ANDROID_TEST_IMPLEMENTATION = "androidTestImplementation"
private const val KSP = "ksp"

private fun findDependency(
    project: Project,
    provider: DependencyProvider,
    alias: String,
): Provider<out Any> {
    return when(provider) {
        DependencyProvider.BUNDLE -> project.findBundle(alias)
        DependencyProvider.LIBRARY -> project.findLibrary(alias)
    }
}

fun DependencyHandlerScope.implementation(
    project: Project,
    provider: DependencyProvider,
    alias: String,
) {
    IMPLEMENTATION(findDependency(project, provider, alias))
}

fun DependencyHandlerScope.implementation(
    alias: String,
) {
    IMPLEMENTATION(project(alias))
}

fun <T> DependencyHandlerScope.implementation(
    provider: Provider<T>,
) {
    IMPLEMENTATION(provider)
}

fun DependencyHandlerScope.debugImplementation(
    project: Project,
    provider: DependencyProvider,
    alias: String,
) {
    DEBUG_IMPLEMENTATION(findDependency(project, provider, alias))
}

fun DependencyHandlerScope.androidTestImplementation(
    project: Project,
    provider: DependencyProvider,
    alias: String,
) {
    ANDROID_TEST_IMPLEMENTATION(findDependency(project, provider, alias))
}

fun <T> DependencyHandlerScope.androidTestImplementation(
    provider: Provider<T>,
) {
    ANDROID_TEST_IMPLEMENTATION(provider)
}

fun DependencyHandlerScope.ksp(
    project: Project,
    provider: DependencyProvider,
    alias: String,
) {
    KSP(findDependency(project, provider, alias))
}