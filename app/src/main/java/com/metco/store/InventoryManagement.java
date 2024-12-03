package com.metco.store;


import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.jdesktop.swingx.prompt.*;

import org.jdesktop.swingx.prompt.PromptSupport;

public class InventoryManagement {

    
    Inventory inventory = new Inventory();
    DefaultListModel<Product> ListModel = inventory.listModel;
    ComponentsGUI GUI = new ComponentsGUI(inventory);

    
    public InventoryManagement() {

        
        
        
        String invPHSearch = "Search Product";
        String invPHName = "Product Name";
        String invPHPrice = "Product Price";
        String invPHQuantity = "Product Quantity";
        String invPHMonth = "Expire Month";
        String invPHDay = "Expire Day";
        String invPHYear = "Expire Year";

        inventory.loadProductsFromDatabase();
        updateProductList();


        GUI.inventoryName.validate();

        
        PromptSupport.setPrompt(invPHName, GUI.inventoryName);
        PromptSupport.setPrompt(invPHPrice, GUI.inventoryPrice);
        PromptSupport.setPrompt(invPHQuantity, GUI.inventoryQuantity);
        PromptSupport.setPrompt(invPHMonth, GUI.inventoryMonth);
        PromptSupport.setPrompt(invPHDay, GUI.inventoryDay);
        PromptSupport.setPrompt(invPHYear, GUI.inventoryYear);
        PromptSupport.setPrompt(invPHSearch, GUI.searchBar);

        Color promptColor = new Color(150, 150, 150); // Light gray color for prompts
        PromptSupport.setForeground(promptColor, GUI.inventoryName);
        PromptSupport.setForeground(promptColor, GUI.inventoryPrice);
        PromptSupport.setForeground(promptColor, GUI.inventoryQuantity);
        PromptSupport.setForeground(promptColor, GUI.inventoryMonth);
        PromptSupport.setForeground(promptColor, GUI.inventoryDay);
        PromptSupport.setForeground(promptColor, GUI.inventoryYear);
        PromptSupport.setForeground(promptColor, GUI.searchBar);

        

        GUI.inventoryName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI.inventoryPrice.requestFocus();
            }
        });

        GUI.inventoryPrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI.inventoryQuantity.requestFocus();
            }
        });

        GUI.inventoryQuantity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI.inventoryMonth.requestFocus();
            }
        });

        GUI.inventoryMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI.inventoryDay.requestFocus();
            }
        });

        GUI.inventoryDay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI.inventoryYear.requestFocus();
            }
        });
        
        
        
        // Btns Functions

        GUI.addBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addProducts();
            }
        });

        GUI.updateBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                updateProducts();
            }
        });

        GUI.removeBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                removeProducts();
            }
        });
        
        //ComboBox

        GUI.sortBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = GUI.sortBox.getSelectedIndex();
                switch (selected) {
                    case 0: // Sort by Name
                        inventory.sortName();
                        break;
                    case 1: // Sort by Price
                        inventory.sortPrice();
                        break;
                    case 2: // Sort by Quantity
                        inventory.sortQuantity();
                        break;
                    case 3: // Sort by Expiration Date
                        inventory.sortExpDate();
                        break;
                }
                // Update the JList after sorting
                updateProductList();
            }
        });

        

        GUI.searchBar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterProducts(GUI.searchBar.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterProducts(GUI.searchBar.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Not needed for plain text components
            }
        });

        GUI.sortBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = GUI.sortBox.getSelectedIndex();
                switch (selected) {
                    case 0: // Sort by Name
                        inventory.sortName();
                        break;
                    case 1: // Sort by Price
                        inventory .sortPrice();
                        break;
                    case 2: // Sort by Quantity
                        inventory.sortQuantity();
                        break;
                }
                updateProductList(); // Refresh the product list after sorting
            }
        });

        GUI.updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProducts();
            }
        });
        
        GUI.removeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeProducts();
            }
        });

        
        
        
        
    } //constructor ends here

    
        
     


    private void filterProducts(String query) {
        DefaultListModel<Product> model = new DefaultListModel<>();
    
        for (int i = 0; i < inventory.getListModel().getSize(); i++) {
            Product product = inventory.listModel.getElementAt(i);
            if (product.getName().toLowerCase().contains(query.toLowerCase()) ||
                String.valueOf(product.getPrice()).contains(query) ||
                String.valueOf(product.getQuantity()).contains(query) ||
                product.getExpDate().contains(query)) {
                model.addElement(product);
            }
        }
    
        GUI.listProducts.setModel(model);
        GUI.listProducts.revalidate();
        GUI.listProducts.repaint();
    }


    private void updateProductList() {
        @SuppressWarnings("unchecked")
        DefaultListModel<Product> model = inventory.getListModel();
        GUI.listProducts.setModel(model);
        GUI.listProducts.revalidate();
        GUI.listProducts.repaint();
    }



    // input functions

    

    // button functions
    
    public void addProducts(){
        String productName = GUI.inventoryName.getText();
        Double productPrice = Double.parseDouble(GUI.inventoryPrice.getText());
        int productQuantity = Integer.parseInt(GUI.inventoryQuantity.getText());
        String productMonth = GUI.inventoryMonth.getText();
        String productDay = GUI.inventoryDay.getText();
        String productYear = GUI.inventoryYear.getText();
        
        inventory.setName(productName);
        inventory.setPrice(productPrice);
        inventory.setQuantity(productQuantity);
        inventory.setExpiration(productMonth, productDay, productYear);
        
        inventory.addProduct();

        GUI.inventoryName.setText("");
        GUI.inventoryPrice.setText("");
        GUI.inventoryQuantity.setText("");
        GUI.inventoryMonth.setText("");
        GUI.inventoryDay.setText("");
        GUI.inventoryYear.setText("");
        
    }

    public void updateProducts() {
        int selectedProductIndex = GUI.listProducts.getSelectedIndex();
        
        if (selectedProductIndex != -1) { // Check if a product is selected
            String productName = GUI.inventoryName.getText().trim();
            Double productPrice = null; // Initialize as null
            int productQuantity = -1; // Use -1 or any invalid value to indicate not set
            String productMonth = GUI.inventoryMonth.getText().trim();
            String productDay = GUI.inventoryDay.getText().trim();
            String productYear = GUI.inventoryYear.getText().trim();
        
            // Check if price is not empty and parse it
            if (!GUI.inventoryPrice.getText().trim().isEmpty()) {
                productPrice = Double.parseDouble(GUI.inventoryPrice.getText().trim());
            }
        
            // Check if quantity is not empty and parse it
            if (!GUI.inventoryQuantity.getText().trim().isEmpty()) {
                productQuantity = Integer.parseInt(GUI.inventoryQuantity.getText().trim());
            }
        
            // Set expiration date only if not empty
            if (!productMonth.isEmpty() || !productDay.isEmpty() || !productYear.isEmpty()) {
                inventory.setExpiration(productMonth, productDay, productYear);
            }
        
            // Set values only if they are provided
            inventory.setName(productName);
            if (productPrice != null) {
                inventory.setPrice(productPrice);
            }
            if (productQuantity != -1) {
                inventory.setQuantity(productQuantity);
            }
        
            inventory.updateProduct(selectedProductIndex); // Update the specific product
        
            // Clear the input fields after update
            clearInputFields();
        
            // Refresh the product list
            updateProductList();
        } else {
            System.out.println("No product selected for update.");
        }
    }
    
    public void removeProducts() {
        int selectedProductIndex = GUI.listProducts.getSelectedIndex();
        
        if (selectedProductIndex != -1) { // Check if a product is selected
            inventory.removeProduct(selectedProductIndex); // Remove the specific product
        
            // Clear the input fields after deletion
            clearInputFields();
        
            // Refresh the product list
            updateProductList();
        } else {
            System.out.println("No product selected for removal.");
        }
    }
    
    private void clearInputFields() {
        GUI.inventoryName.setText("");
        GUI.inventoryPrice.setText("");
        GUI.inventoryQuantity.setText("");
        GUI.inventoryMonth.setText("");
        GUI.inventoryDay.setText("");
        GUI.inventoryYear.setText("");
        GUI.searchBar.setText("");
    }


    // SORTING FUNCTIONS

    
    public void sortName(){
        inventory.sortName();
    }

    public void sortPrice(){
        inventory.sortPrice();
    }

    public void sortQuantity(){
        inventory.sortQuantity();
    }

    public void sortExpDate(){
        inventory.sortExpDate();
    }
   

    
    

    

    
    

}
