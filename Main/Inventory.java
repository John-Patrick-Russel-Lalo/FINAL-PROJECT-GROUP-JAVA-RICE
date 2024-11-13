import java.util.ArrayList;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class Inventory  {
    
    private DefaultListModel<Product> listModel = new DefaultListModel<>();
    private JList<Product> products = new JList<>(listModel);
    

    String productName;
    double productPrice;
    int productQuantity;
    String productExpDate = "11/12/2028";

    public void setName(String name){
        this.productName = name;
    }

    public void setPrice(double price){
        this.productPrice = price;
    }

    public void setQuantity(int quantity){
        this.productQuantity = quantity;
    }

    public void setExpiration(int Month, int Day, int Year){
        this.productExpDate = Integer.toString(Month) + "/" + Integer.toString(Day) + "/" + Integer.toString(Year);
    }

    public String displayName(){
        return this.productName;
    }

    public String displayExpDate(){
        return productExpDate;
    }

    // Method to add a product to the inventory
    public void addProduct() {
        this.listModel.addElement(new Product(productName, productPrice, productQuantity, productExpDate));

        System.out.println(listModel.toString());
    }

    
    
}
