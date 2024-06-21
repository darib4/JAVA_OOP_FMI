package exam.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public interface RandomCategorySupplier extends Supplier<List<Inventory>> {
    Random RANDOM  = new Random();
    private void updateType(Category type) {
        type.getSuppliers().removeAll(new ArrayList<>(type.getSuppliers()));
        int num = RANDOM.nextInt(5) + 1;

        for(int i = 1; i <= num; i++){
            type.getSuppliers().add(type.name() + "Supplier No. " + i);
        }

        int reorderQty = RANDOM.nextInt(10 * num) + 1;
        type.setReorderQty(reorderQty);
    }

    default List<Inventory> getRandomData(int howMany, int a, int b){
        List<Inventory> inventories = get();
        Category[] categories = Category.values();

        for(int i = 0; i < howMany; i++){
            Category randomCategory = categories[RANDOM.nextInt(categories.length)];
            double price = RANDOM.nextDouble(a, b + 1);
            updateType(randomCategory);
            Inventory inventory = new Inventory(randomCategory, price);
            inventories.add(inventory);
        }
        return inventories;
    }
}
