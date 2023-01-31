object Dependencies {

    object UI {
        const val androidAppcompat = "androidx.appcompat:appcompat:1.5.1"
        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val androidMaterial = "com.google.android.material:material:1.7.0"
        const val constraint = "androidx.constraintlayout:constraintlayout:2.1.4"
    }

    object Test {
        const val jUnit = "junit:junit:4.13.2"
        const val androidUnit = "androidx.test.ext:junit:1.1.4"
        const val espresso = "androidx.test.espresso:espresso-core:3.5.0"
    }

    object Koin {
        private const val version = "3.2.2"
        const val koinAndroid = "io.insert-koin:koin-android:$version"
    }

    object Room {
        private const val version = "2.3.0"
        const val ktx = "androidx.room:room-ktx:$version"
        const val runtime = "androidx.room:room-runtime:$version"
        const val compiler = "androidx.room:room-compiler:$version"
    }

    object Lifecycle {
        const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1"
        const val lifecycleFragment = "androidx.fragment:fragment-ktx:1.4.1"
        const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0-rc01"
    }

    object Retrofit {
        private const val retrofit_version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofit_version"
    }

    object OkHttpClient {
        const val okhttp_bom = "com.squareup.okhttp3:okhttp-bom:4.9.0"
        const val okhttp = "com.squareup.okhttp3:okhttp"
        const val logging_interceptor = "com.squareup.okhttp3:logging-interceptor"
        const val legacy_support = "androidx.legacy:legacy-support-v4:1.0.0"
    }

    object Paging {
        const val paging_v3 = "androidx.paging:paging-runtime-ktx:3.1.1"
        const val pagingCommon = "androidx.paging:paging-common-ktx:3.1.1"
    }

    object NavigationComponent {
        private const val nav_version = "2.4.2"
        const val nav_fragment = "androidx.navigation:navigation-fragment-ktx:$nav_version"
        const val nav_ui = "androidx.navigation:navigation-ui-ktx:$nav_version"

    }

    object Coroutines {
        const val coreCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1"
    }
}