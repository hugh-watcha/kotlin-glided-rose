package com.gildedrose

class QualityUpdaterFactory {

    private val updaters = mapOf(
            NAME_AGED_BRIE to AgedBrieQualityUpdater(),
            NAME_BACKSTAGE_PASSES to BackStagePassesQualityUpdater(),
            NAME_SULFURAS to SulfurasQualityUpdater(),
            NAME_NORMAL to NormalQualityUpdater()
    )

    fun getUpdater(name: String): QualityUpdater {
        return try {
            updaters.getValue(name)
        } catch (ex: NoSuchElementException) {
            updaters.getValue(NAME_NORMAL)
        }
    }

    companion object {
        const val NAME_AGED_BRIE = "Aged Brie"
        const val NAME_BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"
        const val NAME_SULFURAS = "Sulfuras, Hand of Ragnaros"
        const val NAME_NORMAL = ""
    }
}