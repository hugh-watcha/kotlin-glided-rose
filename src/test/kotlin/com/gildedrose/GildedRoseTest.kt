package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GildedRoseTest {

    // 처음의 접근은, 일단 테스트 item set 을 모두 마련하려고 하다가..
    // 생각해보니 일단 목적은 테스트 커버리지 100을 만드는 것
    // 흠.. 그럼 일단은 각 케이스별로 아이템을 구성해서 테스트해보자.
    // 여전히 고민은 되는 게, 더 다양한 케이스의 아이템들을 테스트해볼 필요가 있지 않을까..?? 단순히 100%가 전부는 아닌 거 같다.

    // name = "Aged Brie"
    // name = "Backstage passes to a TAFKAL80ETC concert"
    // name = "Sulfuras, Hand of Ragnaros"
    // name = "normal"

    // sellIn 15, 10, 8, 5, 3, 0
    // quality > sellIn, quality == sellIn, quality < sellIn

    // given, when, then

    @Test
    fun `일반 아이템 하루 지나면 quality 가 1 감소해야 한다`() {
        val quality = 6
        val item = Item(ITEM_NAME_NORMAL, 10, quality)
        val gildedRose = createGildedRoseWithOneItem(item)

        gildedRose.computeDaysElapsing(1)

        assertEquals(quality - 1, gildedRose.items.first().quality)
    }

    @Test
    fun `일반 아이템 SellIn을 넘게 시간이 지나면 quality 가 2씩 감소해야 한다`() {
        val quality = 10
        val item = Item(ITEM_NAME_NORMAL, 0, quality)
        val gildedRose = createGildedRoseWithOneItem(item)
        gildedRose.computeDaysElapsing(1)
        assertEquals(quality - 2, gildedRose.items.first().quality)
    }

    @Test
    fun `일반 아이템 quality 는 시간이 지나도 음수가 되진 않는다`() {
        val quality = 0
        val item = Item(ITEM_NAME_NORMAL, 10, quality)
        val gildedRose = createGildedRoseWithOneItem(item)
        gildedRose.computeDaysElapsing(1)
        assertEquals(0, gildedRose.items.first().quality)
    }

    @Test
    fun `Aged Brie 는 SellIn이 0 이상이면 하루가 지나면 quality 1이 증가해야 한다`() {
        val quality = 5
        val brie = Item(ITEM_NAME_BRIE, 1, quality)
        val gildedRose = createGildedRoseWithOneItem(brie)
        gildedRose.computeDaysElapsing(1)
        assertEquals(quality + 1, gildedRose.items.first().quality)
    }

    @Test
    fun `Aged Brie 는 SellIn 이 0 미만이면 하루가 지나면 quality 1이 증가해야 한다`() {
        val quality = 5
        val brie = Item(ITEM_NAME_BRIE, 0, quality)
        val gildedRose = createGildedRoseWithOneItem(brie)
        gildedRose.computeDaysElapsing(1)
        assertEquals(quality + 2, gildedRose.items.first().quality)
    }

    @Test
    fun `Aged Brie quality 는 50을 초과하진 않아야 한다`() {
        val brie = Item(ITEM_NAME_BRIE, 10, 50)
        val gildedRose = createGildedRoseWithOneItem(brie)

        gildedRose.computeDaysElapsing(1)
        assertEquals(50, gildedRose.items.first().quality)
    }

    @Test
    fun `Sulfuras 는 시간이 지나도 quality 가 감소하지 않아야 한다`() {
        val quality = 10
        val sulfuras = Item(ITEM_NAME_SULFURAS, 10, quality)
        val gildedRose = createGildedRoseWithOneItem(sulfuras)
        gildedRose.computeDaysElapsing(1)
        assertEquals(quality, gildedRose.items.first().quality)
    }

    @Test
    fun `Backstage Passes 는 SellIn 10 초과일 때엔 하루 지나면 quality 가 1 증가해야 한다`() {
        val quality = 10
        val backstagePass = Item(ITEM_NAME_BACKSTAGE, 11, quality)
        val gildedRose = createGildedRoseWithOneItem(backstagePass)

        gildedRose.computeDaysElapsing(1)
        assertEquals(quality + 1, gildedRose.items.first().quality)
    }

    @Test
    fun `Backstage Passes 는 SellIn 이 10 이하, 5 초과일 때엔 하루에 quality 가 2 증가해야 한다`() {
        val quality = 10
        val backstagePass = Item(ITEM_NAME_BACKSTAGE, 10, quality)
        val gildedRose = createGildedRoseWithOneItem(backstagePass)

        gildedRose.computeDaysElapsing(1)
        assertEquals(quality + 2, gildedRose.items.first().quality)
    }

    @Test
    fun `Backstage Passes 는 SellIn 이 5 이하, 0 초과일 때 하루에 quality 가 3 증가해야 한다`() {
        val quality = 10
        val backstagePass = Item(ITEM_NAME_BACKSTAGE, 5, quality)
        val gildedRose = createGildedRoseWithOneItem(backstagePass)

        gildedRose.computeDaysElapsing(1)
        assertEquals(quality + 3, gildedRose.items.first().quality)
    }

    @Test
    fun `Backstage Passes 는 SellIn 이 지나면 quality 가 0이 된다`() {
        val backstagePass = Item(ITEM_NAME_BACKSTAGE, 0, 10)
        val gildedRose = createGildedRoseWithOneItem(backstagePass)

        gildedRose.computeDaysElapsing(1)
        assertEquals(0, gildedRose.items.first().quality)
    }

    private fun GildedRose.computeDaysElapsing(days: Int) {
        repeat(days) {
            updateQuality()
        }
    }

    private fun createGildedRoseWithOneItem(item: Item): GildedRose = GildedRose(arrayOf(item))

    companion object {
        private const val ITEM_NAME_NORMAL = "normal"
        private const val ITEM_NAME_BRIE = "Aged Brie"
        private const val ITEM_NAME_SULFURAS = "Sulfuras, Hand of Ragnaros"
        private const val ITEM_NAME_BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
    }
}