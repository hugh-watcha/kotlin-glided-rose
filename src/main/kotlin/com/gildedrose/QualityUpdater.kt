package com.gildedrose

interface QualityUpdater {

    fun updateItemQuality(item: Item) {
        updateQuality(item)
        decreaseSellIn(item)
        if (isExpired(item)) {
            updateQualityAfterExpired(item)
        }
    }

    fun updateQuality(item: Item)

    fun decreaseSellIn(item: Item) = item.decreaseSellIn()

    fun isExpired(item: Item): Boolean = item.isExpired()

    fun updateQualityAfterExpired(item: Item)

}