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
        val updater = getBaseUpdaterByItemName(item)
        updater.updateQuality(item)
    }

    private fun decreaseSellIn(item: Item) {
        val updater = getBaseUpdaterByItemName(item)
        updater.decreaseSellIn(item)
    }

    private fun updateQualityWhenSellOut(item: Item) {
        val updater = getBaseUpdaterByItemName(item)
        updater.updateQualityWhenSellOut(item)
    }

    private fun getBaseUpdaterByItemName(item: Item) = when (item.name) {
        NAME_AGED_BRIE -> AgedBrieUpdater()
        NAME_BACKSTAGE_PASSES -> BackStagePassesUpdater()
        NAME_SULFURAS -> SulfurasUpdater()
        else -> NormalUpdater()
    }

    companion object {
        private const val NAME_AGED_BRIE = "Aged Brie"
        private const val NAME_BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
        private const val NAME_SULFURAS = "Sulfuras, Hand of Ragnaros"
    }

}

