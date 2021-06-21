package com.gildedrose

class AgedBrieQualityUpdater : QualityUpdater {

    override fun updateQuality(item: Item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1
        }
    }

    override fun updateQualityWhenSellOut(item: Item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1
        }
    }
}