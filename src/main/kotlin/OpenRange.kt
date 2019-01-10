/*
 * Copyright 2019 James Cruz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.snarks.openrange

/**
 * Represents an open-ended range of values
 *
 * [isDownward] determines whether this range opens downwards or upwards. [isInclusive] determines if [value] is
 * considered to belong to this range.
 *
 * ### Examples
 *
 * _Downward Inclusive:_
 * ```kotlin
 * val range = lessOrEqual(512)
 *
 * assertTrue(0 in range)
 * assertTrue(512 in range)
 * assertFalse(1024 in range)
 *
 * assertEquals("<=512", "$range")
 * ```
 *
 * _Downward Exclusive:_
 * ```kotlin
 * val range = lessThan(512)
 *
 * assertTrue(0 in range)
 * assertFalse(512 in range)
 * assertFalse(1024 in range)
 *
 * assertEquals("<512", "$range")
 * ```
 *
 * _Upward Inclusive:_
 * ```kotlin
 * val range = moreOrEqual(512)
 *
 * assertFalse(0 in range)
 * assertTrue(512 in range)
 * assertTrue(1024 in range)
 *
 * assertEquals(">=512", "$range")
 * ```
 *
 * _Upward Exclusive:_
 * ```kotlin
 * val range = moreThan(512)
 *
 * assertFalse(0 in range)
 * assertFalse(512 in range)
 * assertTrue(1024 in range)
 *
 * assertEquals(">512", "$range")
 * ```
 *
 * @see lessOrEqual
 * @see lessThan
 * @see moreOrEqual
 * @see moreThan
 */
data class OpenRange<T : Comparable<T>>(val value: T, val isDownward: Boolean, val isInclusive: Boolean) {

	/**
	 * Checks whether the specified [value] belongs to the range
	 */
	operator fun contains(value: T): Boolean {
		val compare = this.value.compareTo(value)

		return when {
			compare < 0 -> !isDownward
			compare > 0 -> isDownward
			else -> isInclusive
		}
	}

	/**
	 * Returns the string representation of this range
	 *
	 * Examples:
	 * - `lessOrEqual(512)` = `<=512`
	 * - `lessThan(512)` = `<512`
	 * - `moreOrEqual(512)` = `>=512`
	 * - `moreThan(512)` = `>512`
	 */
	override fun toString(): String {
		val pre1 = if (isDownward) '<' else '>'
		val pre2 = if (isInclusive) "=" else ""
		return pre1 + pre2 + value
	}
}

/** Returns a range that covers values from [maxInclusive] and lower (downward inclusive) */
fun <T : Comparable<T>> lessOrEqual(maxInclusive: T): OpenRange<T> = OpenRange(maxInclusive, true, true)

/** Returns a range that covers values lower than [maxExclusive] (downward exclusive) */
fun <T : Comparable<T>> lessThan(maxExclusive: T): OpenRange<T> = OpenRange(maxExclusive, true, false)

/** Returns a range that covers values from [minInclusive] and higher (upward inclusive) */
fun <T : Comparable<T>> moreOrEqual(minInclusive: T): OpenRange<T> = OpenRange(minInclusive, false, true)

/** Returns a range that covers values higher than [minExclusive] (upward exclusive) */
fun <T : Comparable<T>> moreThan(minExclusive: T): OpenRange<T> = OpenRange(minExclusive, false, false)
