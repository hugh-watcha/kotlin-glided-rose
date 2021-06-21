package com.gildedrose

class QualityUpdaterFactory {

    private val updaters = mapOf(
            NAME_AGED_BRIE to AgedBrieQualityUpdater(),
            NAME_BACKSTAGE_PASSES to BackStagePassesQualityUpdater(),
            NAME_SULFURAS to SulfurasQualityUpdater()
    )

    fun getUpdater(name: String): QualityUpdater {
        return updaters[name] ?: NormalQualityUpdater()
    }

    companion object {
        const val NAME_AGED_BRIE = "Aged Brie"
        const val NAME_BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
        const val NAME_SULFURAS = "Sulfuras, Hand of Ragnaros"
    }
}