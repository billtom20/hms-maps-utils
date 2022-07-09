# hms-maps-utils (AndroidX)

>This project is derived from [Maps SDK for Android Utility Library](https://github.com/googlemaps/android-maps-utils), and relies on Huawei HMS Core [Map Kit](https://developer.huawei.com/consumer/en/hms/huawei-MapKit) and [Site Kit](https://developer.huawei.com/consumer/en/hms/huawei-sitekit/).

## Usage of library module
1. Open Gradle, click library->Tasks->build->assemble.
2. After Run, find `hms-maps-utils-2.4.0-yyyyMMdd.aar` file in `library/build/outputs/aar/` path.
3. Copy `hms-maps-utils-2.4.0-yyyyMMdd.aar` file to your own `app/libs/` path.
4. Add codes below in project build.gradle file.
```java
allprojects {
	repositories {
		...
		flatDir {
			dirs 'libs'
		}
	}
}
```
5. Add codes below in app build.gradle file.
```java
dependencies {
    implementation(name: 'hms-maps-utils-2.4.0-yyyyMMdd', ext: 'aar')
    ...
}
```

## Usage of demo module
1. [Configuring App Information in AppGallery Connect](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/android-sdk-config-agc-0000001061560289)
2. [Adding the AppGallery Connect Configuration File of Your App](https://developer.huawei.com/consumer/en/doc/development/HMSCore-Guides/android-sdk-integrating-sdk-0000001061671869#EN-US_TOPIC_0000001061671869__section4256162815361)
3. Replace your own applicationId in `build.gradle(Module:hms-maps-utils.demo)`, it should be the same as the **package_name** in `agconnect-services.json` file.
4. Replace your own **signingConfigs** in `build.gradle(Module:hms-maps-utils.demo)`, it should be the keystore file used to generate the **SHA-256 value** configured on AppGallery Connect.
5. Replace your own **API_KEY** in `HeatmapsSiteDemoActivity.java`, it should be encoded by using `URLEncoder.encode("Your apiKey", "UTF-8")` method.