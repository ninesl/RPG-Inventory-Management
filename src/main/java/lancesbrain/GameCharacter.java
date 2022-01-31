package lancesbrain;

import java.util.HashMap;
import java.util.Map;

public abstract class GameCharacter {
    protected String name;
    protected Integer lvl;
    protected ItemContainer inventory;
    protected Map<String, ItemEquipment> equipped = new HashMap<>();

    public GameCharacter(String name, Integer lvl) {
        this.name = name;
        this.lvl = lvl;
        inventory = new ItemContainer(name + "'s Inventory");
        equipped.put("heads", null);
        equipped.put("chest", null);
        equipped.put("hands", null);
        equipped.put("legs", null);
        equipped.put("feet", null);
        equipped.put("right hand", null);
        equipped.put("left hand", null);
    }

    public Map<String, ItemEquipment> getEquipped() {
        return equipped;
    }

    //Equips valid ITEM EQUIPMENT to character
    public void equipItem(ItemEquipment item) {
        //checks to see if equip map has matching slot
        if(equipped.get(item.getEquipSlot()) != null) {
            equipped.put(item.getEquipSlot(), item);
        }
    }
    //Overloaded method that will remove item from given container
    public void equipItem(ItemEquipment item, ItemContainer myContainer) {
        //checks to see if equip map has matching slot
        if(equipped.get(item.getEquipSlot()) != null) {
            equipped.put(item.getEquipSlot(), item);
            myContainer.removeItem(item, false);
        }
    }
    //TODO make unequipItem method, put item into inventory when unequipped
    /*
    public void putItemInInventory(Item item) {
        inventory.gainItem(item);
    }*/
}
