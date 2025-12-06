plugins {
    alias(libs.plugins.agp)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    id("kotlin-parcelize")
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.androidx.safeargs)
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    namespace = "com.play_pause.musicplayer"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.play_pause.musicplayer"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            isZipAlignEnabled = true
            isShrinkResources = false
            versionNameSuffix = ".debug"

            // Disable automatic build ID generation
            ext["alwaysUpdateBuildId"] = false

            // Disable PNG crunching
            isCrunchPngs = false

            externalNativeBuild {
                cmake {
                    cppFlags += "-DDEBUG"
                    abiFilters += listOf("armeabi-v7a", "arm64-v8a", "x86", "x86_64")
                }
            }
        }

        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            isZipAlignEnabled = true
            isShrinkResources = true

            externalNativeBuild {
                cmake {
                    cppFlags += "-DRELEASE"
                    abiFilters += listOf("armeabi-v7a", "arm64-v8a", "x86", "x86_64")
                }
            }
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
        buildConfig = true
        viewBinding = true
    }
}

dependencies {

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)

    // Firebase BoM
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.analytics)

    // Google/JetPack
    //https://developer.android.com/jetpack/androidx/versions
    implementation(libs.core.ktx)
    implementation(libs.core.splashscreen)
    implementation(libs.appcompat)
    implementation(libs.fragment.ktx)

    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.common.java8)

    implementation(libs.navigation.common.ktx)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.runtime.ktx)
    implementation(libs.navigation.ui.ktx)

    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    implementation(libs.androidx.media)
    implementation(libs.androidx.cardview)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.swiperefreshlayout)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.preference.ktx)
    implementation(libs.androidx.palette.ktx)
    implementation(libs.androidx.viewpager)
    implementation(libs.material.components)

    implementation(libs.balloon)
    implementation(libs.fastscroll)
    implementation(libs.fadingedgelayout)
    implementation(libs.advrecyclerview) {
        isTransitive = true
    }
    implementation(libs.customactivityoncrash)
    implementation(libs.versioncompare)

    implementation(libs.markdown.core)
    implementation(libs.markdown.html)
    implementation(libs.markdown.glide)
    implementation(libs.markdown.linkify)

    implementation(libs.bundles.ktor)

    implementation(libs.koin.core)
    implementation(libs.koin.android)

    implementation(libs.glide)
    implementation(libs.glide.okhttp3)
    ksp(libs.glide.ksp)

    implementation(libs.jaudiotagger)
}