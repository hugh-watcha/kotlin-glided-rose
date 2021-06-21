package com.gildedrose

class AgedBrieQualityUpdater : QualityUpdater {

    override fun updateQuality(item: Item) {
        item.quality = 50.coerceAtMost(item.quality + 1)
    }

    override fun updateQualityWhenSellOut(item: Item) {
        item.quality = 50.coerceAtMost(item.quality + 1)
    }
}