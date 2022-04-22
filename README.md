<div align="center">
 <img src = "https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/others/covercompose.png?raw=true" width = "100%"/>
</div>

<br/>

<h1 align="center">Compose for New Horizons</h1>

<div align="center">
    <a href = "https://developer.android.com/jetpack/androidx/versions/all-channel">
      <img src = "https://img.shields.io/badge/Jetpack%20Compose-1.1.1-brightgreen" />
    </a>
  <a href = "https://github.com/jeluchu/ComposeForNewHorizons">
    <img src = "https://img.shields.io/github/forks/jeluchu/ComposeForNewHorizons" />
  </a>
  <a href = "https://github.com/jeluchu/ComposeForNewHorizons/stargazers">
     <img src = "https://img.shields.io/github/stars/jeluchu/ComposeForNewHorizons" />
  </a>
  <a href = "https://github.com/jeluchu/ComposeForNewHorizons/issues">
     <img src = "https://img.shields.io/github/issues/jeluchu/ComposeForNewHorizons" />
  </a>  
  <a href = "https://twitter.com/jeluchu">
     <img src = "https://img.shields.io/twitter/url?label=follow&style=social&url=https%3A%2F%2Ftwitter.com%2Fjeluchu" />
  </a>
</div>

<br/>

<div align="center">
Jetpack Compose demo project on the topics covered within the April 2022 Afterwork talk about the future of Android, which includes various Jetpack UI elements, layouts and demo screens to see its potential
</div>
<br/>

# Jetpack Compose
Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.

## Official Documentations
- Official Google Documentation
  - [Compose Pathway](https://developer.android.com/courses/pathways/compose)
  - [Jetpack compose](https://developer.android.com/jetpack/compose)
  - [Jetpack compose Samples](https://github.com/android/compose-samples)
  - [Compose Material ](https://developer.android.com/jetpack/compose/layouts/material)

- [Compose Academy ](https://compose.academy/)

#

## How to get started
Please get the latest version of **Android Studio** [from here](https://developer.android.com/studio/) and use **JDK 11** to build this project.

#

## Kotlin DSL
This project uses Kotlin DSL for Gradle, but does not use the buildSrc dependency system because there is currently no support for controlling automatic dependency updates

#

## Powered by
This development has been done by Jéluchu, and to facilitate the development of this demonstration, the component library has also been used: [jchucomponents-compose](https://github.com/jeluchu/jchucomponents-compose)

#

## Screens for demo project
For the talk that took place on Friday, April 22, 2022, this demo project was made, which was broken down into the live talk various Jetpack Compose components, along with dependency injection, flow and other interesting Android stuff, in which we traveled into new horizons

Splash Screen             |  LazyVerticalGrid & DropDownMenu| Text, Constraints, LazyRow & more | BottomSheetScaffold Expanded
:-------------------------:|:-------------------------: | :-------------------------: | :-------------------------:
![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/newhorizons/Screenshot_20220422_210738.png?raw=true)  |  ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/newhorizons/Screenshot_20220422_210835.png?raw=true) | ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/newhorizons/Screenshot_20220422_210745.png?raw=true) | ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/newhorizons/Screenshot_20220422_210751.png?raw=true)

## 

HorizontalPager & ScrollableTab             |  Snackbars | Text, Constraints, LazyRow & more | BottomSheetScaffold Expanded
:-------------------------:|:-------------------------: | :-------------------------: | :-------------------------:
![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/newhorizons/Screenshot_20220422_210757.png?raw=true)  |  ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/newhorizons/Screenshot_20220422_210804.png?raw=true) | ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/newhorizons/Screenshot_20220422_210745.png?raw=true) | ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/newhorizons/Screenshot_20220422_210751.png?raw=true)

#

## iNook (App in Production)
To study Jetpack Compose, I started to develop last year an application called iNook, which served as a guide to information about the Nintendo game, Animal Crossing New Horizons, being an application that was as faithful as possible to the design of the game, all this encouraged me to learn this new way of developing on Android and to let everyone know the power of Compose. Here I show you some images, if you want to see live the application, you can download it from the Play Store or from the App Gallery

<a href='https://play.google.com/store/apps/details?id=com.jeluchu.inook'><img align='center' alt='Get it on Play Store' height='55' src='https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/others/playstore.png?raw=true'></a>
<a href='https://appgallery.huawei.com/app/C105452903'><img align='center' alt='Get it on App Gallery' src='https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/others/appgallery.png?raw=true' height="55"/></a>

Home             |  Passport | Designs | Villagers
:-------------------------:|:-------------------------: | :-------------------------: | :-------------------------:
![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021250.png?raw=true)  |  ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021301.png?raw=true) | ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021310.png?raw=true) | ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021322.png?raw=true)

## 

Museum             |  Fossils | Fossil Details | Critterpedia
:-------------------------:|:-------------------------: | :-------------------------: | :-------------------------:
![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021332.png?raw=true)  |  ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021341.png?raw=true) | ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021347.png?raw=true) | ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021355.png?raw=true)

## 

Bug Details             |  Music Playlist | Island Designer | Reactions
:-------------------------:|:-------------------------: | :-------------------------: | :-------------------------:
![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021420.png?raw=true)  |  ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021447.png?raw=true) | ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021502.png?raw=true) | ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021510.png?raw=true)

## 

Hairstyles             |  Artwork | Comercial Area | TV Show
:-------------------------:|:-------------------------: | :-------------------------: | :-------------------------:
![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021518.png?raw=true)  |  ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021533.png?raw=true) | ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021551.png?raw=true) | ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021558.png?raw=true)

## 

Holidaymakers             |  DYI | Nook Miles | Catalog Scanner
:-------------------------:|:-------------------------: | :-------------------------: | :-------------------------:
![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021611.png?raw=true)  |  ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021619.png?raw=true) | ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021630.png?raw=true) | ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021640.png?raw=true)

## 

Settings             |  Filters | Flowers | Mistery Islands
:-------------------------:|:-------------------------: | :-------------------------: | :-------------------------:
![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021652.png?raw=true)  |  ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021754.png?raw=true) | ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021805.png?raw=true) | ![](https://github.com/jeluchu/ComposeForNewHorizons/blob/main/screens/inook/Screenshot_20220424_021816.png?raw=true)

#

## Please Share & Star the repository to keep me motivated.
  <a href = "https://github.com/jeluchu/ComposeForNewHorizons/stargazers">
     <img src = "https://img.shields.io/github/stars/jeluchu/ComposeForNewHorizons" />
  </a>
  <a href = "https://twitter.com/jeluchu">
     <img src = "https://img.shields.io/twitter/url?label=follow&style=social&url=https%3A%2F%2Ftwitter.com%2Fjeluchu" />
  </a>

