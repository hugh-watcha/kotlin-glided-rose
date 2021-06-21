package com.gildedrose

open class NormalUpdater {

    open fun updateQuality(item: Item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1
        }
    }

    open fun decreaseSellIn(item: Item) {
        item.sellIn = item.sellIn - 1
    }

    open fun updateQualityWhenSellOut(item: Item) {
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1
            }
        }
    }
}