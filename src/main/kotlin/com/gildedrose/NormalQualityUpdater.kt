package com.gildedrose

open class NormalQualityUpdater : QualityUpdater {

    override fun updateQuality(item: Item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1
        }
    }

    override fun updateQualityWhenSellOut(item: Item) {
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1
            }
        }
    }
}