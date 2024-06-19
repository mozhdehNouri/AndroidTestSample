pluginManagement {
    repositories {

        repositories {
            if (System.getenv("USE_SAMENTIC_MAVEN")
                    ?.toBooleanStrictOrNull() == true
            ) {
                maven {
                    url = uri(System.getenv("SAMENTIC_NEXUS_URL")!!)
                    credentials {
                        username =
                            System.getenv("SAMENTIC_NEXUS_USERNAME")!!
                        password =
                            System.getenv("SAMENTIC_NEXUS_PASSWORD")!!
                    }
                }
            } else {
                google {
                    content {
                        includeGroupByRegex("com\\.android.*")
                        includeGroupByRegex("com\\.google.*")
                        includeGroupByRegex("androidx.*")
                    }
                }
                mavenCentral()
                gradlePluginPortal()
            }
        }

    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        if (System.getenv("USE_SAMENTIC_MAVEN")
                ?.toBooleanStrictOrNull() == true
        ) {
            maven {
                url = uri(System.getenv("SAMENTIC_NEXUS_URL")!!)
                credentials {
                    username = System.getenv("SAMENTIC_NEXUS_USERNAME")!!
                    password = System.getenv("SAMENTIC_NEXUS_PASSWORD")!!
                }
            }
        } else {
            google()
            mavenCentral()
            gradlePluginPortal()
        }
    }
}

rootProject.name = "AndroidTestSAmple"
include(":app")
 