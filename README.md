[![Release](https://jitpack.io/v/snarks/OpenRange.svg)](https://jitpack.io/#snarks/OpenRange)

# OpenRange
Open ended version of Kotlin's `ClosedRange` class

## Usage

Get a range that covers the value `512` _and lower_:
```kotlin
val range: OpenRange<Int> = lessOrEqual(512)

assertTrue(0 in range)
assertTrue(512 in range)
assertFalse(1024 in range)

assertEquals("<=512", "$range")
```

Get a range that covers values _lower than_ `512` _(exclusive)_:
```kotlin
val range: OpenRange<Int> = lessThan(512)

assertTrue(0 in range)
assertFalse(512 in range)
assertFalse(1024 in range)

assertEquals("<512", "$range")
```

Get a range that covers the value `512` _and higher_:
```kotlin
val range: OpenRange<Int> = moreOrEqual(512)

assertFalse(0 in range)
assertTrue(512 in range)
assertTrue(1024 in range)

assertEquals(">=512", "$range")
```

Get a range that covers values _higher than_ `512` _(exclusive)_:
```kotlin
val range: OpenRange<Int> = moreThan(512)

assertFalse(0 in range)
assertFalse(512 in range)
assertTrue(1024 in range)

assertEquals(">512", "$range")
```

## Adding OpenRange to your Project
You can add this project as a dependency via [JitPack](https://jitpack.io/).

```gradle
repositories {
    ...
    maven { url "https://jitpack.io" }
}
dependencies {
     compile 'io.github.snarks:OpenRange:1.0.1'
}
```
(_`com.github.snarks` will also work_)
