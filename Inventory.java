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

    public void removeProduct() {
        // Assuming `name` is the identifier for the product to remove
        Product productToRemove = null;   
        // Iterate over the list to find the product by name
        for (Product pro : products) {
            if (pro.getName().equals(name)) {
                productToRemove = pro;
                break;
            }
        }
        // If the product is found, remove it from the list
        if (productToRemove != null) {
            products.remove(productToRemove);
            System.out.println(productToRemove.getName() + " removed from inventory.");
        } else {
            System.out.println("Product not found.");
        }
        // Reset fields after removal
        name = "";
        price = 0.00;
        quantity = 0;
        expDate = "";
        // Optionally, display the updated inventory
        System.out.println(products.toString());
    }
    
    
}