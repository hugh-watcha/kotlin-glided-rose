package com.gildedrose

import com.gildedrose.depreciator.*

object ItemDepreciationProcessorFactory {

    private const val AGED_BRIE = "Aged Brie"
    private const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
    private const val SULFURAS = "Sulfuras, Hand of Ragnaros"
    private const val CONJURED = "Conjured"

    fun createDepreciationProcessor(item: Item): ItemDepreciationProcessor {
        return when (item.name) {
            AGED_BRIE -> AgedBrieDepreciationProcessor(item)
            BACKSTAGE_PASSES -> BackstagePassesDepreciationProcessor(item)
            SULFURAS -> SulfurasDepreciationProcessor(item)
            CONJURED -> ConjuredDepreciationProcessor(item)
            else -> NormalItemDepreciationProcessor(item)
        }
    }
}