package AspnetcoreGeneratorApi.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script

object AspnetcoreGeneratorApi_OnDemandTestingDeploy : BuildType({
    uuid = "e0df3e03-0ccf-410e-9c43-9f2fc768cc9d"
    extId = "AspnetcoreGeneratorApi_OnDemandTestingDeploy"
    name = "On-Demand Testing Deploy"

    params {
        param("env.GENERATOR_BUILD_NUMBER", "%dep.AspnetcoreGeneratorApi_Build.build.number%")
        select("env.STACK_NAME", "", label = "Environment / stack name", description = "Which environment (stack name) to deploy to?", display = ParameterDisplay.PROMPT,
                options = listOf("on-demand-1", "on-demand-2", "on-demand-3", "on-demand-4"))
    }

    vcs {
        root(AspnetcoreGeneratorApi.vcsRoots.AspnetcoreGeneratorApi_HttpsGithubComTimothyVandenbrandeAspnetcoreGeneratorApiGi)

    }

    steps {
        script {
            workingDir = "deploy"
            scriptContent = """
                #!/bin/bash
                
                export DOCKER_HOST=192.168.6.201
                
                # determine stack number by removing all non-numeric characters
                stack_num=${'$'}{STACK_NAME//[^0-9]/}
                echo "stack_num: ${'$'}{stack_num}"
                
                # ports start at 8100
                # incremented by 10 so we have up to 10 ports per environment
                # so, on-demand-1 maps to 8110 and 8111, on-demand-2 maps to 8120 and 8121, etc
                
                # compute port for generator 
                export PORT_GENERATOR=`expr ${'$'}{stack_num} "*" 10 + 8100`
                echo "generator port: ${'$'}{PORT_GENERATOR}"
                
                # compute port for mailhog
                export PORT_MAILHOG=`expr ${'$'}{PORT_GENERATOR} + 1`
                echo "mailhog port: ${'$'}{PORT_MAILHOG}"
                
                echo "compose config check:"
                docker-compose -f demo.yml config
                
                docker stack deploy -c demo.yml ${'$'}{STACK_NAME}
            """.trimIndent()
        }
    }

    dependencies {
        dependency(AspnetcoreGeneratorApi.buildTypes.AspnetcoreGeneratorApi_Build) {
            snapshot {
            }
        }
    }
})
