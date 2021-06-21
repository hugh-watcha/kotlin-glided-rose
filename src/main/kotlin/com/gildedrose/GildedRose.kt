package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        items.forEach { item ->
            updateQuality(item)
            decreaseSellIn(item)
            updateQualityWhenSellOut(item)
        }
    }

    private fun updateQuality(item: Item) {
        when (item.name) {
            NAME_AGED_BRIE -> AgedBrieUpdater().updateQuality(item)
            NAME_BACKSTAGE_PASSES -> BackStagePassesUpdater().updateQuality(item)
            NAME_SULFURAS -> SulfurasUpdater().updateQuality(item)
            else -> NormalUpdater().updateQuality(item)
        }
    }

    private fun decreaseSellIn(item: Item) {
        when (item.name) {
            NAME_AGED_BRIE -> AgedBrieUpdater().decreaseSellIn(item)
            NAME_BACKSTAGE_PASSES -> BackStagePassesUpdater().decreaseSellIn(item)
            NAME_SULFURAS -> SulfurasUpdater().decreaseSellIn(item)
            else -> NormalUpdater().decreaseSellIn(item)
        }
    }

    private fun updateQualityWhenSellOut(item: Item) {
        when (item.name) {
            NAME_AGED_BRIE -> AgedBrieUpdater().updateQualityWhenSellOut(item)
            NAME_BACKSTAGE_PASSES -> BackStagePassesUpdater().updateQualityWhenSellOut(item)
            NAME_SULFURAS -> SulfurasUpdater().updateQualityWhenSellOut(item)
            else -> NormalUpdater().updateQualityWhenSellOut(item)
        }
    }

    companion object {
        private const val NAME_AGED_BRIE = "Aged Brie"
        private const val NAME_BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
        private const val NAME_SULFURAS = "Sulfuras, Hand of Ragnaros"
    }

}

