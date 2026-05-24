plugins{
    id("java-library")
}
dependencies{
    implementation(project(":DTOs"))
    implementation(project(":daos"))
    implementation(libs.mapstruct)
}