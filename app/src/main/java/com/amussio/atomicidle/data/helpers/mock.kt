package com.amussio.atomicidle.data.helpers

import com.amussio.atomicidle.data.models.Element
import com.amussio.atomicidle.data.models.Stock

fun getMockStock(): Stock {

    val quark = Element(
        name = "Quark",
        group = "Quantum",
        requires = null,
        produces = mutableMapOf("quark" to 1.0, "electron" to 1.0),
        quantity = 0.0
    )

    val electron = Element(
        name = "Electron",
        group = "Quantum",
        requires = mutableMapOf("quark" to 3.0),
        produces = mutableMapOf("quark" to 1.0, "electron" to 1.0),
        quantity = 0.0
    )

    val proton = Element(
        name = "Proton",
        group = "Quantum",
        requires = mutableMapOf("quark" to 3.0),
        produces = mutableMapOf("quark" to 2.0, "electron" to 2.0),
        quantity = 0.0
    )

    val neutron = Element(
        name = "Neutron",
        group = "Quantum",
        requires = mutableMapOf("quark" to 3.0),
        produces = mutableMapOf("quark" to 2.0, "electron" to 2.0),
        quantity = 0.0
    )

    val hydrogen = Element(
        name = "Hydrogen",
        group = "Atomic",
        requires = mutableMapOf("proton" to 1.0, "neutron" to 1.0, "electron" to 1.0),
        produces = mutableMapOf("quark" to 4.0, "electron" to 4.0),
        quantity = 0.0
    )

    return Stock(
        elements = listOf(quark, electron, proton, neutron, hydrogen),
        timestamp = System.currentTimeMillis()
    )
}