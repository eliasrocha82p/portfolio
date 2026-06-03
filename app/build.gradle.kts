//./portfolio/app/build.gradle.kts
plugins {
    // Aplica o plugin de aplicação do Gradle (ativa o bloco application e a propriedade mainClass)
    id("application")
    
    // Aplica os plugins do Spring Boot mapeados no seu catálogo global (libs.versions.toml)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependencyManagement)
}

dependencies {
    // Conecta a camada de entrada (app) com a camada de negócio (services)
    implementation(project(":services"))
    implementation(project(":DTOs"))
    
    // Web starter para subir o Tomcat embutido e escutar as requisições HTTP
    implementation(libs.spring.boot.web)
    
    // Lombok e MapStruct (se for usar no módulo app também)
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.platform)
    implementation(libs.hibernate)
}

// Configura o plugin 'application' para saber onde está a classe com o método static void main
application {
    mainClass.set("com.rocha82.App") // Usando o formato .set() que é o padrão correto do Gradle Moderno
}

// Configura a tarefa de testes para usar o JUnit Jupiter (JUnit 5) do seu catálogo
tasks.test {
    useJUnitPlatform()
}

   