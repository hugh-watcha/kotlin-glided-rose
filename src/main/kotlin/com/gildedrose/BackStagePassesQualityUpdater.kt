package com.gildedrose

class BackStagePassesQualityUpdater : BaseQualityUpdater {

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
        if (item.sellIn < 0) {

            item.quality = item.quality - item.quality
        }
    }
}