plugins {
    // Plugin Android Application
    alias(libs.plugins.android.application)

    // Plugin Kotlin Android
    alias(libs.plugins.kotlin.android)
}

android {
    // Namespace unik untuk aplikasi
    namespace = "com.app.foodorder.v1"

    // Versi SDK yang digunakan untuk compile
    compileSdk = 36

    defaultConfig {
        applicationId = "com.app.foodorder.v1"
        minSdk = 24
        targetSdk = 36

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        // Mengaktifkan ViewBinding
        viewBinding = true
    }

    buildTypes {
        release {
            // Mengatur minifikasi (R8 / Proguard)
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        // Versi Java yang digunakan
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        // Versi JVM untuk Kotlin
        jvmTarget = "17"
    }
}

dependencies {
    // Core Android
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    // Material Design
    implementation(libs.material)

    // Activity
    implementation(libs.androidx.activity)

    // ConstraintLayout
    implementation(libs.androidx.constraintlayout)

    // Splash Screen API
    implementation("androidx.core:core-splashscreen:1.0.1")

    // Unit Testing
    testImplementation(libs.junit)

    // Android Testing
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}