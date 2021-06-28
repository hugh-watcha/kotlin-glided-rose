package com.gildedrose

class BackStagePassesQualityUpdater : QualityUpdater {

    override fun updateQuality(item: Item) = item.increaseQuality(getIncreaseQuality(item))

    private fun getIncreaseQuality(item: Item) = when {
        sellOutBeforeFiveDays(item) -> FIVE_DAYS_INCREASE_QUALITY
        sellOutBeforeTenDays(item) -> TEN_DAYS_INCREASE_QUALITY
        else -> NORMAL_DAYS_INCREASE_QUALITY
    }

    private fun sellOutBeforeFiveDays(item: Item) = item.sellOutBefore(FIVE_DAYS)

    private fun sellOutBeforeTenDays(item: Item) = item.sellOutBefore(TEN_DAYS)

    override fun updateQualityWhenSellOut(item: Item) = item.initQuality()

    companion object {
        private const val FIVE_DAYS = 5
        private const val TEN_DAYS = 10
        private const val FIVE_DAYS_INCREASE_QUALITY = 3
        private const val TEN_DAYS_INCREASE_QUALITY = 2
        private const val NORMAL_DAYS_INCREASE_QUALITY = 1
    }
}