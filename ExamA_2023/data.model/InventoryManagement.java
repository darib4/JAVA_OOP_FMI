package data.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InventoryManagement {
    private RandomCategorySupplier supplier;
    private List<Inventory> inventories;

    public InventoryManagement() {
        supplier = () -> new ArrayList<>();
        inventories = supplier.getRandomData(10, 10, 100);
    }

    public String showInventory(){
        return inventories.stream()
                .map(Inventory::toString)
                .collect(Collectors.joining("\n"));
    }

    public double averagePrice(){
        return inventories.stream()
                .mapToDouble(Inventory::getPrice)
                .average()
                .orElse(0.0);
    }

    public List<Inventory> sortInventoryTypeAndID(){
        return inventories.stream()
                .sorted(Comparator.comparing(Inventory::getCategory)
                        .thenComparing(Inventory::getINV_NUMBER))
                .collect(Collectors.toList());
    }

    public String findLargestPricePerCategory()
    {
        Map<Category, Inventory> maxPriceCategory = inventories.stream()
                .collect(Collectors.toMap(
                        Inventory::getCategory,
                        inventory -> inventory,
                        (inv1, inv2) -> inv1.getPrice()>inv2.getPrice()?inv1:inv2
                ));
        return maxPriceCategory.entrySet().stream()
                .map(entry -> entry.getKey().name() + "\n" + entry.getValue().toString())
                .collect(Collectors.joining("\n"));
    }
}
