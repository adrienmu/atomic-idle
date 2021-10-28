package com.amussio.atomicidle.data.models

data class Element(
    val name: String,
    val group: String,
    val requires: List<Require>,
    val produces: List<Produce>)