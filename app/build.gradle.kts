plugins {
    id(Config.Plugins.androidApplication)
    id(Config.Plugins.jetbrainsKotlin)
    kotlin("kapt")
}

android {
    namespace = "com.uli.dictionary"
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    //UI
    implementation(Dependencies.UI.coreKtx)
    implementation(Dependencies.UI.androidAppcompat)
    implementation(Dependencies.UI.androidMaterial)
    implementation(Dependencies.UI.constraint)

    //Test
    testImplementation(Dependencies.Test.jUnit)
    androidTestImplementation(Dependencies.Test.androidUnit)
    androidTestImplementation(Dependencies.Test.espresso)

    //Koin
    implementation(Dependencies.Koin.koinAndroid)

    //Navigation
    implementation(Dependencies.NavigationComponent.nav_ui)
    implementation(Dependencies.NavigationComponent.nav_fragment)

    implementation(project(":features:main"))
    implementation(project(":features:main:data"))
}