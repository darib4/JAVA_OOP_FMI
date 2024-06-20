package data.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public interface RandomCategorySupplier extends Supplier<List<Inventory>> {
    Random generator = CanRandomize.RAND.GENERATOR;
    private void updateType(Category type) {
        type.getSuppliers().removeAll(new ArrayList<>(type.getSuppliers()));

        int num = generator.nextInt(4) + 1;

        for(int i = 1; i <= num; i++){
            type.getSuppliers().add(type.name() + "Supplier No. " + i);
        }
        int reorderQty = generator.nextInt(10 * num) + 1;
        type.setReorderQty(reorderQty);
    }

    default List<Inventory> getRandomData(int howMany, int a, int b){
        List<Inventory> inventories = get();
        Category[] categories = Category.values();

        for(int i = 0;i < howMany; i++){
            Category newCategory = categories[generator.nextInt(categories.length)];
            double price = generator.nextDouble(a, b + 1);
            Inventory inventory = new Inventory(newCategory, price);
            updateType(newCategory);
            inventories.add(inventory);
        }
        return inventories;
    }
}
