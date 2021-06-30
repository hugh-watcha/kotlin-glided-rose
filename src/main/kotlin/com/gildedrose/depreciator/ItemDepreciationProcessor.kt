package com.gildedrose.depreciator

import com.gildedrose.Item

sealed class ItemDepreciationProcessor(val item: Item) {
    companion object {
        const val
    }

    fun processDepreciationCycle() {
        updateSellInOneCycle()
        updateQualityOneCycle()
    }
    protected abstract fun updateSellInOneCycle()
    protected abstract fun updateQualityOneCycle()
}