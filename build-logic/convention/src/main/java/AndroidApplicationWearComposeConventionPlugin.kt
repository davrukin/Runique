import com.plcoding.convention.DependencyProvider
import com.plcoding.convention.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidApplicationWearComposeConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("runique.android.application.compose")
            }

            dependencies {
                implementation(target, DependencyProvider.LIBRARY, "androidx.wear.compose.material")
                implementation(target, DependencyProvider.LIBRARY, "androidx.wear.compose.foundation")
                implementation(target, DependencyProvider.LIBRARY, "androidx.wear.compose.ui.tooling")
                implementation(target, DependencyProvider.LIBRARY, "play.services.wearable")
            }
        }
    }
}