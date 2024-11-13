import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
        setResizable(true);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel PanelInventory = new JPanel();
        PanelInventory.setSize(500, 100);
        JPanel PanelList = new JPanel();
        setLayout(new BorderLayout());
    
        PanelInventory.setBackground(Color.GREEN);
    
        PanelList.setBackground(Color.BLUE);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, PanelInventory, PanelList);
        splitPane.setDividerLocation(300);
        splitPane.setBackground(Color.BLACK);

        JTextField inputName = new JTextField();


        JButton addBtn = new JButton();

        

        getContentPane().add(splitPane);
   
        setVisible(true);
    }
   
      public static void main(String[] args) {
       new inventoryGUI();
    }

   
}