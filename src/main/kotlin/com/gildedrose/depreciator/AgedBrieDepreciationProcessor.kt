package com.gildedrose.depreciator

import com.gildedrose.Item

class AgedBrieDepreciationProcessor(item: Item) : ItemDepreciationProcessor(item) {
    override fun updateSellInOneCycle() {
        item.sellIn--
    }

    override fun updateQualityOneCycle() {
        increaseQualityIfPossible()
        if (item.sellIn < 0) {
            increaseQualityIfPossible()
        }
    }

    private fun increaseQualityIfPossible() {
        if (item.quality < 50) {
            item.quality++
        }
    }
}