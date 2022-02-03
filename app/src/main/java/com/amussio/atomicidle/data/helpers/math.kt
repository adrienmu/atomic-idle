package com.amussio.atomicidle.data.helpers

import com.amussio.atomicidle.data.models.Stock
import kotlin.math.ln
import kotlin.math.pow

fun getElementIncreasedPerSec(quantity: Double, provides: Double): Double {
    return quantity + (provides*7f.pow(ln(quantity.toFloat()) / ln(10f)))
}

fun getStockIncreasedPerSec(stock: Stock?): MutableMap<String, Double> {
    val elementsCreated = mutableMapOf<String, Double>()

    stock?.elements?.map { e ->
        e.produces?.map { p ->
            val value = getElementIncreasedPerSec(quantity = e.quantity, provides = p.value)
            val temp:Double = elementsCreated[p.key]?:0.0
            elementsCreated[p.key] = temp + value
        }
    }

    return elementsCreated
}