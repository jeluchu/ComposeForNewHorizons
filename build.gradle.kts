buildscript {

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.1.2")
        classpath(kotlin("gradle-plugin", "1.6.10"))
        classpath("com.google.gms:google-services:4.3.10")
    }

}

allprojects{
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}