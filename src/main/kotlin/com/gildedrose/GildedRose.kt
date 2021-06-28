package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.forEach { item ->
            ItemDepreciationProcessorFactory.createDepreciationProcessor(item).processDepreciationCycle()
        }
    }
}

