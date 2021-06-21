package com.gildedrose

open class NormalQualityUpdater : QualityUpdater {

    override fun updateQuality(item: Item) {
        item.quality = 0.coerceAtLeast(item.quality - 1)
    }

    override fun updateQualityWhenSellOut(item: Item) {
        item.quality = 0.coerceAtLeast(item.quality - 1)
    }
}