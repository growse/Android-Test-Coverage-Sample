package com.example.testcoveragesample

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `Calculator can add two numbers correctly`() {
        val result = MainActivity.Adder()
            .add(3, 5)
        assertEquals(8, result)
    }
}
