import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    kotlin("plugin.serialization") version "1.9.0"
    id("kotlin-parcelize")
}

android {
    namespace = "yunuiy_hacker.ryzhaya_tetenka.yweather"
    compileSdk = 36

    defaultConfig {
        applicationId = "yunuiy_hacker.ryzhaya_tetenka.yweather"
        minSdk = 31
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val properties = Properties()
        val propertiesFile = rootProject.file("env.properties")
        if (propertiesFile.exists()) {
            properties.load(propertiesFile.inputStream())
        }

        buildConfigField("String", "GEOCODE_URL", "\"${properties.getProperty("GEOCODE_URL")}\"")
        buildConfigField("String", "GEOCODE_API_KEY", "\"${properties.getProperty("GEOCODE_API_KEY")}\"")
        buildConfigField("String", "OPEN_METEO_URL", "\"${properties.getProperty("OPEN_METEO_URL")}\"")
        buildConfigField("String", "AIR_QUALITY_URL", "\"${properties.getProperty("AIR_QUALITY_URL")}\"")
        buildConfigField("String", "XRAS_URL", "\"${properties.getProperty("XRAS_URL")}\"")

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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    //dagger-hilt
    implementation("com.google.dagger:hilt-android:2.57.2")
    implementation("androidx.appcompat:appcompat:1.7.1")
    annotationProcessor("com.google.dagger:hilt-compiler:2.57.2")
    kapt("com.google.dagger:hilt-android-compiler:2.57.2")
    implementation("androidx.hilt:hilt-navigation-compose:1.3.0")

    //accompanist
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.36.0")
    implementation("com.google.accompanist:accompanist-navigation-animation:0.36.0")

    //splash-api
    implementation("androidx.core:core-splashscreen:1.0.1")

    //material-icons
    implementation("androidx.compose.material:material-icons-extended:1.7.1")

    //room
    implementation("androidx.room:room-ktx:2.8.2")
    kapt("androidx.room:room-compiler:2.8.2")
    annotationProcessor("androidx.room:room-compiler:2.8.2")
    implementation("androidx.room:room-runtime:2.8.2")
    implementation("androidx.room:room-common:2.8.2")

    //gson
    implementation("com.google.code.gson:gson:2.13.2")

    //coil
    implementation("io.coil-kt:coil-compose:2.7.0")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:3.0.0")
    implementation("com.squareup.retrofit2:converter-gson:3.0.0")

    //rxjava
    implementation("com.squareup.retrofit2:adapter-rxjava2:3.0.0")

    implementation("com.google.android.gms:play-services-location:21.3.0")

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
}