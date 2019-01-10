# OpenRange
Open ended version of Kotlin's `ClosedRange` class

## Usage

Get a range that covers the value `512` and lower:
```kotlin
val range: OpenRange<Int> lessOrEqual(512)

assertTrue(0 in range)
assertTrue(512 in range)
assertFalse(1024 in range)

assertEquals("<=512", "$range")
```

Get a range that covers values _lower than_ `512`, (but excluding `512` itself):
```kotlin
val range: OpenRange<Int> lessThan(512)

assertTrue(0 in range)
assertFalse(512 in range)
assertFalse(1024 in range)

assertEquals("<512", "$range")
```

Get a range that covers the value `512` _and higher_:
```kotlin
val range: OpenRange<Int> moreOrEqual(512)

assertFalse(0 in range)
assertTrue(512 in range)
assertTrue(1024 in range)

assertEquals(">=512", "$range")
```

Get a range that covers values _higher than_ `512`, (but excluding `512` itself):
```kotlin
val range: OpenRange<Int> moreThan(512)

assertFalse(0 in range)
assertFalse(512 in range)
assertTrue(1024 in range)

assertEquals(">512", "$range")
```
