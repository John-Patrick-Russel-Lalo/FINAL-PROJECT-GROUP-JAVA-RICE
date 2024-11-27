/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author rass
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class InventoryManagementGUI extends javax.swing.JFrame {

    /**
     * Creates new form testGUI
     */
 
    
    Inventory inventory = new Inventory();
    DefaultListModel<Product> ListModel = inventory.listModel;
    JListRenderer jlistrender = new JListRenderer();

    
    public InventoryManagementGUI() {

        
        
        initComponents();
        String invPHSearch = "Search Product";
        String invPHName = "Product Name";
        String invPHPrice = "Product Price";
        String invPHQuantity = "Product Quantity";
        String invPHMonth = "Expire Month";
        String invPHDay = "Expire Day";
        String invPHYear = "Expire Year";


        inventoryName.validate();

        inventorySearch.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (inventorySearch.getText().equals(invPHSearch)) {
                inventorySearch.setText("");
                inventorySearch.setForeground(Color.WHITE);
            }
        }

        @Override
        public void focusLost(java.awt.event.FocusEvent evt) {
            if (inventorySearch.getText().isEmpty()) {
                inventorySearch.setText(invPHSearch);
                inventorySearch.setForeground(Color.lightGray);
            }
        }
    });
        inventoryName.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (inventoryName.getText().equals(invPHName)) {
                    inventoryName.setText("");
                    inventoryName.setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (inventoryName.getText().isEmpty()) {
                    inventoryName.setText(invPHName);
                    inventoryName.setForeground(Color.lightGray);
                }
            }
        });
        inventoryPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (inventoryPrice.getText().equals(invPHPrice)) {
                    inventoryPrice.setText("");
                    inventoryPrice.setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (inventoryPrice.getText().isEmpty()) {
                    inventoryPrice.setText(invPHPrice);
                    inventoryPrice.setForeground(Color.lightGray);
                }
            }
        });
        inventoryQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (inventoryQuantity.getText().equals(invPHQuantity)) {
                    inventoryQuantity.setText("");
                    inventoryQuantity.setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (inventoryQuantity.getText().isEmpty()) {
                    inventoryQuantity.setText(invPHQuantity);
                    inventoryQuantity.setForeground(Color.lightGray);
                }
            }
        });
        inventoryMonth.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (inventoryMonth.getText().equals(invPHMonth)) {
                    inventoryMonth.setText("");
                    inventoryMonth.setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (inventoryMonth.getText().isEmpty()) {
                    inventoryMonth.setText(invPHMonth);
                    inventoryMonth.setForeground(Color.lightGray);
                }
            }
        });
        inventoryDay.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (inventoryDay.getText().equals(invPHDay)) {
                    inventoryDay.setText("");
                    inventoryDay.setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (inventoryDay.getText().isEmpty()) {
                    inventoryDay.setText(invPHDay);
                    inventoryDay.setForeground(Color.lightGray);
                }
            }
        });
        inventoryYear.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (inventoryYear.getText().equals(invPHYear)) {
                    inventoryYear.setText("");
                    inventoryYear.setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (inventoryYear.getText().isEmpty()) {
                    inventoryYear.setText(invPHYear);
                    inventoryYear.setForeground(Color.lightGray);
                }
            }
        });
        
        
        
        // Btns Functions

        addBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addProducts();
            }
        });

        updateBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                updateProducts();
            }
        });

        removeBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                removeProducts();
            }
        });
        
        //ComboBox

        sortBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int selected = sortBox.getSelectedIndex();

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

        ListProducts.setCellRenderer(jlistrender);
        
        
        
    } //constructor ends here



    // input functions

    

    // button functions
    
    public void addProducts(){
        String productName = inventoryName.getText();
        Double productPrice = Double.parseDouble(inventoryPrice.getText());
        int productQuantity = Integer.parseInt(inventoryQuantity.getText());
        String productMonth = inventoryMonth.getText();
        String productDay = inventoryDay.getText();
        String productYear = inventoryYear.getText();
        
        inventory.setName(productName);
        inventory.setPrice(productPrice);
        inventory.setQuantity(productQuantity);
        inventory.setExpiration(productMonth, productDay, productYear);
        
        inventory.addProduct();
        
    }

    public void updateProducts(){
        String productName = inventoryName.getText();
        Double productPrice = Double.parseDouble(inventoryPrice.getText());
        int productQuantity = Integer.parseInt(inventoryQuantity.getText());
        String productMonth = inventoryMonth.getText();
        String productDay = inventoryDay.getText();
        String productYear = inventoryYear.getText();
        int selectedProduct = ListProducts.getSelectedIndex();

        inventory.setName(productName);
        inventory.setPrice(productPrice);
        inventory.setQuantity(productQuantity);
        inventory.setExpiration(productMonth, productDay, productYear);
        
        inventory.updateProduct(selectedProduct);

    }

    public void removeProducts(){
        int selectedProduct = ListProducts.getSelectedIndex();

        inventory.removeProduct(selectedProduct);
    }


    // SORTING FUNCTIONS

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

    public void sortName(){
        System.out.println(inventory.listModel.toString());
        sortModel(ListModel, Comparator.comparing(Product -> Product.getName()));
    }

    public void sortPrice(){
        sortModel(ListModel, Comparator.comparingDouble(p -> p.getPrice()));
    }

    public void sortQuantity(){
        sortModel(ListModel, Comparator.comparingInt(p -> p.getQuantity()));
    }

    public void sortExpDate(){

    }
   


    

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    public void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        inventoryName = new javax.swing.JTextField();
        inventoryPrice = new javax.swing.JTextField();
        inventoryQuantity = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        inventoryMonth = new javax.swing.JTextField();
        inventoryDay = new javax.swing.JTextField();
        inventoryYear = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        inventorySearch = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListProducts = new javax.swing.JList<>(inventory.listModel);
        sortBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(500, 500));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 500));

        jSplitPane1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(255, 204, 0));

        jPanel4.setBackground(new java.awt.Color(255, 204, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 5, true), "Product Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans Condensed", 1, 13), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel4.setMinimumSize(new java.awt.Dimension(300, 200));
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 242));

        jPanel6.setBackground(new java.awt.Color(255, 204, 51));

        jPanel10.setBackground(new java.awt.Color(255, 204, 51));

        inventoryName.setBackground(new java.awt.Color(51, 51, 51));
        inventoryName.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        inventoryName.setForeground(java.awt.Color.lightGray);
        inventoryName.setText("Product Name");
        inventoryName.setPreferredSize(new java.awt.Dimension(110, 23));

        inventoryPrice.setBackground(new java.awt.Color(51, 51, 51));
        inventoryPrice.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        inventoryPrice.setForeground(java.awt.Color.lightGray);
        inventoryPrice.setText("Product Price");

        inventoryQuantity.setBackground(new java.awt.Color(51, 51, 51));
        inventoryQuantity.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        inventoryQuantity.setForeground(java.awt.Color.lightGray);
        inventoryQuantity.setText("Product Quantity");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inventoryName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inventoryPrice)
                    .addComponent(inventoryQuantity)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inventoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inventoryPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inventoryQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 204, 51));

        inventoryMonth.setBackground(new java.awt.Color(51, 51, 51));
        inventoryMonth.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        inventoryMonth.setForeground(java.awt.Color.lightGray);
        inventoryMonth.setText("Expire Month");
        inventoryMonth.setPreferredSize(new java.awt.Dimension(110, 23));

        inventoryDay.setBackground(new java.awt.Color(51, 51, 51));
        inventoryDay.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        inventoryDay.setForeground(java.awt.Color.lightGray);
        inventoryDay.setText("Expire Day");

        inventoryYear.setBackground(new java.awt.Color(51, 51, 51));
        inventoryYear.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        inventoryYear.setForeground(java.awt.Color.lightGray);
        inventoryYear.setText("Expire Year");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inventoryMonth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inventoryDay)
                    .addComponent(inventoryYear)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inventoryMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inventoryDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inventoryYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 204, 51));

        jPanel9.setBackground(new java.awt.Color(255, 204, 51));

        addBtn.setBackground(new java.awt.Color(51, 153, 0));
        addBtn.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add Product");

        updateBtn.setBackground(new java.awt.Color(153, 153, 0));
        updateBtn.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("Update Product");

        removeBtn.setBackground(new java.awt.Color(255, 102, 102));
        removeBtn.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        removeBtn.setForeground(new java.awt.Color(255, 255, 255));
        removeBtn.setText("Remove Product");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeBtn)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 204, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 5, true), "Metco Store", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans Condensed", 1, 13), new java.awt.Color(51, 51, 51))); // NOI18N

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 204, 51));

        jPanel13.setBackground(new java.awt.Color(255, 204, 51));

        inventorySearch.setBackground(new java.awt.Color(51, 51, 51));
        inventorySearch.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        inventorySearch.setForeground(java.awt.Color.lightGray);
        inventorySearch.setText("Search Product");

        ListProducts.setBackground(new java.awt.Color(51, 51, 51));
        ListProducts.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 102), 1, true));
        ListProducts.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        ListProducts.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(ListProducts);

        sortBox.setBackground(new java.awt.Color(51, 51, 51));
        sortBox.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 13)); // NOI18N
        sortBox.setForeground(java.awt.Color.lightGray);
        sortBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sort Name", "Sort Price", "Sort Quantity", "Sort Expiration Date" }));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(inventorySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sortBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inventorySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );
        setVisible(true);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<Product> ListProducts;
    private javax.swing.JTextField inventoryDay;
    private javax.swing.JTextField inventoryMonth;
    private javax.swing.JTextField inventoryName;
    private javax.swing.JTextField inventoryPrice;
    private javax.swing.JTextField inventoryQuantity;
    private javax.swing.JTextField inventorySearch;
    private javax.swing.JTextField inventoryYear;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton removeBtn;
    private javax.swing.JComboBox<String> sortBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables





}
