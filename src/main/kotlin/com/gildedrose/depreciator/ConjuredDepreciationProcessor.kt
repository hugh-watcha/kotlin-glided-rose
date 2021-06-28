package com.gildedrose.depreciator

import com.gildedrose.Item

class ConjuredDepreciationProcessor(item: Item) : ItemDepreciationProcessor(item) {
    override fun updateSellInOneCycle() {
        item.sellIn--
    }

    override fun updateQualityOneCycle() {
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