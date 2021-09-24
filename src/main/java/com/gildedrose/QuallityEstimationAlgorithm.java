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
        item.adjustQuality(1);
        if (item.expiresIn < 0) item.adjustQuality(1);
    }

    private static void updateBackstagePassQuality(Item item) {
        item.adjustQuality(1);
        if (item.expiresIn < 10) item.adjustQuality(1);
        if (item.expiresIn < 5) item.adjustQuality(1);
        if (item.expiresIn < 0) item.adjustQuality(Integer.MIN_VALUE);
    }

    private static void updateStandardItemQuality(Item item) {
        item.adjustQuality(-1);
        if (item.expiresIn < 0) item.adjustQuality(-1);
    }
}
