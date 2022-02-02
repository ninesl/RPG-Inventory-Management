package lancesbrain;

//All items that are able to be equipped by a Character
public class ItemEquipment extends Item {
    private EquipSlot equipSlot; //head, chest, hands, legs, feet,
                                     //weapon, shield, charm??

    public ItemEquipment(String itemName, String itemDesc, EquipSlot equipSlot) {
        super(itemName, itemDesc);
        this.equipSlot = equipSlot;
    }

    public EquipSlot getEquipSlot() {
        return equipSlot;
    }
}
