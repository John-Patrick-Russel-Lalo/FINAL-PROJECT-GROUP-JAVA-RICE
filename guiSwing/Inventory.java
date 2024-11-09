// Inventory.java
import java.util.ArrayList;

import java.util.List;

public class Inventory  {
    private List<Product> products;
    String name;
    double price;
    int quantity;
    String expDate = "11/12/2028";

    public Inventory() {
        products = new ArrayList<>();
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setExpiration(int Month, int Day, int Year){
        this.expDate = Integer.toString(Month) + "/" + Integer.toString(Day) + "/" + Integer.toString(Year);
    }

    public String displayName(){
        return this.name;
    }

    public String displayExpDate(){
        return expDate;
    }

    // Method to add a product to the inventory
    public void addProduct() {
        Product pro = new Product(name, price, quantity, expDate);
        products.add(pro);
        System.out.println(pro.getName() + " added to inventory.");
        System.out.println(products.toString()); // display all from list
        name = "";
        price = 0.00;
        quantity = 0;
        expDate = "";
    }

    

    
}
