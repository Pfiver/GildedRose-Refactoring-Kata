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

   @Override
   public String toString() {
        return this.name + ", " + this.expiresIn + ", " + this.quality;
    }
}
