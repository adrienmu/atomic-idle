package com.amussio.atomicidle.data.helpers

import com.amussio.atomicidle.data.models.Stock
import kotlin.math.ln
import kotlin.math.pow

fun getElementIncreasedPerSec(quantity: Int, provides: Int): Int {
    return quantity + (provides*7f.pow(ln(quantity.toFloat()) / ln(10f))).toInt()
}

fun getStockIncreasedPerSec(stock: Stock): MutableMap<String, Int> {
    val elementsCreated = mutableMapOf<String, Int>()

    stock.elements.map { e ->
        e.produces?.map { p ->
            val value = getElementIncreasedPerSec(quantity = e.quantity, provides = p.value)
            val temp = elementsCreated[p.key]?:0

            elementsCreated[p.key] = temp + value
        }
    }

    return elementsCreated
}