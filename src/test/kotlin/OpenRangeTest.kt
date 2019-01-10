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

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class OpenRangeTest {

	@Test
	fun `test lessOrEqual`() {
		val range = lessOrEqual(512)

		assertTrue(0 in range)
		assertTrue(512 in range)
		assertFalse(1024 in range)

		assertEquals("<=512", "$range")
	}

	@Test
	fun `test lessThan`() {
		val range = lessThan(512)

		assertTrue(0 in range)
		assertFalse(512 in range)
		assertFalse(1024 in range)

		assertEquals("<512", "$range")
	}

	@Test
	fun `test moreOrEqual`() {
		val range = moreOrEqual(512)

		assertFalse(0 in range)
		assertTrue(512 in range)
		assertTrue(1024 in range)

		assertEquals(">=512", "$range")
	}

	@Test
	fun `test moreThan`() {
		val range = moreThan(512)

		assertFalse(0 in range)
		assertFalse(512 in range)
		assertTrue(1024 in range)

		assertEquals(">512", "$range")
	}
}
