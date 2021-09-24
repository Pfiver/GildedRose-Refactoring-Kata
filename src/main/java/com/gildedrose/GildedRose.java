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
            new QuallityEstimationAlgorithm(item).apply();
        });
    }

    private static void updateExpiryDate(Item item) {
        if (!SULFURAS.equals(item.name)) {
            item.expiresIn--;
        }
    }
}
