package com.gildedrose

import com.gildedrose.QualityUpdater.Companion.MAX_QUALITY

class BackStagePassesQualityUpdater : QualityUpdater {

    override fun updateQuality(item: Item) = item.increaseQualityAtMost(getIncreaseQuality(item), MAX_QUALITY)

    private fun getIncreaseQuality(item: Item) = when {
        sellOutBeforeFiveDays(item) -> 3
        sellOutBeforeTenDays(item) -> 2
        else -> 1
    }

    private fun sellOutBeforeFiveDays(item: Item) = item.sellOutBefore(FIVE_DAYS)

    private fun sellOutBeforeTenDays(item: Item) = item.sellOutBefore(TEN_DAYS)

    override fun updateQualityWhenSellOut(item: Item) = item.initQuality()

    companion object {
        private const val FIVE_DAYS = 5
        private const val TEN_DAYS = 10
    }
}