import com.plcoding.convention.DependencyProvider
import com.plcoding.convention.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class JvmKtorConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.apply("org.jetbrains.kotlin.plugin.serialization")

            dependencies {
                implementation(target, DependencyProvider.BUNDLE, "ktor")
            }
        }
    }
}