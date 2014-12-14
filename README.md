kotlin-dagger-example
=====================

This project demonstrate how to setup an Android Project with Kotlin and Dagger 2.

It's based on Dagger 2 [example](https://github.com/google/dagger/tree/master/examples/android-simple)

##Known issues/limitations

1. Kotlin compiler does not allow `$` sign in class names. So you can't use Dagger's generated classes that use `$`. There is an issue reported [KT-6444](https://youtrack.jetbrains.com/issue/KT-6444)
2. Classes and interfaces that Dagger use for generating implementations must be kept in Java. If it's moved to Kotlin it won't be generated e.g. `AndroidModule`, `ApplicationComponent`
3. Dagger's field injection is not working within Kotlin files.

This will not work:
```kotlin
Inject var locationManager: LocationManager? = null
```
Fortunately, setter injection works for Kotlin and syntax is simple:
```kotlin
var locationManager: LocationManager? = null
[Inject] set
