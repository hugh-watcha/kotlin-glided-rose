package com.gildedrose

interface BaseUpdater {

    fun updateQuality(item: Item)

    fun decreaseSellIn(item: Item)

    fun updateQualityWhenSellOut(item: Item)
}