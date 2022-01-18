package com.amussio.atomicidle.data.extensions

import com.amussio.atomicidle.data.models.Element
import kotlin.math.ln
import kotlin.math.pow

fun Element.add() = {
    //todo remplacer provide
    var provides = 1
    quantity = quantity + (provides*7f.pow(ln(quantity.toFloat())/ln(10f))).toInt()
}

fun Element.printProduction() : String {
    var provides = 1
    return (quantity + (provides*7f.pow(ln(quantity.toFloat())/ln(10f))).toInt()).toString()
}
