package com.gildedrose


data class Item(
        var name: String,
        var sellIn: Int,
        var quality: Int
) {

    fun initQuality() {
        quality = DEFAULT_QUALITY
    }

    fun increaseQuality(increaseQuality: Int = DEFAULT_INCREASE_QUALITY) {
        quality = (quality + increaseQuality).coerceAtMost(MAX_QUALITY)
    }

    fun decreaseQuality() {
        quality = (quality - DEFAULT_DECREASE_QUALITY).coerceAtLeast(MIN_QUALITY)
    }

    fun decreaseSellIn() {
        sellIn -= DEFAULT_DECREASE_SELL_IN
    }

    fun isBeforeExpired(days: Int): Boolean = sellIn <= days

    fun isExpired(): Boolean = sellIn < EXPIRED_DAYS

    companion object {
        private const val MIN_QUALITY = 0
        private const val MAX_QUALITY = 50
        private const val DEFAULT_QUALITY = 0
        private const val DEFAULT_INCREASE_QUALITY = 1
        private const val DEFAULT_DECREASE_QUALITY = 1
        private const val EXPIRED_DAYS = 0
        private const val DEFAULT_DECREASE_SELL_IN = 1
    }
}