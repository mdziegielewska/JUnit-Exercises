package test.fridge.TestHelper;

import main.fridge.Fridge;

public class CountItems {
    public int countAllItems(Fridge fridge) {
        String[] items = fridge.getItems();

        return items.length;
    }
}
