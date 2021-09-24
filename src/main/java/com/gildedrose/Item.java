package com.gildedrose;

public class Item {

    public final String name;
    public int expiresIn;
    public int quality;

    public Item(String name, int expiresIn, int quality) {
        this.name = name;
        this.expiresIn = expiresIn;
        this.quality = quality;
    }

    protected void adjustQuality(int amount) {
        quality += amount > 0 ? Math.min(50 - quality, amount) : Math.max(-quality, amount);
    }

    @Override
   public String toString() {
        return this.name + ", " + this.expiresIn + ", " + this.quality;
    }
}
