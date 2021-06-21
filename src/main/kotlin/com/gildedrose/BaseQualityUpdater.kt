package com.gildedrose

interface BaseQualityUpdater {

    fun updateQuality(item: Item)

    fun decreaseSellIn(item: Item) {
        item.sellIn = item.sellIn - 1
    }

    fun updateQualityWhenSellOut(item: Item)
}