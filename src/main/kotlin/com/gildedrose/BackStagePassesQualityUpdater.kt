package com.gildedrose

class BackStagePassesQualityUpdater : QualityUpdater {

    override fun updateQuality(item: Item) {
        item.quality = 50.coerceAtMost(item.quality + 1)

        if (item.sellIn < 11) {
            item.quality = 50.coerceAtMost(item.quality + 1)
        }

        if (item.sellIn < 6) {
            item.quality = 50.coerceAtMost(item.quality + 1)
        }
    }

    override fun updateQualityWhenSellOut(item: Item) {
        item.quality = 0
    }
}