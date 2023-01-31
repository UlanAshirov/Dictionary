plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    api((project(":common")))
    //Coroutines
    implementation(Dependencies.Coroutines.coreCoroutines)

    //Paging
    implementation(Dependencies.Paging.pagingCommon)

    //Koin
    implementation("io.insert-koin:koin-core:3.2.2")
}