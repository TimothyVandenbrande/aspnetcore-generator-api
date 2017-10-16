package AspnetcoreGeneratorApi.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v10.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.v10.triggers.VcsTrigger.*
import jetbrains.buildServer.configs.kotlin.v10.triggers.vcs

object AspnetcoreGeneratorApi_IntegrationTests : BuildType({
    uuid = "f7acb0af-ef3b-4dbc-bb6f-5e924694a52c"
    extId = "AspnetcoreGeneratorApi_IntegrationTests"
    name = "Integration Tests"

    params {
        param("env.GENERATOR_BUILD_NUMBER", "%dep.AspnetcoreGeneratorApi_Build.build.number%")
    }

    vcs {
        root(AspnetcoreGeneratorApi.vcsRoots.AspnetcoreGeneratorApi_HttpsGithubComTimothyVandenbrandeAspnetcoreGeneratorApiGi)

    }

    steps {
        script {
            workingDir = "integration"
            scriptContent = """
                docker-compose up \
                  --force-recreate \
                  --abort-on-container-exit \
                  --build
                
                docker-compose down
            """.trimIndent()
        }
    }

    triggers {
        vcs {
        }
    }

    dependencies {
        dependency(AspnetcoreGeneratorApi.buildTypes.AspnetcoreGeneratorApi_Build) {
            snapshot {
            }
        }
    }
})
