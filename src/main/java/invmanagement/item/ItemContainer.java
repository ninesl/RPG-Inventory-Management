package invmanagement.item;

import invmanagement.ConsoleGraphics;

import java.util.HashMap;

//ALWAYS DEFINED AS <ITEM, INTEGER>, item being the actual item integer being how many
                                    //Has to be this type of hashmap, pretty cool TBH
public class ItemContainer extends HashMap<Item, Integer> {
    private String nameOfContainer = null;
    public ItemContainer(String nameOfContainer) {
        super();
        this.nameOfContainer = nameOfContainer;
    }
    public String getNameOfContainer() {
        return nameOfContainer;
    }

    //Notify user if message is true
    //Equipping/unequipping item message would be false, implied that it is no longer in inventory and is equipped
    public void gainItem(Item gainedItem, boolean message) {
        gainItem(gainedItem);
        if(message)
            System.out.println(gainedItem.getItemName() + " added to " + getNameOfContainer());
    }
    public void removeItem(Item removedItem, boolean message) {
        removeItem(removedItem);
        if(message)//could check to see if removedItem actually removed, definitely overkill bc of logic in removeItem
            System.out.println(removedItem.getItemName() + " removed from " + getNameOfContainer());
    }

    //private use only, public overload forces decision to notify user or not
    private void gainItem(Item gainedItem) {
        if (containsKey(gainedItem)) {
            this.put(gainedItem, get(gainedItem) + 1);
        } else {
            this.put(gainedItem, 1);
        }
    }
    private void removeItem(Item removedItem) {
        if(containsKey(removedItem)) { //if item doesn't exist print err message.
            if(this.get(removedItem) > 1) {
                this.put(removedItem, get(removedItem) - 1);
            } else if(this.get(removedItem) == 1) {
                this.remove(removedItem); //removes item completely from this item container
            }
        } else { //err message, SHOULD NEVER HAPPEN, USED FOR INTERNAL GAME TESTING
            System.out.println("ERROR: item " + removedItem.getItemName() + " did not exist in " + getNameOfContainer());
            System.out.println("game logic may be broked");
        }
    }

    //TODO swapItems should be default gainItem method? change method name to match function?
    public void takeItem(ItemContainer itemSource, Item takenItem) {
        itemSource.removeItem(takenItem);
        this.gainItem(takenItem);
        System.out.println(takenItem.getItemName() + " given to " + this.getNameOfContainer() + " from " + itemSource.getNameOfContainer());
    }

    //Lists items from this instance of ItemContainer
    public void listItems() {
        //ConsoleGraphics.clearScreen(); to be used in gameloop
        System.out.println(getNameOfContainer());
        ConsoleGraphics.printBannerLine();
        if(!this.isEmpty()) {
            for (Entry<Item, Integer> eachItem : entrySet()) {
                //                       Item name                     # of items
                System.out.println(eachItem.getValue() + " " + eachItem.getKey().getItemName() + ConsoleGraphics.sOrNot(eachItem.getValue()));
            }
        } else {
            System.out.println("Empty");
        }
    }
}
