package com.gildedrose

class SulfurasQualityUpdater : QualityUpdater {

    override fun updateQuality(item: Item) = Unit

    override fun decreaseSellIn(item: Item) = Unit

    override fun updateQualityAfterExpired(item: Item) = Unit
}