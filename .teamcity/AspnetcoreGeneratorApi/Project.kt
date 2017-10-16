package AspnetcoreGeneratorApi

import AspnetcoreGeneratorApi.buildTypes.*
import AspnetcoreGeneratorApi.vcsRoots.*
import AspnetcoreGeneratorApi.vcsRoots.AspnetcoreGeneratorApi_HttpsGithubComTimothyVandenbrandeAspnetcoreGeneratorApiGi
import jetbrains.buildServer.configs.kotlin.v10.*
import jetbrains.buildServer.configs.kotlin.v10.Project
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.VersionedSettings.*
import jetbrains.buildServer.configs.kotlin.v10.projectFeatures.versionedSettings

object Project : Project({
    uuid = "6049d0be-6409-45b7-b4b0-f1c53e6bafe5"
    extId = "AspnetcoreGeneratorApi"
    parentId = "_Root"
    name = "Aspnetcore Generator Api"

    vcsRoot(AspnetcoreGeneratorApi_HttpsGithubComTimothyVandenbrandeAspnetcoreGeneratorApiGi)

    buildType(AspnetcoreGeneratorApi_DeployDemo)
    buildType(AspnetcoreGeneratorApi_Build)
    buildType(AspnetcoreGeneratorApi_OnDemandTestingDeploy)
    buildType(AspnetcoreGeneratorApi_DeployProd)
    buildType(AspnetcoreGeneratorApi_IntegrationTests)

    features {
        versionedSettings {
            id = "PROJECT_EXT_2"
            mode = VersionedSettings.Mode.ENABLED
            buildSettingsMode = VersionedSettings.BuildSettingsMode.USE_CURRENT_SETTINGS
            rootExtId = AspnetcoreGeneratorApi_HttpsGithubComTimothyVandenbrandeAspnetcoreGeneratorApiGi.extId
            showChanges = false
            settingsFormat = VersionedSettings.Format.KOTLIN
            param("credentialsStorageType", "credentialsJSON")
        }
    }
})
