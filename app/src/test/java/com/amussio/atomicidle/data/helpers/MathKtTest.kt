package com.amussio.atomicidle.data.helpers

import org.junit.Assert.*
import org.junit.Test

class MathKtTest {

    @Test
    fun getIncreasedPerSec() {

        println("1 quark generate ${getElementIncreasedPerSec(1, 1)} quarks per sec")

        println("10 quarks generate ${getElementIncreasedPerSec(10, 1)} quarks per sec")

        println("100 quarks generate ${getElementIncreasedPerSec(100, 1)} quarks per sec")

        assert(true)
    }

    @Test
    fun oneSecondSimulation() {
        val stock = getMockStock()
        val elementsCreated = getStockIncreasedPerSec(stock = stock)
        println("les nouvelles valeurs : $elementsCreated")
        assert(true)
    }
}