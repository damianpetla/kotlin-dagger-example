kotlin-dagger-example
=====================

This project demonstrate how to setup an Android Project with Kotlin and Dagger 2.

It's based on Dagger 2 [example](https://github.com/google/dagger/tree/master/examples/android-simple)

##Known issues/limitations

1. Kotlin compiler does not allow `$` sign in class names. So you can't use Dagger's generated classes that use `$`. There is an issue reported [KT-6444](https://youtrack.jetbrains.com/issue/KT-6444). Dagger 2 is also going to remove `$` from their naming conventions, see [issue](https://github.com/google/dagger/issues/58)
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
```

**How to use `@Named` property qualifier**

If you are going to use multiple `@Provides` for the same type you would expect injecting property like this:
```kotlin
var typeface: Typeface? = null
[Inject Named("bold")] set
```
Unfortunatelly, it won't work. It will not even compile. 

Proper way is
```kotlin
var typeface: Typeface? = null
[Inject] set([Named("bold")] value) {
    $typeface = value
}
```

Be careful where you call Dagger's `inject(this)` method. If you do it from the class constructor it won't work becasue after injection, property is initialised with `null` value. If you do it in `Activity` or `Fragment`, `onCreate()` will be just fine. If not, you have to create your own function and call it explicitly wherever you initialise your class.
For some more datails see issue [KT-6740](https://youtrack.jetbrains.com/issue/KT-6740)
