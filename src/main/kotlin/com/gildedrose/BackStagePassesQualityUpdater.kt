package com.gildedrose

class BackStagePassesQualityUpdater : QualityUpdater {

    override fun updateQuality(item: Item) = item.increaseQuality(getIncreaseQuality(item))

    private fun getIncreaseQuality(item: Item) = when {
        isExpiredBeforeFiveDays(item) -> FIVE_DAYS_INCREASE_QUALITY
        isExpiredBeforeTenDays(item) -> TEN_DAYS_INCREASE_QUALITY
        else -> NORMAL_DAYS_INCREASE_QUALITY
    }

    private fun isExpiredBeforeFiveDays(item: Item) = item.isBeforeExpired(FIVE_DAYS)

    private fun isExpiredBeforeTenDays(item: Item) = item.isBeforeExpired(TEN_DAYS)

    override fun updateQualityAfterExpired(item: Item) = item.initQuality()

    companion object {
        private const val FIVE_DAYS = 5
        private const val TEN_DAYS = 10
        private const val FIVE_DAYS_INCREASE_QUALITY = 3
        private const val TEN_DAYS_INCREASE_QUALITY = 2
        private const val NORMAL_DAYS_INCREASE_QUALITY = 1
    }
}