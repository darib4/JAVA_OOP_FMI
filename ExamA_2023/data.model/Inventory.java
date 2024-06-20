package data.model;

import java.security.InvalidParameterException;

public class Inventory {
    private int idCount = 0;
    private final String INV_NUMBER;
    private Category category;
    private double price;
    private final String description;


    public Inventory(Category category, double price) {
        INV_NUMBER = String.valueOf(idCount++);
        setCategory(category);
        setPrice(price);
        description = "Product-" + INV_NUMBER;
    }

    public String getINV_NUMBER() {
        return INV_NUMBER;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        if(category != null){
            this.category = category;
        }

//        if(category == null){
//            throw new InvalidParameterException();
//        } else {
//            this.category = category;
//        }
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
                INV_NUMBER, category.name(), price, category.getSuppliers());
    }
}
