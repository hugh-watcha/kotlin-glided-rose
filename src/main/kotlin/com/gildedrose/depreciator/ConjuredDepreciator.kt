package com.gildedrose.depreciator

import com.gildedrose.Item

class ConjuredDepreciator(item: Item) : ItemDepreciator(item) {
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
        if (item.quality > 1) {
            item.quality -= 2
        } else {
            item.quality = 0
        }
    }
}