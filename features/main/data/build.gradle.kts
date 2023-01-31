plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "com.uli.data"
    compileSdk = 32

    defaultConfig {
        minSdk = 26
        targetSdk = 32

        buildConfigField("String", "BASE_URL", "\"https://karyshkyr.geekstudio.kg/api/v1/\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    //Retrofit
    implementation(Dependencies.Retrofit.retrofit)

    //OkHttp
    implementation(Dependencies.OkHttpClient.legacy_support)
    implementation(Dependencies.OkHttpClient.okhttp)
    implementation(Dependencies.OkHttpClient.logging_interceptor)
    implementation(Dependencies.OkHttpClient.okhttp_bom)

    //Paging
    implementation(Dependencies.Paging.paging_v3)

    //Coroutines
    implementation(Dependencies.Coroutines.coreCoroutines)

    //Koin
    implementation(Dependencies.Koin.koinAndroid)

    //Room
    kapt(Dependencies.Room.compiler)
    implementation(Dependencies.Room.runtime)
    implementation(Dependencies.Room.ktx)

    api(project(":features:main:domain"))
    implementation(project(":core"))
}