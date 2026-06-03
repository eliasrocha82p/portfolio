//daos
plugins {
    // Aplica o plugin nativo de biblioteca Java (ativa as funções api, implementation e runtimeOnly)
    id("java-library")
    
    // Aplica o gerenciador de dependências do Spring para alinhar as versões do seu catálogo TOML
    alias(libs.plugins.spring.dependencyManagement)
}

dependencies {
    // Conecta o DAO ao módulo de DTOs
    implementation(project(":DTOs"))
    
    // 'api' exporta o JPA para que quem herdar o 'daos' também enxergue as anotações do Hibernate
    api(libs.spring.boot.jpa)
    
    // O driver do SQLite só entra em tempo de execução
    runtimeOnly(libs.sqlite)

    // Lombok para não precisar escrever getters/setters na mão
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    
    // MapStruct caso vá mapear entidades aqui dentro
    implementation(libs.mapstruct)
    annotationProcessor(libs.mapstruct.processor)
}
