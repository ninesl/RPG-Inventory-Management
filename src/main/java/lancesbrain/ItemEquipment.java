package lancesbrain;

//All items that are able to be equipped by a Character
public class ItemEquipment extends Item {
    private String equipSlot = null; //head, chest, hands, legs, feet, weapon, shield, charm

    public ItemEquipment(String itemName, String itemDesc, String slot) {
        super(itemName, itemDesc);
        this.equipSlot = slot;
    }

    public String getEquipSlot() {
        return equipSlot;
    }
}
