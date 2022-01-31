package lancesbrain;

import java.util.HashMap;

//ALWAYS DEFINED AS <ITEM, INTEGER>, item being the actual item integer being how many
                                    //Has to be this type of hashmap, pretty cool TBH
public class ItemContainer extends HashMap<Item, Integer> {
    private String nameOfContainer = null; //used as descriptor for bug testing, may be utilited later
    public ItemContainer(String nameOfContainer) {
        super();
        this.nameOfContainer = nameOfContainer;
    }
    public String getNameOfContainer() {
        return nameOfContainer;
    }

    //gainItem() and removeItem() used in overloaded methods when gaining items or removing items
    //this. used for clarity for myself
    //used in tandem
    public void swapItems(ItemContainer itemSource, Item takenItem) {
        itemSource.removeItem(takenItem);
        this.gainItem(takenItem);
        System.out.println(takenItem.getItemName() + " given to " + this.getNameOfContainer() + " from " + itemSource.getNameOfContainer());
    }
    public void gainItem(Item gainedItem, boolean message) {
        System.out.println(gainedItem.getItemName() + " added to " + getNameOfContainer());
        gainItem(gainedItem);
    }
    public void removeItem(Item removedItem, boolean message) {
        System.out.println(removedItem.getItemName() + " removed from " + getNameOfContainer());
        removeItem(removedItem);
    }
    public void gainItem(Item gainedItem) {
        if (containsKey(gainedItem)) {
            this.put(gainedItem, get(gainedItem) + 1);
        } else {
            this.put(gainedItem, 1);
        }
    }
    public void removeItem(Item removedItem) {
        if(containsKey(removedItem)) { //if item doesn't exist print err message.
            if(get(removedItem) > 1) {
                this.put(removedItem, get(removedItem) - 1);
            } else if(get(removedItem) == 1) {
                this.remove(removedItem); //removes item completely from this item container
            }
        } else { //err message, SHOULD NEVER HAPPEN, USED FOR INTERNAL GAME TESTING
            System.out.println("ERROR: item " + removedItem.getItemName() + " did not exist in " + getNameOfContainer());
            System.out.println("game logic may be broked");
        }
    }

    public void listItems() {
        //ConsoleGraphics.clearScreen(); to be used in gameloop
        System.out.println();
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
