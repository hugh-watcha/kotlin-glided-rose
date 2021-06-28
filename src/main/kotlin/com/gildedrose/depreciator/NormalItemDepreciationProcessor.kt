package com.gildedrose.depreciator

import com.gildedrose.Item

class NormalItemDepreciationProcessor(item: Item) : ItemDepreciationProcessor(item) {
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
        if (item.quality > 0) {
            item.quality--
        }
    }
}