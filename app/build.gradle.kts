plugins {
    id("com.android.application") // Plugin Android Application
    id("org.jetbrains.kotlin.android") // Plugin Kotlin untuk Android
}

android {
    namespace = "com.example.roomreservation"
    compileSdk = 35 // Pastikan SDK yang digunakan sesuai dengan kebutuhan proyek

    defaultConfig {
        applicationId = "com.example.roomreservation"
        minSdk = 28 // Minimum SDK versi 28 untuk mendukung fitur modern
        targetSdk = 35 // Target SDK versi terbaru
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

}

dependencies {
    // AndroidX Libraries
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.activity:activity-ktx:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.core:core-splashscreen:1.0.1")

    //material design
    implementation("com.google.android.material:material:1.9.0")


    // Room Database
    implementation("androidx.room:room-runtime:2.5.0")

    // Retrofit untuk API
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // OkHttp untuk logging
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    // Testing Libraries
    testImplementation("junit:junit:4.13.2") // JUnit untuk unit testing
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}