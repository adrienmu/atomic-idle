package com.amussio.atomicidle.data.models

data class Element(

    override val name: String,
    override val group:String,
    override val requires: MutableMap<String, Int>?,
    override val produces: MutableMap<String, Int>?,
    var quantity: Int

    ): ElementBase(name = name, group = group, requires = requires, produces = produces)

