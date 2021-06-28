package com.gildedrose.depreciator

import com.gildedrose.Item

class BackstagePassesDepreciator(item: Item) : ItemDepreciator(item) {
    override fun calculateSellInOnDayPass() {
        item.sellIn--
    }

    override fun calculateQualityOnDayPass() {
        val sellIn = item.sellIn
        if (sellIn >= 0) {
            increaseQualityIfPossible()
            if (sellIn < 10) {
                increaseQualityIfPossible()
            }
            if (sellIn < 5) {
                increaseQualityIfPossible()
            }
        } else {
            item.quality = 0
        }
    }

    private fun increaseQualityIfPossible() {
        if (item.quality < 50) {
            item.quality++
        }
    }
}