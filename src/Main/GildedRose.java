package Main;

public class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (isSpecialItem(item)) {
            updateSpecialItem(item);
            updateSellIn(item);
            if (item.sellIn < 0) {
                handleExpiredSpecialItem(item);
            }
            return;
        }

        updateRegularItem(item);
        updateSellIn(item);
        if (item.sellIn < 0) {
            handleExpiredRegularItem(item);
        }
    }

    private boolean isSpecialItem(Item item) {
        return item.name.equals("Aged Brie") || item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void updateSpecialItem(Item item) {
        if (item.quality >= 50) return;

        item.quality += 1;

        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.sellIn < 11 && item.quality < 50) {
                item.quality += 1;
            }
            if (item.sellIn < 6 && item.quality < 50) {
                item.quality += 1;
            }
        }
    }

    private void updateRegularItem(Item item) {
        if (item.quality <= 0 || item.name.equals("Sulfuras, Hand of Ragnaros")) return;

        item.quality -= 1;
    }

    private void updateSellIn(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) return;

        item.sellIn -= 1;
    }

    private void handleExpiredSpecialItem(Item item) {
        if (item.name.equals("Aged Brie") && item.quality < 50) {
            item.quality += 1;
            return;
        }

        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        }
    }

    private void handleExpiredRegularItem(Item item) {
        if (item.quality <= 0 || item.name.equals("Sulfuras, Hand of Ragnaros")) return;

        item.quality -= 1;
    }
}
