package com.gildedrose

class GildedRose(var items: Array<Item>) {

    private val itemDeprecationProcessors = items.map {
        ItemDepreciationProcessorFactory.createDepreciationProcessor(it)
    }

    fun updateQuality() {
        itemDeprecationProcessors.forEach {
            it.processDepreciationCycle()
        }
    }
}

