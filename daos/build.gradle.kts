//daos
plugins{
    id("java-library")
}

dependencies{
    implementation(libs.sqlite)
    implementation(libs.spring.boot.jpa)
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
}