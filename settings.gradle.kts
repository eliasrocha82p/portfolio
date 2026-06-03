//./portfolio/settings.gradle.kts
pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    // Mantém o Foojay ativo para baixar o Java 21 automaticamente se necessário
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0" 
}

rootProject.name = "portfolio"

// Submódulos ativos no ecossistema do seu Portfólio
include("app")
include("DTOs")
include("daos")
include("services")

// Módulos comentados caso decida reativá-los no futuro:
 include("repositories")
// include("config")
// include("mappers")
