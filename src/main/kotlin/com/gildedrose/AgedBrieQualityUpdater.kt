package com.gildedrose

import com.gildedrose.QualityUpdater.Companion.MAX_QUALITY

class AgedBrieQualityUpdater : QualityUpdater {

    override fun updateQuality(item: Item) {
        increaseQuality(item)
    }

    override fun updateQualityWhenSellOut(item: Item) {
        increaseQuality(item)
    }

    private fun increaseQuality(item: Item) {
        item.quality = (item.quality + 1).coerceAtMost(MAX_QUALITY)
    }

}