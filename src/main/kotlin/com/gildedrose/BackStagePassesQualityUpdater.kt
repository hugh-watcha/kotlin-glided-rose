package com.gildedrose

class BackStagePassesQualityUpdater : QualityUpdater {

    override fun updateQuality(item: Item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1
        }

        if (item.sellIn < 11) {
            if (item.quality < 50) {
                item.quality = item.quality + 1
            }
        }

        if (item.sellIn < 6) {
            if (item.quality < 50) {
                item.quality = item.quality + 1
            }
        }
    }

    override fun updateQualityWhenSellOut(item: Item) {
        item.quality = 0
    }
}