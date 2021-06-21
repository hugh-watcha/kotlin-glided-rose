package com.gildedrose

class GildedRose(var items: Array<Item>) {

    private val qualityUpdaterFactory by lazy { QualityUpdaterFactory() }

    fun updateQuality() {
        items.forEach { item ->
            qualityUpdaterFactory
                    .getUpdater(item.name)
                    .updateItemQuality(item)
        }
    }

}

