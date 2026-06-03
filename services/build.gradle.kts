//./portfolio/services/build.gradle.kts
plugins {
    // Aplica o plugin de biblioteca Java para liberar os escopos de dependência
    id("java-library")
    
    // Alinha as versões com o ecossistema do Spring Boot gerenciado no TOML
    alias(libs.plugins.spring.dependencyManagement)
}

dependencies {
    // Camada de serviço precisa se comunicar com a camada de dados (daos)
    implementation(project(":daos"))
    implementation(project(":repositories"))
    implementation(project(":DTOs"))
    
    // Lombok (opcional, mas recomendado se usar injeção de dependência por construtor do Spring)
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
}
