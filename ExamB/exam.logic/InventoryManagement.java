package exam.logic;

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
                        .thenComparing(Comparator.comparing(Inventory::getID).reversed()))
                .collect(Collectors.toList());
    }

    public String findTotalPricePerCategory() {
        Map<Category, Double> totalPricePerCategory = inventories.stream()
                .collect(Collectors.groupingBy(
                        Inventory::getCategory,
                        Collectors.summingDouble(Inventory::getPrice)
                ));

        return totalPricePerCategory.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> String.format("%s: %.2f", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\n"));
    }
}
