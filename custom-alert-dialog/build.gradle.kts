plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "com.example.custom_alert_dialog"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            consumerProguardFiles ("consumer-rules.pro")
        }
    }

    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }


}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(18)
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.github.ashishhgour"
            artifactId = "custom_alert_dialog"
            version = "1.0"

            pom {
                description.set("initial release")
            }
        }
    }
    repositories {
        mavenLocal()
    }
}



dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation (libs.androidx.ui)
    implementation (libs.androidx.ui.tooling.preview)
    implementation (libs.androidx.activity.compose)
    implementation (libs.androidx.compose.compiler)
    implementation (libs.androidx.material3)
    debugImplementation (libs.androidx.ui.tooling)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

