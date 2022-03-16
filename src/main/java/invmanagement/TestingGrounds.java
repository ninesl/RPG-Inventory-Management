package invmanagement;

import invmanagement.character.EquipSlot;
import invmanagement.character.GameCharacter;
import invmanagement.character.NonPlayableCharacter;
import invmanagement.character.PlayerCharacter;
import invmanagement.item.Item;
import invmanagement.item.ItemContainer;
import invmanagement.item.ItemEquipment;

public class TestingGrounds {
    public static void main(String[] args) {
        GameCharacter player = new PlayerCharacter("Player", 0);
        GameCharacter fred = new NonPlayableCharacter("Fred", 0);
        Item jawn = new Item("Jawn", "blahblah");
        Item thisItem = new Item("Thingy", "blahblah");

        ItemEquipment helm = new ItemEquipment("Helm of the Jawn", "blahblah", EquipSlot.HEAD);
        ItemEquipment helm2 = new ItemEquipment("Helm of the Thingy", "blahblah", EquipSlot.HEAD);
        ItemContainer chest = new ItemContainer("Random Chest");

        chest.gainItem(helm, false);
        chest.gainItem(helm2, false);
        chest.gainItem(jawn, false);
        System.out.println();

        chest.listItems();
        System.out.println();

        player.getInventory().listItems();
        System.out.println();

        player.equipItemFromContainer(helm, chest);
        System.out.println();

        player.equipItemFromContainer(helm2, chest);
        System.out.println();

        chest.listItems();
        System.out.println();

        player.getInventory().listItems();
        System.out.println();


        /*
        player.getInventory().gainItem(thisItem, true);
        player.getInventory().gainItem(thisItem, true);
        fred.getInventory().gainItem(jawn, true);
        player.getInventory().listItems();
        fred.getInventory().listItems();
        System.out.println();
        fred.getInventory().takeItem(player.getInventory(), thisItem);
        player.getInventory().listItems();
        fred.getInventory().listItems();
        player.getInventory().listItems();
        */
    }
}
