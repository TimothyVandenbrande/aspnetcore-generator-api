package AspnetcoreGeneratorApi.vcsRoots

import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.vcs.GitVcsRoot

object AspnetcoreGeneratorApi_HttpsGithubComTimothyVandenbrandeAspnetcoreGeneratorApiGi : GitVcsRoot({
    uuid = "0e01fb52-f43f-4780-b4a1-84c6b80a527d"
    extId = "AspnetcoreGeneratorApi_HttpsGithubComTimothyVandenbrandeAspnetcoreGeneratorApiGi"
    name = "https://github.com/TimothyVandenbrande/aspnetcore-generator-api.git#refs/heads/wip"
    url = "https://github.com/TimothyVandenbrande/aspnetcore-generator-api.git"
    branch = "refs/heads/wip"
    authMethod = password {
        userName = "timothyvandenbrande"
        password = "credentialsJSON:9e5412e0-4dca-42d3-9623-3d9223619855"
    }
})
