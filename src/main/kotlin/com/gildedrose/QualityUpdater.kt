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

    fun decreaseSellIn(item: Item) = item.decreaseSellIn()

    fun isSellOut(item: Item): Boolean = item.isSellOut()

    fun updateQualityWhenSellOut(item: Item)

    companion object {
        const val MIN_QUALITY = 0
        const val MAX_QUALITY = 50
    }
}