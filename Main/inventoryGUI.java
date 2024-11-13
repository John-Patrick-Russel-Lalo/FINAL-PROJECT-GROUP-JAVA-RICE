import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class inventoryGUI extends JFrame{
   Inventory inventory = new Inventory();
   
   int tempMonth = 0; 
   int tempDay = 0;
   int tempYear = 0;

   public inventoryGUI(){
        this.setResizable(true);
        this.setSize(900, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel PanelInventory = new JPanel();
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
        BottomPanel.setLayout(new BorderLayout());
        
        TopPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, PanelInventory, PanelList);
        splitPane.setDividerLocation(300);
        splitPane.setBackground(Color.BLACK);

        JSplitPane SplitInventory = new JSplitPane(JSplitPane.VERTICAL_SPLIT, TopPanel, BottomPanel);
        
        JTextField inputName = new JTextField();
        inputName.setSize(100, 20);

        JTextField inputPrice = new JTextField();
        inputPrice.setSize(100, 20);

        JTextField inputQuantity = new JTextField();

        JPanel ExpPanel = new JPanel();
        ExpPanel.setBackground(Color.RED);
        ExpPanel.setLayout(new FlowLayout());
        ExpPanel.setPreferredSize(new Dimension(150, 50));

        JTextField inputMonth = new JTextField();
        inputMonth.setPreferredSize(new Dimension(150, 50));
        JTextField inputDay = new JTextField();
        inputDay.setPreferredSize(new Dimension(150, 50));
        JTextField inputYear = new JTextField();
        inputYear.setPreferredSize(new Dimension(150, 50));

        ExpPanel.add(inputMonth);
        ExpPanel.add(inputDay);
        ExpPanel.add(inputYear);

         

        JButton addBtn = new JButton();
        addBtn.setPreferredSize(new Dimension(150, 50));
        addBtn.setText("Add Product");
        this.getContentPane().add(splitPane);
        PanelInventory.add(SplitInventory, BorderLayout.CENTER);
        TopPanel.add(inputName);
        TopPanel.add(inputPrice);
        TopPanel.add(inputQuantity);
        TopPanel.add(ExpPanel);
        TopPanel.add(addBtn);

       
        

        this.setVisible(true);
    }
   
      public static void main(String[] args) {
       new inventoryGUI();
    }

   
}