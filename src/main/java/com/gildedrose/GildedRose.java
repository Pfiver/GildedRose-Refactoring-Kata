package com.gildedrose;

import java.util.Arrays;

public final class GildedRose {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateExpiryDateAndQuality() {

        Arrays.stream(items).forEach(item -> {
            updateExpiryDate(item);
            updateQuality(item);
        });
    }

    private static void updateExpiryDate(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.expiresIn = item.expiresIn - 1;
        }
    }

    private static void updateQuality(Item item) {
        if (!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASS)) {
            if (item.quality > 0) {
                if (!item.name.equals(SULFURAS)) {
                    item.quality = item.quality - 1;
                }
            }
        }
        else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals(BACKSTAGE_PASS)) {
                    if (item.expiresIn < 10) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                    if (item.expiresIn < 5) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }

        if (item.expiresIn < 0) {
            if (!item.name.equals(AGED_BRIE)) {
                if (!item.name.equals(BACKSTAGE_PASS)) {
                    if (item.quality > 0) {
                        if (!item.name.equals(SULFURAS)) {
                            item.quality = item.quality - 1;
                        }
                    }
                }
                else {
                    item.quality = 0;
                }
            }
            else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }
}
