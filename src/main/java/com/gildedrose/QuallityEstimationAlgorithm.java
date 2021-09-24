package com.gildedrose;

import static com.gildedrose.GildedRose.*;

public class QuallityEstimationAlgorithm {

    static void updateQuality(Item item) {
        switch (item.name) {
            case SULFURAS ->        {}
            case AGED_BRIE ->       updateAgedBrieQuality(item);
            case BACKSTAGE_PASS ->  updateBackstagePassQuality(item);
            default ->              updateStandardItemQuality(item);
        }
    }

    private static void updateAgedBrieQuality(Item item) {
        adjustQuality(item, 1);
        if (item.expiresIn < 0) adjustQuality(item, 1);
    }

    private static void updateBackstagePassQuality(Item item) {
        adjustQuality(item, 1);
        if (item.expiresIn < 10) adjustQuality(item, 1);
        if (item.expiresIn < 5) adjustQuality(item, 1);
        if (item.expiresIn < 0) adjustQuality(item, Integer.MIN_VALUE);
    }

    private static void updateStandardItemQuality(Item item) {
        adjustQuality(item, -1);
        if (item.expiresIn < 0) adjustQuality(item, -1);
    }

    private static void adjustQuality(Item item, int amount) {
        item.quality += amount <= 0
                ? Math.max(-item.quality, amount)
                : Math.min(50 - item.quality, amount);
    }
}
