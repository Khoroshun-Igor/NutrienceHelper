import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
}

kotlin {
    explicitApi = ExplicitApiMode.Strict
}

android {
    namespace = "com.tamago.mylibrary"
    compileSdk = libs.versions.androidSdk.compile.get().toInt()

    defaultConfig {
        minSdk = libs.versions.androidSdk.min.get().toInt()
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
    implementation(libs.androidx.core.ktx)
    implementation(libs.kotlinx.coroutines.core)
}
