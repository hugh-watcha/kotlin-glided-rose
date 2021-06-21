package com.gildedrose

import com.gildedrose.QualityUpdater.Companion.MIN_QUALITY

open class NormalQualityUpdater : QualityUpdater {

    override fun updateQuality(item: Item) {
        decreaseQuality(item)
    }

    override fun updateQualityWhenSellOut(item: Item) {
        decreaseQuality(item)
    }

    private fun decreaseQuality(item: Item) {
        item.quality = getDecreaseQuality(item)
    }

    private fun getDecreaseQuality(item: Item) = (item.quality - 1).coerceAtLeast(MIN_QUALITY)

}