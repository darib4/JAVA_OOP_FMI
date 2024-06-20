package data.model;

import java.util.ArrayList;
import java.util.List;

public enum Category {
    A(0, new ArrayList<>()),
    B(0, new ArrayList<>()),
    C(0, new ArrayList<>()),
    D(0, new ArrayList<>());


    private int reorderQty;
    private List<String> suppliers;

    Category(int reorderQty, List<String> suppliers) {
        setReorderQty(reorderQty);
        setSuppliers(suppliers);
    }

    public int getReorderQty() {
        return reorderQty;
    }

    public void setReorderQty(int reorderQty) {
        this.reorderQty = reorderQty;
    }

    public List<String> getSuppliers() {
        if (suppliers == null) {
            suppliers = new ArrayList<>();
        }
        return suppliers;
    }

    //тернарен оператор
    public void setSuppliers(List<String> suppliers) {
        if(suppliers != null && !suppliers.isEmpty()){
            this.suppliers = suppliers;
        }
    }
}
