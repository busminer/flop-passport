plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "dev.alexkosa.flooppassport"
    compileSdk = 36

    defaultConfig {
        applicationId = "dev.alexkosa.flooppassport"
        minSdk = 31
        targetSdk = 36
        versionCode = 1
        versionName = "0.1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug { applicationIdSuffix = ".dev" }
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures { compose = true }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin { jvmToolchain(17) }
    packaging { resources { excludes += "/META-INF/{AL2.0,LGPL2.1}" } }
}

dependencies {
    implementation("androidx.core:core-ktx:1.16.0")
    implementation("androidx.activity:activity-compose:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.9.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.2")
    implementation(platform("androidx.compose:compose-bom:2025.08.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.navigation:navigation-compose:2.9.3")
    implementation("androidx.biometric:biometric:1.1.0")
    // Pinned above what biometric:1.1.0 drags in. That old fragment still runs
    // FragmentActivity.checkForValidRequestCode, which rejects the request codes the
    // modern ActivityResultRegistry generates - so the first file picker launched from a
    // FragmentActivity crashed with "Can only use lower 16 bits for requestCode".
    implementation("androidx.fragment:fragment-ktx:1.8.9")
    implementation("androidx.datastore:datastore-preferences:1.1.7")

    // Ed25519, Argon2id, base58/base64 primitives
    implementation("org.bouncycastle:bcprov-jdk18on:1.81")


    // Solana Mobile Wallet Adapter (dApp side)
    // The -ktx artifact declares the same namespace as the base clientlib it depends on,
    // which AGP rejects outright. The base library is the whole API anyway; the coroutine
    // wrapper we need is a few lines in wallet/MobileWalletAdapter.kt.
    implementation("com.solanamobile:mobile-wallet-adapter-clientlib:2.0.8")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2")

    testImplementation("junit:junit:4.13.2")
    testImplementation("org.bouncycastle:bcprov-jdk18on:1.81")
    androidTestImplementation("androidx.test:runner:1.7.0")
    androidTestImplementation("androidx.test.ext:junit:1.3.0")
    debugImplementation("androidx.compose.ui:ui-tooling")
}
