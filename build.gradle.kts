plugins {
    // Declara os plugins do catálogo 'libs.versions.toml' sem aplicá-los na raiz
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.spring.dependencyManagement) apply false
    
    // Plugins nativos do Gradle não usam 'alias', usamos 'id'
  //  id("java-library") apply false
}

// Configuração compartilhada para TODOS os submódulos
subprojects {
    repositories {
        mavenCentral()
    }

    // Garante que todos os submódulos compilem usando o Java 21 (LTS)
    plugins.withType<JavaPlugin> {
        configure<JavaPluginExtension> {
            toolchain {
                languageVersion.set(JavaLanguageVersion.of(21))
            }
        }
    }
}
