import java.util.ArrayList;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Inventory  {
    
    DefaultListModel<Product> listModel = new DefaultListModel<>();
    JList<Product> products = new JList<>(listModel);
    
    int productID;
    int productIDTemp = 0;
    String productName;
    Double productPrice;
    int productQuantity;
    String productExpDate;

    public void setName(String name){
        this.productName = name;
    }

    public void setPrice(double price){
        this.productPrice = price;
    }

    public void setQuantity(int quantity){
        this.productQuantity = quantity;
    }

    public void setExpiration(String Month, String Day, String Year){
        this.productExpDate = Month + "/" + Day + "/" + Year;
    }

    public void setID(int ID){
        this.productIDTemp = ID;
    }

    public String displayName(){
        return this.productName;
    }

    public String displayExpDate(){
        return productExpDate;
    }

    

    // Method to add a product to the inventory
    public void addProduct() {
        this.listModel.addElement(new Product(productID, productName, productPrice, productQuantity, productExpDate));
        System.out.println(this.listModel.toString());

        this.productID += 1;
    }

    public void removeProduct(int indexselect){
        if (indexselect != -1) {
            this.listModel.remove(indexselect);
        } else {
            System.out.println("The product has been already remove");
        }
        System.out.println(this.listModel.toString());
    }

    public void updateProduct(){
        Product pro = this.listModel.getElementAt(productIDTemp);
        this.listModel.setElementAt(pro, productIDTemp);
    }

    
    
}
