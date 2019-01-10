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

data class OpenRange<T : Comparable<T>>(val value: T, val isDownward: Boolean, val isInclusive: Boolean) {

	operator fun contains(value: T): Boolean {
		val compare = this.value.compareTo(value)

		return when {
			compare < 0 -> !isDownward
			compare > 0 -> isDownward
			else -> isInclusive
		}
	}

	override fun toString(): String {
		val pre1 = if (isDownward) '<' else '>'
		val pre2 = if (isInclusive) "=" else ""
		return pre1 + pre2 + value
	}
}

fun <T : Comparable<T>> lessOrEqual(maxInclusive: T): OpenRange<T> = OpenRange(maxInclusive, true, true)

fun <T : Comparable<T>> lessThan(maxExclusive: T): OpenRange<T> = OpenRange(maxExclusive, true, false)

fun <T : Comparable<T>> moreOrEqual(minInclusive: T): OpenRange<T> = OpenRange(minInclusive, false, true)

fun <T : Comparable<T>> moreThan(minExclusive: T): OpenRange<T> = OpenRange(minExclusive, false, false)
