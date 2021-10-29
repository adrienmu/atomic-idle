package com.amussio.atomicidle.data.models

open class ElementBase (
    open val name: String,
    open val group: String,
    open val requires: List<Pair<String, Int>>,
    open val produces: List<Pair<String, Int>>) {
}