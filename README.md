kotlin-dagger-example
=====================

This project demonstrate how to setup an Android Project with Kotlin and Dagger 2.

It's based on Dagger 2 [example](https://github.com/google/dagger/tree/master/examples/android-simple)

##Known issues/limitations

1. Classes and interfaces that Dagger use for generating implementations must be kept in Java. If it's moved to Kotlin it won't be generated e.g. `AndroidModule`, `ApplicationComponent`
2. Dagger's field injection is not working within Kotlin files.

This will not work:
```kotlin
@Inject var locationManager: LocationManager? = null
```
Fortunately, setter injection works for Kotlin and syntax is simple:
```kotlin
lateinit var locationManager: LocationManager
    @Inject set
```

**How to use `@Named` property qualifier**

If you are going to use multiple `@Provides` for the same type you would expect injecting property like this:
```kotlin
var typeface: Typeface? = null
@Inject @Named("bold") set
```
Unfortunatelly, it won't work. It will not even compile. 

Proper way is
```kotlin
var typeface: Typeface? = null
@Inject set(@Named("bold") value) {
    field = value
}
```
