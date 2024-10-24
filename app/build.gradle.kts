import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.baselineprofile)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.tamago.nutriencehelper"
    compileSdk = libs.versions.androidSdk.compile.get().toInt()

    defaultConfig {
        applicationId = "com.tamago.nutriencehelper"
        minSdk = libs.versions.androidSdk.min.get().toInt()
        targetSdk = libs.versions.androidSdk.target.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        val localProperties = gradleLocalProperties(rootDir, providers)
        buildConfigField("String", "RECIPE_API_KEY", "\"${localProperties.getProperty("RECIPE_API_KEY")}\"")
        buildConfigField("String", "RECIPE_API_BASE_URL", "\"${localProperties.getProperty("RECIPE_API_BASE_URL")}\"")

        resourceConfigurations += setOf("ru", "en")
        ndk {
            //noinspection ChromeOsAbiSupport
            abiFilters += setOf("armeabi-v7a", "arm64-v8a")
        }
    }

    signingConfigs {
        create("release") {
            storeFile = File(rootDir, "nutriencehelper.keystore")
            keyPassword = "80|6/Ho9-oZg"
            keyAlias = "i.khoroshun"
            storePassword = "80|6/Ho9-oZg"
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs["release"]
            isMinifyEnabled = true
            proguardFile(getDefaultProguardFile("proguard-android-optimize.txt"),)
            proguardFiles(
                file("proguard/")
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {

        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "/okhttp3/internal/publicsuffix/NOTICE"
            excludes += "/kotlin/**"
            excludes += "/META-INF/androidx.*.version"
            excludes += "/META-INF/com.google.*.version"
            excludes += "/META-INF/kotlinx.*.version"
            excludes += "/kotlin-tooling-metadata.json"
            excludes += "/DebugProbesKt.bin"
            excludes += "/META-INF/com/android/build/gradle/app-metadata.properties"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.jetbrains.kotlinx.serialization.json)
    implementation(libs.retrofit2.kotlinx.serialization.converter)
    implementation(libs.retrofit.adapters.result)

    implementation(libs.dagger.hilt.android)
    implementation(libs.androidx.profileinstaller)
    implementation(libs.firebase.auth.ktx)
    implementation(libs.firebase.firestore.ktx)
    implementation(libs.firebase.storage.ktx)
    implementation(libs.firebase.auth)
    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.googleid)
    ksp(libs.dagger.hilt.compiler)

    implementation(projects.core.data)
    implementation(projects.core.spoonacularapi)
    implementation(projects.features.recipesMain.domain)
    implementation(projects.core.database)
    implementation(projects.core.common)
    implementation(projects.core.uikit)
    implementation(projects.core.firebase)
    implementation(projects.features.recipesMain.ui)

    baselineProfile(projects.baselineprofile)
}
