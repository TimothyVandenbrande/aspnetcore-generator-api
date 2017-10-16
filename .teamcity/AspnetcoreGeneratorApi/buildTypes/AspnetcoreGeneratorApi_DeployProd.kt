package AspnetcoreGeneratorApi.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script

object AspnetcoreGeneratorApi_DeployProd : BuildType({
    uuid = "0d1f6e4b-85b8-493d-b6f8-07623ce2a1a0"
    extId = "AspnetcoreGeneratorApi_DeployProd"
    name = "Deploy Prod"

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
                docker stack deploy -c prod.yml prod
            """.trimIndent()
        }
    }

    dependencies {
        dependency(AspnetcoreGeneratorApi.buildTypes.AspnetcoreGeneratorApi_IntegrationTests) {
            snapshot {
            }
        }
    }
})
