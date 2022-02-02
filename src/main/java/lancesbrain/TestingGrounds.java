package lancesbrain;

public class TestingGrounds {
    public static void main(String[] args) {
        GameCharacter player = new PlayerCharacter("Player", 0);
        GameCharacter fred = new NonPlayableCharacter("Fred", 0);

        ItemEquipment helm = new ItemEquipment("Helm of the Jawn", "blahblah", EquipSlot.HEAD);
        ItemEquipment helm2 = new ItemEquipment("Helm of the Thingy", "blahblah", EquipSlot.HEAD);
        Item jawn = new Item("Jawn", "blahblah");
        ItemContainer chest = new ItemContainer("Random Chest");

        chest.gainItem(helm, false);
        chest.gainItem(helm2, false);
        chest.gainItem(jawn, false);
        System.out.println();

        chest.listItems();
        System.out.println();

        player.inventory.listItems();
        System.out.println();

        player.equipItemFromContainer(helm, chest);
        System.out.println();

        player.equipItemFromContainer(helm2, chest);
        System.out.println();

        chest.listItems();
        System.out.println();

        player.inventory.listItems();
        System.out.println();
/*
        Item thisItem = new Item("Thingy", "blahblah");

        player.inventory.gainItem(thisItem, true);
        player.inventory.gainItem(thisItem, true);
        fred.inventory.gainItem(myItem, true);
        player.inventory.listItems();
        fred.inventory.listItems();
        System.out.println();
        fred.inventory.swapItems(player.inventory, thisItem);
        player.inventory.listItems();
        fred.inventory.listItems();*/

        //player.inventory.listItems();
    }
}
