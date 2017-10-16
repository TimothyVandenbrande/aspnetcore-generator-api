package AspnetcoreGeneratorApi.buildTypes

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.ScriptBuildStep.*
import jetbrains.buildServer.configs.kotlin.v10.buildSteps.script

object AspnetcoreGeneratorApi_Build : BuildType({
    uuid = "f3d26ac3-a0a2-426f-8994-82b70f528594"
    extId = "AspnetcoreGeneratorApi_Build"
    name = "Build"

    vcs {
        root(AspnetcoreGeneratorApi.vcsRoots.AspnetcoreGeneratorApi_HttpsGithubComTimothyVandenbrandeAspnetcoreGeneratorApiGi)

    }

    steps {
        script {
            scriptContent = """
                image="my-registry:55000/gen:ci-%build.number%"
                docker build -t ${'$'}image .
                docker push ${'$'}image
                
                latest="my-registry:55000/gen:ci-latest"
                docker tag ${'$'}image ${'$'}latest
                docker push ${'$'}latest
            """.trimIndent()
        }
    }
})
