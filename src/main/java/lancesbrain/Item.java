package lancesbrain;

public class Item {
    private String itemName = null;
    private String itemDesc = null;

    public Item(String itemName, String itemDesc) {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
    }

    public String getItemName() { return itemName; }
    public String getItemDesc() { return itemDesc; }
}
