package lancesbrain;

import java.util.HashMap;
import java.util.Map;

public abstract class GameCharacter {

    protected String name;
    protected Integer lvl;
    protected ItemContainer inventory;
    protected Map<EquipSlot, ItemEquipment> equipped = new HashMap<>();


    public GameCharacter(String name, Integer lvl) {
        this.name = name;
        this.lvl = lvl;
        inventory = new ItemContainer(name + "'s Inventory");
        equipped.put(EquipSlot.HEAD, null);
        equipped.put(EquipSlot.CHEST, null);
        equipped.put(EquipSlot.HANDS, null);
        equipped.put(EquipSlot.LEGS, null);
        equipped.put(EquipSlot.FEET, null);
        //equipped.put("right hand", null);
        //equipped.put("left hand", null);
    }

    public Map<EquipSlot, ItemEquipment> getEquipped() {
        return equipped;
    }

    //If something is already equipped will remove it
    private void equipItem(ItemEquipment item) {
        System.out.println(name + " has equipped " + item.getItemName());

        //checks to see if equipped map already has in it
        if(equipped.get(item.getEquipSlot()) != null) {
            unequipItemToContainer(equipped.get(item.getEquipSlot()), inventory);
        }

        equipped.put(item.getEquipSlot(), item);
    }
    //overwrites equipped to be null, AKA destroy item in EquipSlot
    private void unequipItem(EquipSlot equipSlot) {
        if(equipped.get(equipSlot) != null) {
            equipped.put(equipSlot, null);
        }
    }

    //method that will remove item from given container
    //PLAYERS INVENTORY MUST BE USED WHEN UNEQUIPPING
    public void equipItemFromContainer(ItemEquipment item, ItemContainer myContainer) {
        myContainer.removeItem(item, true);
        equipItem(item);
    }
    //Must have destination when unequipping, will be player's inventory 99% of the time
    public void unequipItemToContainer(ItemEquipment item, ItemContainer myContainer) {
        myContainer.gainItem(item, true);
        unequipItem(item.getEquipSlot());
    }
}
