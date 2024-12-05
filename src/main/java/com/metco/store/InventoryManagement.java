package com.metco.store;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.metco.componentsDesign.ComponentsGUI;

public class InventoryManagement extends Inventory{

    
    //Inventory = new Inventory();
    DefaultListModel<Product> ListModel = listModel;
    ComponentsGUI GUI = new ComponentsGUI(this);

    
    public InventoryManagement() {

        
        
        
        

        loadProductsFromDatabase();
        updateProductList();


        GUI.inventoryName.validate();
        
        

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
                        sortName();
                        break;
                    case 1: // Sort by Price
                        sortPrice();
                        break;
                    case 2: // Sort by Quantity
                        sortQuantity();
                        break;
                    case 3: // Sort by Expiration Date
                        sortExpDate();
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
                        sortName();
                        break;
                    case 1: // Sort by Price
                        sortPrice();
                        break;
                    case 2: // Sort by Quantity
                        sortQuantity();
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
    
        for (int i = 0; i < getListModel().getSize(); i++) {
            Product product = listModel.getElementAt(i);
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
        DefaultListModel<Product> model = getListModel();
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
        
        setName(productName);
        setPrice(productPrice);
        setQuantity(productQuantity);
        setExpiration(productMonth, productDay, productYear);
        
        addProduct();

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
                setExpiration(productMonth, productDay, productYear);
            }
        
            // Set values only if they are provided
            setName(productName);
            if (productPrice != null) {
                setPrice(productPrice);
            }
            if (productQuantity != -1) {
                setQuantity(productQuantity);
            }
        
            updateProduct(selectedProductIndex); // Update the specific product
        
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
            removeProduct(selectedProductIndex); // Remove the specific product
        
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
        sortName();
    }

    public void sortPrice(){
        sortPrice();
    }

    public void sortQuantity(){
        sortQuantity();
    }

    public void sortExpDate(){
        sortExpDate();
    }
   

    
    

    

    
    

}
