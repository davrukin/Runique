import androidx.room.gradle.RoomExtension
import com.plcoding.convention.DependencyProvider
import com.plcoding.convention.implementation
import com.plcoding.convention.ksp
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidRoomConventionPlugin: Plugin<Project> {

    override fun apply(target: Project) {
        target.run {
            pluginManager.run {
                apply("androidx.room")
                apply("com.google.devtools.ksp")
            }

            extensions.configure<RoomExtension> {
                schemaDirectory("$projectDir/schemas")
            }

            dependencies {
                implementation(target, DependencyProvider.LIBRARY, "room.runtime")
                implementation(target, DependencyProvider.LIBRARY, "room.ktx")
                ksp(target, DependencyProvider.LIBRARY, "room.compiler")
            }
        }
    }
}