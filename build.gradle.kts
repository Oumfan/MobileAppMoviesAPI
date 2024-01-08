plugins {
    id("com.android.application")
}

android {
    namespace = "ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api"
    compileSdk = 34

    defaultConfig {
        applicationId = "ma.fstm.oumaima.last_movie_app_mvvm_retrofit_api"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //retrofit 2
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    //json convertor with retrofit2:
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("androidx.fragment:fragment:1.6.2")
    //MVVM dependency:
    implementation("android.arch.lifecycle:extensions:1.1.1")


    // ViewModel
    //implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // ViewModel utilities for Compose
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.1.0")

    //glide:
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    //material design :
    implementation ("com.google.android.material:material:1.3.0-alpha03")
}