package com.gildedrose

fun Item.decreaseSellIn() {
    sellIn--
}

fun Item.increaseQuality(max: Int) {
    quality = max.coerceAtMost(quality + 1)
}

fun Item.decreaseQuality(min: Int) {
    quality = min.coerceAtLeast(quality - 1)
}