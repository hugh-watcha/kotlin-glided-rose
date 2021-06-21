package com.gildedrose

import com.gildedrose.QualityUpdater.Companion.MAX_QUALITY

class BackStagePassesQualityUpdater : QualityUpdater {

    override fun updateQuality(item: Item) {
        item.quality = getIncreaseQualityBySellOutDay(item)
    }

    private fun getIncreaseQualityBySellOutDay(item: Item) =
            (item.quality + getIncreaseQuality(item)).coerceAtMost(MAX_QUALITY)

    private fun getIncreaseQuality(item: Item) = when {
        sellOutBeforeFiveDays(item) -> 3
        sellOutBeforeTenDays(item) -> 2
        else -> 1
    }

    private fun sellOutBeforeFiveDays(item: Item) = item.sellIn <= FIVE_DAYS

    private fun sellOutBeforeTenDays(item: Item) = item.sellIn <= TEN_DAYS

    override fun updateQualityWhenSellOut(item: Item) = initQuality(item)

    private fun initQuality(item: Item) {
        item.quality = 0
    }

    companion object {
        private const val FIVE_DAYS = 5
        private const val TEN_DAYS = 10
    }
}