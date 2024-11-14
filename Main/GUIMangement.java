import java.awt.BorderLayout;
import java.awt.Color; //lalo
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class GUIMangement extends JFrame{
   Inventory inventory = new Inventory();
   
   int tempMonth = 0; 
   int tempDay = 0;
   int tempYear = 0;

   JPanel PanelInventory;
   JList<Product> list = inventory.products;
   JTextField inputName, inputPrice, inputQuantity, inputMonth, inputDay, inputYear;
   JButton addBtn, removeBtn;

   public GUIMangement(){
        this.setResizable(true);
        this.setSize(900, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelInventory = new JPanel();
        PanelInventory.setMinimumSize(new Dimension(300, 300));
        JPanel PanelList = new JPanel();
        PanelList.setMinimumSize(new Dimension(300, 300));
        this.setLayout(new BorderLayout());
        PanelInventory.setLayout(new BoxLayout(PanelInventory, BoxLayout.PAGE_AXIS));
    
        PanelInventory.setBackground(Color.GREEN);
        PanelList.setBackground(Color.BLUE);

        JPanel TopPanel = new JPanel();
        JPanel BottomPanel = new JPanel();
        
       
        TopPanel.setBackground(Color.RED);
        TopPanel.setMaximumSize(new Dimension(200,200));
        TopPanel.setMinimumSize(new Dimension(200, 300));
        TopPanel.setLayout(new GridLayout(5, 1, 30, 30));

        BottomPanel.setMaximumSize(new Dimension(200, 200));
        BottomPanel.setMinimumSize(new Dimension(200, 300));
        BottomPanel.setBackground(Color.CYAN);
        BottomPanel.setLayout(new FlowLayout());
        
        TopPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, PanelInventory, PanelList);
        splitPane.setDividerLocation(300);
        splitPane.setBackground(Color.BLACK);

        JSplitPane SplitInventory = new JSplitPane(JSplitPane.VERTICAL_SPLIT, TopPanel, BottomPanel);
        
        inputName = new JTextField();
        inputName.setSize(100, 20);

        inputPrice = new JTextField();
        inputPrice.setSize(100, 20);

        inputQuantity = new JTextField();

        JPanel ExpPanel = new JPanel();
        ExpPanel.setBackground(Color.RED);
        ExpPanel.setLayout(new FlowLayout());
        ExpPanel.setPreferredSize(new Dimension(150, 50));

        inputMonth = new JTextField();
        inputMonth.setPreferredSize(new Dimension(150, 50));
        inputDay = new JTextField();
        inputDay.setPreferredSize(new Dimension(150, 50));
        inputYear = new JTextField();
        inputYear.setPreferredSize(new Dimension(150, 50));

        ExpPanel.add(inputMonth);
        ExpPanel.add(inputDay);
        ExpPanel.add(inputYear);

         

        addBtn = new JButton();
        addBtn.setPreferredSize(new Dimension(150, 50));
        addBtn.setText("Add Product");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
              addProductGUI();
            }
        });

        removeBtn = new JButton();
        removeBtn.setText("Remove Product");
        removeBtn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e){
            removeProductGUI();
          }
        });



        this.getContentPane().add(splitPane);
        PanelInventory.add(SplitInventory, BorderLayout.CENTER);
        TopPanel.add(inputName);
        TopPanel.add(inputPrice);
        TopPanel.add(inputQuantity);
        TopPanel.add(ExpPanel);
        TopPanel.add(addBtn);


        inventory.products = new JList<>(inventory.listModel);
        inventory.products.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        inventory.products.setVisibleRowCount(5);
        
        JScrollPane listScrollPane = new JScrollPane(list);

        BottomPanel.add(listScrollPane);
        BottomPanel.add(removeBtn);
        
       

        this.setVisible(true);
    }

    public void addProductGUI(){
        String productName = inputName.getText();
        Double productPrice = Double.parseDouble(inputPrice.getText());
        int productQuantity = Integer.parseInt(inputQuantity.getText());
          
        inventory.setName(productName);
        inventory.setPrice(productPrice);
        inventory.setQuantity(productQuantity);

        inventory.addProduct();
        
        
    }

    public void removeProductGUI(){
        int SelectedIndex = list.getSelectedIndex();
        inventory.removeProduct(SelectedIndex);
    }

    public void update(){
        
    }
   
}