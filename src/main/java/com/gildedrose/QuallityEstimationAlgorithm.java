package com.gildedrose;

import static com.gildedrose.GildedRose.*;

public final class QuallityEstimationAlgorithm {

    private final Item item;

    QuallityEstimationAlgorithm(Item item) {
        this.item = item;
    }

    void apply() {
        switch (item.name) {
            case SULFURAS ->        {}
            case AGED_BRIE ->       updateAgedBrieQuality();
            case BACKSTAGE_PASS ->  updateBackstagePassQuality();
            default ->              updateStandardItemQuality();
        }
    }

    private void updateAgedBrieQuality() {
        adjustQuality(1);
        if (item.expiresIn < 0) adjustQuality(1);
    }

    private void updateBackstagePassQuality() {
        adjustQuality(1);
        if (item.expiresIn < 10) adjustQuality(1);
        if (item.expiresIn < 5) adjustQuality(1);
        if (item.expiresIn < 0) adjustQuality(Integer.MIN_VALUE);
    }

    private void updateStandardItemQuality() {
        adjustQuality(-1);
        if (item.expiresIn < 0) adjustQuality(-1);
    }

    private void adjustQuality(int amount) {
        item.quality += amount <= 0
                ? Math.max(-item.quality, amount)
                : Math.min(50 - item.quality, amount);
    }
}
