plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.androidtestsample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.androidtestsample"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    testImplementation("com.google.truth:truth:1.4.2")
    androidTestImplementation("com.google.truth:truth:1.4.2")

    implementation(libs.roomRuntime)
    implementation(libs.roomKtx)
    ksp(libs.roomCompiler)

    // Timber

    // Local Unit Tests
//    implementation ("androidx.test:core:1.2.0")
//    testImplementation ("org.hamcrest:hamcrest-all:1.3")
//    testImplementation ("androidx.arch.core:core-testing:2.1.0")
//    testImplementation ("org.robolectric:robolectric:4.3.1")
//    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.2.1")
//    testImplementation ("com.google.truth:truth:1.0.1")
//    testImplementation ("org.mockito:mockito-core:2.21.0")
//
//    // Instrumented Unit Tests
//    androidTestImplementation ("com.linkedin.dexmaker:dexmaker-mockito:2.12.1")
//    androidTestImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.2.1")
//    androidTestImplementation ("androidx.arch.core:core-testing:2.1.0")
//    androidTestImplementation ("com.google.truth:truth:1.0.1")
//    androidTestImplementation ("androidx.test.ext:junit:1.1.1")
//    androidTestImplementation ("androidx.test.espresso:espresso-core:3.2.0")
//    androidTestImplementation ("org.mockito:mockito-core:2.21.0")

}