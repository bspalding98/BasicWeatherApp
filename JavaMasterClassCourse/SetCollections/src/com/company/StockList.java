package com.company;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();  // Sorting it in order of what it was inserted (insertion order). If wanted to change it to no a Linked HashMap to a normal HashMap. only need to change here because of good use of generics.
    }

    public int addStock(StockItem item) {
        if(item != null) {
            // Check if we already have quantities of this item
            StockItem inStock = list.getOrDefault(item.getName(), item);    // Get the item if it already exists in the map. If not use the item passed to the method.
            // If there are already stocks on this ite, adjust the quantity.
            if(inStock != item) item.adjustStock(inStock.quantityInStock());   // Passing in value of already existing items quantityStock value into new item to make the total.
            list.put(item.getName(), item); // If already exists the .put() will override the keys value to the new one, if not it will create a new one.
            return item.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if((inStock != null) && (quantity > 0)) return inStock.finaliseStock(quantity);
        return 0;
//        StockItem inStock = list.getOrDefault(item, null);  // Null means we didn't have it in stock to begin with pretty much
//        if((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity > 0)) {   // CHeck is greater than 0 because the user shouldn't have to input -10 for sales. just 10 sales
//            inStock.adjustStock(-quantity);
//            return quantity;
//        }
//        return 0;
    }

    public int reserveStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if((inStock != null) && (quantity > 0)) return inStock.reserveStock(quantity);
        return 0;
    }

    public int unreserveStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if((inStock != null) && (quantity > 0)) return inStock.unreserveStock(quantity);
        return 0;
    }

    public StockItem get(String key) {
        return this.list.get(key);
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for(Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
        // Stops from modifying the original list and adding new stuff to a copied one
        // EG.
            // THe directions game. Made a copy of the Map so we couldn't override the original one
            // However, then we could still add stuff to it which is still not good.
            // This prevents this.
        // pretty returns only a read-only view into the Map.
        // Also is faster because it doesn't need to make a copy.
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for(Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

//            s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: ";
//            s = s + itemValue + "\n";
//            s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: " +  // Pretty much writes each item in the list
//                    itemValue + "\n";

            // Either this way or the other way below for string formatting
//            s = String.format("%s. %s There are %d in stock. Value of items %.2f\n", s, stockItem, stockItem.quantityInStock(), itemValue);
            s = String.format("%s%s There are %4d in stock. Value of items %8.2f\n", s, stockItem, stockItem.quantityInStock(), itemValue);

            // Probably not a good idea to do above
            totalCost += itemValue;
        }
        return MessageFormat.format("{0}Total stock value: {1}", s, totalCost);
    }
}
