package com.company;

// To make a basket we need something to track the quantities of customers taking items
// We can't just have fields for each customer as there could be thousands.
//Instead we can make a MAP which would be a better option.
// Key in the Map and value is quantity purchased.
public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock;      // Can initialise here
    private int reserved = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;     // or here (but you wouldn't normally do both) - better here if you have another stock item below.
        // Then item can be created with or without stock levels.
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock - reserved;
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if(newQuantity >= 0) this.quantityStock = newQuantity;
    }

    public int reserveStock(int quantity) {
        if(quantity <= quantityInStock()) { // Use the method no the field
            reserved += quantity;
            return quantity;
        }
        return 0;
    }

    public int unreserveStock(int quantity) {
        if(quantity <= reserved) {
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    public int finaliseStock(int quantity) {
        if(quantity <= reserved) {
            quantityStock -= quantity;
            reserved -= quantity;
            return quantity;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering stockItem.equals");
        if(obj == this) return true;
        if((obj == null) || (obj.getClass() != this.getClass())) return false;
        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
//        System.out.println("Entering StockItem.compareTo");
        if(this == o) return 0;
        if(o != null) return this.name.compareTo(o.getName());
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return String.format("%-5s: price %5.2f. Reserved: %3d", this.name, this.price, this.reserved);
    }
}
