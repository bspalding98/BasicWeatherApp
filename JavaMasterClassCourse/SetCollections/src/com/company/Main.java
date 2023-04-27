package com.company;

import java.util.Map;

public class Main {
    // HashMap and HashSet are both chaotic in order, meaning they are random.
    // LinkedHashmap
    // LinkedHashSet
    // THey are pretty much sorted set and map.
        // Also called sorted collections

    private static StockList stockList = new StockList();

    public static void main(String[] args) {

        StockItem temp = new StockItem("Bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("Cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("Car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("Chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("Cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("Cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("Door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("Juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("Phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("Towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("Vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for(String s : stockList.Items().keySet()) {
            System.out.println(s);
        }

        Basket boydsBacket = new Basket("Boyd");

        sellItem(boydsBacket, "Car", 1);
        System.out.println(boydsBacket);

        sellItem(boydsBacket, "Car", 1);
        System.out.println(boydsBacket);

        sellItem(boydsBacket, "Car", 1);
        sellItem(boydsBacket, "Spanner", 5);
//        System.out.println(boydsBacket);

        sellItem(boydsBacket, "Juice", 4);
        sellItem(boydsBacket, "Cup", 12);
        sellItem(boydsBacket, "Bread", 1);
//        System.out.println(boydsBacket);

//        System.out.println(stockList);

        Basket basket = new Basket("Customer");
        sellItem(basket, "Cup", 100);
        sellItem(basket, "Juice", 5);
        removeItem(basket, "Cup", 1);
        System.out.println(basket);

        removeItem(boydsBacket, "Car", 1);
        removeItem(boydsBacket, "Cup", 9);
        removeItem(boydsBacket, "Car", 1);
        System.out.println(" cars remove: " + removeItem(boydsBacket, "Car", 1));   // Sdhould not remove any

        System.out.println(boydsBacket);

        // remove all items boydsBasket
        removeItem(boydsBacket, "Bread", 1);
        removeItem(boydsBacket, "Cup", 3);
        removeItem(boydsBacket, "Juice", 4);
        removeItem(boydsBacket, "Cup", 3);
        System.out.println(boydsBacket);

        System.out.println("\n Display stock list before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println("==============================================");
        System.out.println(basket);
        System.out.println(stockList);

//        temp = new StockItem("Pen", 1.12);
//        stockList.Items().put(temp.getName(), temp);    // Error because it cannot be modified.

        stockList.Items().get("Car").adjustStock(2000); // Even though unmodifiable map is called. Still could change stock values, etc. (an individual item)
        System.out.println(stockList);
        // Having access to the objects in this particular situation isn't bad because you still can only do what you already could anyways.
        // However, is the stockList did not have a getList. Then you wouldn't want anything else to be able to do that.

        // Can use other things other than unmodifiable collection
        // Like the for loop we have used earlier and can be seen below.
//        for(Map.Entry<String, Double> price : stockList.PriceList().entrySet()) {
//            System.out.println(String.format("%-6s costs %5.2f", price.getKey(), price.getValue()));
//        }

        checkOut(boydsBacket);
        System.out.println(boydsBacket);
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }
        System.out.println("We have no " + item + " in stock");
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        // remove the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);
        }
        System.out.println("We have no " + item + " in stock");
        return 0;
    }

    public static void checkOut(Basket basket) {
        for(Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}
