package com.amussio.atomicidle.data.models

data class Element(
    
    override val name: String,
    override val group:String,
    override val requires: List<Pair<String, Int>>,
    override val produces: List<Pair<String, Int>>,
    var quantity: Int

    ): ElementBase(name = name, group = group, requires = requires, produces = produces)

