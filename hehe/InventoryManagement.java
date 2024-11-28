

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

import org.jdesktop.swingx.prompt.PromptSupport;



public class InventoryManagement extends javax.swing.JFrame {

    
    Inventory inventory = new Inventory();
    DefaultListModel<Product> ListModel = inventory.listModel;
    JListRenderer jlistrender = new JListRenderer();
    componentsGUI GUI = new componentsGUI(inventory);

    
    public InventoryManagement() {

        
        
        
        String invPHSearch = "Search Product";
        String invPHName = "Product Name";
        String invPHPrice = "Product Price";
        String invPHQuantity = "Product Quantity";
        String invPHMonth = "Expire Month";
        String invPHDay = "Expire Day";
        String invPHYear = "Expire Year";

        inventory.test();

        


        GUI.inventoryName.validate();

        
        PromptSupport.setPrompt(invPHName, GUI.inventoryName);
        PromptSupport.setPrompt(invPHPrice, GUI.inventoryPrice);
        PromptSupport.setPrompt(invPHQuantity, GUI.inventoryQuantity);
        PromptSupport.setPrompt(invPHMonth, GUI.inventoryMonth);
        PromptSupport.setPrompt(invPHDay, GUI.inventoryDay);
        PromptSupport.setPrompt(invPHYear, GUI.inventoryYear);

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

                if(selected == 0){
                    sortName();
                    
                } else if(selected == 1){
                    sortPrice();

                } else if(selected == 2){
                    sortQuantity();

                }
            }
            
        });
        
        
        // JList Components

        GUI.ListProducts.setCellRenderer(jlistrender);

        
        
        
        
    } //constructor ends here



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

    public void updateProducts(){
        String productName = GUI.inventoryName.getText().trim();
        Double productPrice = Double.parseDouble(GUI.inventoryPrice.getText().trim());
        int productQuantity = Integer.parseInt(GUI.inventoryQuantity.getText().trim());
        String productMonth = GUI.inventoryMonth.getText().trim();
        String productDay = GUI.inventoryDay.getText().trim();
        String productYear = GUI.inventoryYear.getText().trim();
        int selectedProduct = GUI.ListProducts.getSelectedIndex();
        

        inventory.setName(productName);
        inventory.setPrice(productPrice);
        inventory.setQuantity(productQuantity);
        inventory.setExpiration(productMonth, productDay, productYear);
        
        inventory.updateProduct(selectedProduct);

        GUI.inventoryName.setText("");
        GUI.inventoryPrice.setText("");
        GUI.inventoryQuantity.setText("");
        GUI.inventoryMonth.setText("");
        GUI.inventoryDay.setText("");
        GUI.inventoryYear.setText("");

    }

    public void removeProducts(){
        int selectedProduct = GUI.ListProducts.getSelectedIndex();

        inventory.removeProduct(selectedProduct);


        GUI.inventoryName.setText("");
        GUI.inventoryPrice.setText("");
        GUI.inventoryQuantity.setText("");
        GUI.inventoryMonth.setText("");
        GUI.inventoryDay.setText("");
        GUI.inventoryYear.setText("");
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
