package com.amussio.atomicidle.data.models

open class ElementBase (
    open val name: String,
    open val group: String,
    open val requires: MutableMap<String, Int>?,
    open val produces: MutableMap<String, Int>?) {
}