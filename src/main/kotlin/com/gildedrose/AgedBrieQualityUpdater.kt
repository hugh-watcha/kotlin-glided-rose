package com.gildedrose

class AgedBrieQualityUpdater : QualityUpdater {

    override fun updateQuality(item: Item) {
        increaseQuality(item)
    }

    override fun updateQualityWhenSellOut(item: Item) {
        increaseQuality(item)
    }

    private fun increaseQuality(item: Item) {
        item.increaseQualityAtMost()
    }

}