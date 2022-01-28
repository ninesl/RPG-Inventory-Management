package lancesbrain;

import java.util.HashMap;
import java.util.Map;

public abstract class GameCharacter {
    private String name;
    private Integer lvl;
    //Map<Item, Integer> inventory = new HashMap<>();
    private Map<String, ItemEquipment> equipped = new HashMap<>();

    public GameCharacter(String name, Integer lvl) {
        this.name = name;
        this.lvl = lvl;
        equipped.put("heads", null);
        equipped.put("chest", null);
        equipped.put("hands", null);
        equipped.put("legs", null);
        equipped.put("feet", null);
        equipped.put("weapon", null);
        equipped.put("shield", null);
    }

    public Map<String, ItemEquipment> getEquipped() {
        return equipped;
    }
}
