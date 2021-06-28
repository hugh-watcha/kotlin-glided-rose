package com.gildedrose.depreciator

import com.gildedrose.Item

class AgedBrieDepreciator(item: Item) : ItemDepreciator(item) {
    override fun calculateSellInOnDayPass() {
        item.sellIn--
    }

    override fun calculateQualityOnDayPass() {
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