package com.amussio.atomicidle.data.helpers

import kotlin.math.ln
import kotlin.math.pow

fun getIncreasedPerSec(quantity: Int, provides: Int): Int {
    return quantity + (provides*7f.pow(ln(quantity.toFloat()) / ln(10f))).toInt()
}