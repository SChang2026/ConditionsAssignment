
/*Write a program (project) called "MyStore"

After the public Class MyStore, add another class called "Item"

Give the Item Class variables strName and dblPrice.

Items: T Shirt - 29.99, Shoes - 125.99, Jeans - 60.99, Jacket - 250.00, Hat - 25.99, Shorts - 75.99, Blouse - 88.99

Create a toString method that return the name and price (e.g. "Item: Shoes, Price: 125.99")

Add getters and setters to set/return both variables

in the MyStore controlling main method, set a colnstant variable MAX_BUDGET to $250.00

Ask the user to enter items. If they enter "T Shirt" or whatever, get the price for that item. Add each item's price to a total, and increment a count.

After each entry, let them know the count and how much they've spent so far. Set conditional statements so that they cannot go over budget (give a warning if they go over budget).

You can use a while(true) loop for this.

package com.mycompany.conditionsassignment;

/**
 *
 * @author SChang2026
 */

package com.mycompany.conditionsassignment;

import java.util.Scanner;
import java.util.ArrayList;

public class ConditionsAssignment {
    public static void main(String[] args) {
        final double MAX_BUDGET = 250.00;
        double totalSpent = 0.0;
        int itemCount = 0;
        
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("T Shirt", 29.99));
        items.add(new Item("Shoes", 125.99));
        items.add(new Item("Jeans", 60.99));
        items.add(new Item("Jacket", 250.00));
        items.add(new Item("Hat", 25.99));
        items.add(new Item("Shorts", 75.99));
        items.add(new Item("Blouse", 88.99));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter an item name (or type 'exit' to stop): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            boolean itemFound = false;
            for (Item item : items) {
                if (item.getStrName().equalsIgnoreCase(input)) {
                    double price = item.getDbPrice();
                    if (totalSpent + price > MAX_BUDGET) {
                        System.out.println("Warning: Adding this item would exceed your budget of $" + MAX_BUDGET);
                        continue;
                    }
                    totalSpent += price;
                    itemCount++;
                    System.out.println("Added: " + item + " | Total items: " + itemCount + " | Total spent: $" + totalSpent);
                    itemFound = true;
                    break;
                }
            }

            if (!itemFound) {
                System.out.println("Item not found. Please enter a valid item.");
            }
        }

        System.out.println("Final count of items: " + itemCount);
        System.out.println("Total amount spent: $" + totalSpent);
    }
}

class Item {
    private String strName;
    private double dblPrice;

    public Item(String strName, double dblPrice) {
        this.strName = strName;
        this.dblPrice = dblPrice;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public double getDbPrice() {
        return dblPrice;
    }

    public void setDbPrice(double dbPrice) {
        this.dblPrice = dbPrice;
    }

    @Override
    public String toString() {
        return "Item: " + strName + ", Price: $" + dblPrice;
    }
}
