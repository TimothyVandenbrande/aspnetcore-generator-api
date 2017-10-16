package AspnetcoreGeneratorApi.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v10.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.v10.triggers.VcsTrigger.*
import jetbrains.buildServer.configs.kotlin.v10.triggers.vcs

object AspnetcoreGeneratorApi_DeployDemo : BuildType({
    uuid = "ef69eccf-7154-41b4-b319-7660a1612dce"
    extId = "AspnetcoreGeneratorApi_DeployDemo"
    name = "Deploy Demo"

    params {
        param("env.GENERATOR_BUILD_NUMBER", "%dep.AspnetcoreGeneratorApi_Build.build.number%")
    }

    vcs {
        root(AspnetcoreGeneratorApi.vcsRoots.AspnetcoreGeneratorApi_HttpsGithubComTimothyVandenbrandeAspnetcoreGeneratorApiGi)

    }

    steps {
        script {
            workingDir = "deploy"
            scriptContent = """
                export DOCKER_HOST=192.168.66.201
                docker stack deploy -c demo.yml demo
            """.trimIndent()
        }
    }

    triggers {
        vcs {
        }
    }

    dependencies {
        dependency(AspnetcoreGeneratorApi.buildTypes.AspnetcoreGeneratorApi_IntegrationTests) {
            snapshot {
            }
        }
    }
})
