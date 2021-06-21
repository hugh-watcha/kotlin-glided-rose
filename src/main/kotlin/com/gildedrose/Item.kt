package com.gildedrose

import com.gildedrose.QualityUpdater.Companion.MAX_QUALITY
import com.gildedrose.QualityUpdater.Companion.MIN_QUALITY

data class Item(
        var name: String,
        var sellIn: Int,
        var quality: Int
) {
    fun increaseQualityAtMost(increaseQuality: Int = 1, maxQuality: Int = MAX_QUALITY) {
        quality = (quality + increaseQuality).coerceAtMost(maxQuality)
    }

    fun initQuality() {
        quality = 0
    }

    fun decreaseQualityAtLeast(decreaseQuality: Int = 1, minQuality: Int = MIN_QUALITY) {
        quality = (quality - decreaseQuality).coerceAtLeast(minQuality)
    }

    fun sellOutBefore(days: Int): Boolean {
        return sellIn <= days
    }

    fun isSellOut(): Boolean {
        return sellIn < 0
    }
}