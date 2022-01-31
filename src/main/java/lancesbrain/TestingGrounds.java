package lancesbrain;

public class TestingGrounds {
    public static void main(String[] args) {
        Item myItem = new Item("Jawn", "blahblah");
        Item thisItem = new Item("Thingy", "blahblah");
        GameCharacter player = new PlayerCharacter("Player", 0);
        GameCharacter fred = new NonPlayableCharacter("Fred", 0);

        player.inventory.gainItem(thisItem, true);
        player.inventory.gainItem(thisItem, true);
        fred.inventory.gainItem(myItem, true);
        player.inventory.listItems();
        fred.inventory.listItems();
        System.out.println();
        fred.inventory.swapItems(player.inventory, thisItem);
        player.inventory.listItems();
        fred.inventory.listItems();

        //player.inventory.listItems();
    }
}
