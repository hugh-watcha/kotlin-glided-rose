package com.gildedrose

open class NormalQualityUpdater : QualityUpdater {

    override fun updateQuality(item: Item) {
        decreaseQuality(item)
    }

    override fun updateQualityWhenSellOut(item: Item) {
        decreaseQuality(item)
    }

    private fun decreaseQuality(item: Item) {
        item.decreaseQualityAtLeast()
    }


}