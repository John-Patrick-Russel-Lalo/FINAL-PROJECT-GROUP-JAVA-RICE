package com.metco.store;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Inventory  {
    
    DefaultListModel<Product> listModel = new DefaultListModel<>();
    JList<Product> products = new JList<>(listModel);
    
    int productID;
    
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

    // public void setID(){
    //     this.productID = productID;
    // }

    public String displayName(){
        return this.productName;
    }

    public String displayExpDate(){
        return productExpDate;
    }


    // sort functions

    public void sortName(){
        sortModel(listModel, Comparator.comparing(p -> p.getName()));
    }

    public void sortPrice(){
        sortModel(listModel, Comparator.comparingDouble(p -> p.getPrice()));
    }

    public void sortQuantity(){
        sortModel(listModel, Comparator.comparingInt(p -> p.getQuantity()));
    }

    public void sortExpDate(){
        sortModel(listModel, Comparator.comparing(p -> p.getExpDate()));
    }


    private static void sortModel(DefaultListModel<Product> model, Comparator<Product> comparator){
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < model.getSize(); i++) {
            products.add(model.getElementAt(i));
        }

        // Sort the list
        products.sort(comparator);

        // Clear and repopulate the model
        model.clear();
        for (Product product : products) {
            model.addElement(product);
        }
    }

    public List<Product> searchProducts(String query) {
        List<Product> filteredProducts = new ArrayList<>();
        for (int i = 0; i < listModel.getSize(); i++) {
            Product product = listModel.getElementAt(i);
            if (product.getName().toLowerCase().contains(query.toLowerCase()) ||
                String.valueOf(product.getPrice()).contains(query) ||
                String.valueOf(product.getQuantity()).contains(query) ||
                product.getExpDate().contains(query)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    
    // management functions
    

    
    public void addProduct() {
        this.listModel.addElement(new Product(productID, productName, productPrice, productQuantity, productExpDate));
        System.out.println(this.listModel.toString());

        this.productID += 1;
    }

    public void removeProduct(int indexselect){
        if (indexselect != -1) {

            int confirm = JOptionPane.showConfirmDialog( null, "Are you sure you want to remove the current selected product?");
            if(confirm == 0){
                this.listModel.remove(indexselect);
                products.clearSelection();
            }else {
                products.clearSelection();
            }

        } else {
            System.out.println("The product has been already remove");
        }
        System.out.println(this.listModel.toString());
    }

    public void updateProduct(int indexselect){

        System.out.println(indexselect);
        
        try {
            if(indexselect != -1){

                String newProductName = productName;
                String newProductPrice = String.valueOf(productPrice);
                String newProductQuantity = String.valueOf(productQuantity);

                if(!newProductName.isEmpty()){
                    System.out.println("yey name");
                }
                if(!newProductPrice.isEmpty()){
                    System.out.println("yey price");
                }
                if(!newProductQuantity.isEmpty()){
                    System.out.println("yey wuantity");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selected Product Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            
        }
    }

    @SuppressWarnings("rawtypes")
    public DefaultListModel getListModel(){
        return listModel;
    }


    // SQL CONNECTOR //

    private static final String URL = "jdbc:mysql://localhost:3306/testdb"; // Replace with your database URL
    private static final String USER = "root"; // Replace with your MySQL username
    private static final String PASSWORD = "@Bsubalayan2024"; // Replace with your MySQL password

    /**
     * Establishes a connection to the MySQL database.
     * 
     * @return Connection object or null if the connection fails
     */
    public static Connection connect() {
        Connection connection = null;
        try {
            // Load MySQL JDBC driver (optional for newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database!");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        
        return connection;
    }

    /**
     * Closes the database connection.
     * 
     * @param connection The connection object to close
     */
    public static void disconnect(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                System.out.println("Failed to close the connection.");
                e.printStackTrace();
            }
        }
    }

    
    
}
