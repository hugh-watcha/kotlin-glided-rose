package com.gildedrose

import com.gildedrose.QualityUpdater.Companion.MAX_QUALITY
import com.gildedrose.QualityUpdater.Companion.MIN_QUALITY

data class Item(
        var name: String,
        var sellIn: Int,
        var quality: Int
) {

    fun initQuality() {
        quality = 0
    }

    fun increaseQualityAtMost(increaseQuality: Int = 1, maxQuality: Int = MAX_QUALITY) {
        quality = (quality + increaseQuality).coerceAtMost(maxQuality)
    }

    fun decreaseQualityAtLeast(decreaseQuality: Int = 1, minQuality: Int = MIN_QUALITY) {
        quality = (quality - decreaseQuality).coerceAtLeast(minQuality)
    }

    fun decreaseSellIn() {
        sellIn -= 1
    }

    fun sellOutBefore(days: Int): Boolean = sellIn <= days

    fun isSellOut(): Boolean = sellIn < 0

}