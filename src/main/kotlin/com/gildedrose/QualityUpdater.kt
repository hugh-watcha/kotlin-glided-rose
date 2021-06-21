package com.gildedrose

interface QualityUpdater {

    fun updateItemQuality(item: Item) {
        updateQuality(item)
        decreaseSellIn(item)
        updateQualityWhenSellOut(item)
    }

    fun updateQuality(item: Item)

    fun decreaseSellIn(item: Item) {
        item.sellIn = item.sellIn - 1
    }

    fun updateQualityWhenSellOut(item: Item)

}