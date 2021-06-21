package com.gildedrose

interface QualityUpdater {

    fun updateItemQuality(item: Item) {
        updateQuality(item)
        decreaseSellIn(item)
        if (isSellOut(item)) {
            updateQualityWhenSellOut(item)
        }
    }

    fun updateQuality(item: Item)

    fun decreaseSellIn(item: Item) {
        item.sellIn = item.sellIn - 1
    }

    fun isSellOut(item: Item): Boolean {
        return item.sellIn < 0
    }

    fun updateQualityWhenSellOut(item: Item)

}