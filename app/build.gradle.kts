plugins {
    id("com.android.application")
    kotlin("android")
}
android {
    compileSdk = 34
    namespace = "com.example.testcoveragesample"
    defaultConfig {
        applicationId = "com.example.testcoveragesample"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments.putAll(
            mapOf(
                "clearPackageData" to "true",
                "useTestStorageService" to "true",
                "disableAnalytics" to "true",
            ),
        )
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            proguardFiles.addAll(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    file("proguard-rules.pro"),
                ),
            )
        }
        named("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles.addAll(
                listOf(
                    getDefaultProguardFile("proguard-android.txt"),
                    file("proguard-rules.pro"),
                ),
            )
            enableAndroidTestCoverage = true
            enableUnitTestCoverage = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    testOptions {
        execution = "ANDROIDX_TEST_ORCHESTRATOR"
        animationsDisabled = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.jakewharton.timber:timber:5.0.1")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test:rules:1.6.0")
    debugImplementation("androidx.test:core-ktx:1.6.0")
    androidTestImplementation("androidx.test:core-ktx:1.6.0")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.0")

    androidTestUtil("androidx.test:orchestrator:1.5.0")
    androidTestUtil("androidx.test.services:test-services:1.5.0")
}
