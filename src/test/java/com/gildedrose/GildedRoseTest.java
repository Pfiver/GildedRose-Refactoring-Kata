package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    Item[] items = {
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6)
    };

    GildedRose sut = new GildedRose(items);

    @Test
    void test() throws Exception {

        URL testDataResource = Objects.requireNonNull(GildedRose.class.getResource("/30-days.txt"));
        String expected = new String(testDataResource.openStream().readAllBytes());

        var bos = new ByteArrayOutputStream();
        try (var out = new java.io.PrintStream(bos)) {
            for (int day = 0; day <= 30; day++) {

                out.println("-------- day " + day + " --------");
                out.println("name, sellIn, quality");
                for (Item item : items) {
                    out.println(item);
                }
                out.println();

                sut.updateExpiryDateAndQuality();
            }
        }
        String actual = bos.toString();

        assertEquals(expected, actual);
    }
}
