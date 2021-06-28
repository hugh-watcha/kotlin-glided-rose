package com.gildedrose.depreciator

import com.gildedrose.Item

sealed class ItemDepreciator(val item: Item) {
    fun passOneDay() {
        calculateSellInOnDayPass()
        calculateQualityOnDayPass()
    }
    protected abstract fun calculateSellInOnDayPass()
    protected abstract fun calculateQualityOnDayPass()
}