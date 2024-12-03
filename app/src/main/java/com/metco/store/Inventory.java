package com.metco.store;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Inventory  {
    
    DefaultListModel<Product> listModel = new DefaultListModel<>();
    JList<Product> products = new JList<>(listModel);
    connectDB connDB = new connectDB();
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

    public String displayName(){
        return this.productName;
    }

    public String displayExpDate(){
        return productExpDate;
    }


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

        products.sort(comparator);

        model.clear();
        for (Product product : products) {
            model.addElement(product);
        }
    }

    public List<Product> searchProducts(String query) {
        List<Product> filteredProducts = new ArrayList<>();
        for (int i = 0; i < listModel.getSize(); i++) {
            Product product = listModel.getElementAt(i);
            // Check if the query matches the product's name, price, quantity, or expiration date
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
        System.out.println(this.listModel.toString());

        Product newProduct = new Product(productID, productName, productPrice, productQuantity, productExpDate);

        String sql = "INSERT INTO METCOPRODUCTS (productName, productPrice, productQuantity, productExpDate) VALUES (?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = connectDB.connect();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, newProduct.getName());
            preparedStatement.setDouble(2, newProduct.getPrice());
            preparedStatement.setInt(3, newProduct.getQuantity());
            preparedStatement.setString(4, newProduct.getExpDate());

            preparedStatement.executeUpdate();
            loadProductsFromDatabase();

            System.out.println("Product added");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (preparedStatement != null){
                    connectDB.disconnect(connection);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }


        this.productID += 1;
    }

    public void removeProduct(int indexselect) {
        if (indexselect != -1) {
            Product productToRemove = listModel.getElementAt(indexselect);
            int productIDToRemove = productToRemove.getID();
    
            String sql = "DELETE FROM METCOPRODUCTS WHERE productID = ?";
            Connection connection = null;
            PreparedStatement preparedStatement = null;
    
            try {
                connection = connectDB.connect();
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, productIDToRemove);
                preparedStatement.executeUpdate();
                loadProductsFromDatabase();
    
                System.out.println("Product removed");
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (preparedStatement != null) {
                        connectDB.disconnect(connection);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        } else {
            System.out.println("The product has been already removed");
        }
    }

    public void updateProduct(int indexselect) {
        if (indexselect != -1) {
            Product productToUpdate = listModel.getElementAt(indexselect);
            int productIDToUpdate = productToUpdate.getID();
    
            StringBuilder sql = new StringBuilder("UPDATE METCOPRODUCTS SET ");
            List<Object> parameters = new ArrayList<>();
    
            // Check each field and append to the SQL statement if it's changed
            if (productName != null && !productName.isEmpty()) {
                sql.append("productName = ?, ");
                parameters.add(productName);
            }
            if (productPrice != null) {
                sql.append("productPrice = ?, ");
                parameters.add(productPrice);
            }
            if (productQuantity >= 0) {
                sql.append("productQuantity = ?, ");
                parameters.add(productQuantity);
            }
            if (productExpDate != null && !productExpDate.isEmpty()) {
                sql.append("productExpDate = ?, ");
                parameters.add(productExpDate);
            }
    
            if (parameters.size() > 0) {
                sql.setLength(sql.length() - 2);
                sql.append(" WHERE productID = ?");
                parameters.add(productIDToUpdate);
    
                Connection connection = null;
                PreparedStatement preparedStatement = null;
    
                try {
                    connection = connectDB.connect();
                    preparedStatement = connection.prepareStatement(sql.toString());
    
                    // Set the parameters
                    for (int i = 0; i < parameters.size(); i++) {
                        preparedStatement.setObject(i + 1, parameters.get(i));
                    }
    
                    preparedStatement.executeUpdate();
                    loadProductsFromDatabase(); // Reload products from database to reflect changes
    
                    System.out.println("Product updated");
                } catch (SQLException e) {
                    System.out.println(e);
                } finally {
                    try {
                        if (preparedStatement != null) {
                            preparedStatement.close();
                        }
                        if (connection != null) {
                            connectDB.disconnect(connection);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("No fields to update.");
            }
        } else {
            System.out.println("No product selected for update.");
        }
    }

    public void loadProductsFromDatabase(){
        String sql = "SELECT * FROM METCOPRODUCTS";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet	= null;

        try {
            connection = connectDB.connect();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            listModel.clear();

            while (resultSet.next()){
                int id = resultSet.getInt("productID");
                String name = resultSet.getString("productName");
                double price = resultSet.getDouble("productPrice");
                int quantity = resultSet.getInt("productQuantity");
                String expDate = resultSet.getString("productExpDate");

                Product product = new Product(id, name, price, quantity, expDate);
                listModel.addElement(product);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    
    @SuppressWarnings("rawtypes")
    public DefaultListModel getListModel(){
        return listModel;
    }
    
}
