package com.amussio.atomicidle.data.helpers

import org.junit.Assert.*
import org.junit.Test

class MathKtTest {

    @Test
    fun getIncreasedPerSec() {

        println("1 quark generate ${getIncreasedPerSec(1, 1)} quarks per sec")

        println("10 quarks generate ${getIncreasedPerSec(10, 1)} quarks per sec")

        println("100 quarks generate ${getIncreasedPerSec(100, 1)} quarks per sec")

        assert(true)
    }
}