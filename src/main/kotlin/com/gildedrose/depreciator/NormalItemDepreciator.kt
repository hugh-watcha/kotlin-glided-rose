package com.gildedrose.depreciator

import com.gildedrose.Item

class NormalItemDepreciator(item: Item) : ItemDepreciator(item) {
    override fun calculateSellInOnDayPass() {
        item.sellIn--
    }

    override fun calculateQualityOnDayPass() {
        decreaseQualityIfPossible()
        if (item.sellIn < 0) {
            decreaseQualityIfPossible()
        }
    }

    private fun decreaseQualityIfPossible() {
        if (item.quality > 0) {
            item.quality--
        }
    }
}