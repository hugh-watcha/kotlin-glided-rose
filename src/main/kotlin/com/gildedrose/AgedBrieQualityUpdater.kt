package com.gildedrose

class AgedBrieQualityUpdater : QualityUpdater {

    override fun updateQuality(item: Item) = increaseQuality(item)

    override fun updateQualityAfterExpired(item: Item) = increaseQuality(item)

    private fun increaseQuality(item: Item) = item.increaseQuality()

}