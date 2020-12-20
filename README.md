# 3rd-maps-utils (AndroidX)

>This project is derived from [Maps SDK for Android Utility Library](https://github.com/googlemaps/android-maps-utils), and relies on Huawei HMS Core [Map Kit](https://developer.huawei.com/consumer/en/hms/huawei-MapKit) and [Site Kit](https://developer.huawei.com/consumer/en/hms/huawei-sitekit/).

## Usage
1. Open Gradle, click library->Tasks->build->assemble.
2. After Run, find 3rd-maps-utils-2.2.0-yyyyMMdd.aar file in library/build/outputs/aar/ path.
3. Copy 3rd-maps-utils-2.2.0-yyyyMMdd.aar file to your own app/libs/ path.
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
    implementation(name: '3rd-maps-utils-2.2.0-yyyyMMdd', ext: 'aar')
    ...
}
```
