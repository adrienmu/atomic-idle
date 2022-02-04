package com.amussio.atomicidle.data.extensions

import com.amussio.atomicidle.data.models.Element
import java.text.DecimalFormat
import kotlin.math.ln
import kotlin.math.pow

fun Element.printQuantity(): String {
    if (quantity < 1000) {
        return quantity.toInt().toString()
    } else {
        val numFormat = DecimalFormat("0.###E0")
        return numFormat.format(quantity).toString()
    }
}
fun Element.printProduction() : String {
    var provides = 1
    val value = (quantity + (provides*7f.pow(ln(quantity.toFloat())/ln(10f))).toDouble())
    if (value < 1000) {
        return value.toInt().toString()
    } else {
        val numFormat = DecimalFormat("0.###E0")
        return numFormat.format(value).toString()
    }

}
