package com.plcoding.convention

import org.gradle.api.Project
import org.gradle.api.artifacts.ExternalModuleDependencyBundle
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType

val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun Project.libVersionString(alias: String): String {
    return libs.findVersion(alias).get().toString()
}

fun Project.libVersionInt(alias: String): Int {
    return libVersionString(alias).toInt()
}

fun Project.findBundle(alias: String): Provider<ExternalModuleDependencyBundle> {
    return libs.findBundle(alias).get()
}

fun Project.findLibrary(alias: String): Provider<MinimalExternalModuleDependency> {
    return libs.findLibrary(alias).get()
}
