package com.gildedrose

import com.gildedrose.depreciator.*

object ItemDepreciatorFactory {

    private const val AGED_BRIE = "Aged Brie"
    private const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
    private const val SULFURAS = "Sulfuras, Hand of Ragnaros"

    fun createDepreciator(item: Item): ItemDepreciator {
        return when (item.name) {
            AGED_BRIE -> AgedBrieDepreciator(item)
            BACKSTAGE_PASSES -> BackstagePassesDepreciator(item)
            SULFURAS -> SulfurasDepreciator(item)
            else -> NormalItemDepreciator(item)
        }
    }
}