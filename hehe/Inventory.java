import java.util.ArrayList;

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

    public void setID(){
        this.productIDTemp++;
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

    public void updateProduct(int indexselect){
        if (indexselect != -1){

            this.listModel.setElementAt(new Product(productIDTemp, productName, productPrice, productQuantity, productExpDate), indexselect);
        } else {

        }
    }




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
