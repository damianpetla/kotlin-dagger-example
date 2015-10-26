kotlin-dagger-example
=====================

This project demonstrate how to setup an Android Project with Kotlin and Dagger 2.

It's based on Dagger 2 [example](https://github.com/google/dagger/tree/master/examples/android-simple)

##Known issues/limitations

Classes and interfaces that Dagger use for generating implementations must be kept in Java. If it's moved to Kotlin it won't be generated e.g. `AndroidModule`, `ApplicationComponent`

---

When `lateinit` modifier is used, your variable cannot be used in `init{}` block. It will not compile. So in that case I suggest to move code from that block into a separate function and then call that function from `init{}` block.

##More than Dagger

This sample project includes some more dependencies which are very usefull. It's like a base setup for almost every project using Kotlin.
So you will find there Anko libraries. You can uncomment Anko's DSL libraries if you need them.
There is also a set of Rx dependencies. Rx works really great with Kotlin.
At last but not least there my favourite networking dependencies from Square.

##TODO##

Use `kapt` instead `apt` and move modules and component classes to Kotlin.
