package exam.logic;

public class Inventory {
    private int idCount = 0;
    private final String ID;
    private Category category;
    private double price;
    private final String description;

    public Inventory(Category category, double price) {
        ID = String.valueOf(idCount++);
        setCategory(category);
        setPrice(price);
        description = "Product-" + ID;
    }

    public String getID() {
        return ID;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if(category != null){
            this.category = category;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price > 0){
            this.price = price;
        }
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("Product: %s\nCategory: %s\nPrice: %.2f\nSuppliers: %s\n",
                ID, category.name(), price, category.getSuppliers());
    }
}
