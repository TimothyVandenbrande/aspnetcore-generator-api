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
        password = "credentialsJSON:dc95dea6-9796-4218-bcb2-0e5b8138661a"
    }
})
