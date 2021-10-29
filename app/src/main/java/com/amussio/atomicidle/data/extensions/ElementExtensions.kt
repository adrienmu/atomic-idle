package com.amussio.atomicidle.data.extensions

import com.amussio.atomicidle.data.models.Element
import kotlin.math.ln
import kotlin.math.pow

fun Element.add() = {
    //todo remplacer provide
    var provides = 1
    quantity = quantity + (provides*7f.pow(ln(quantity.toFloat())/ln(10f))).toInt()
}