import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class iventoryGUItemp{
    public static void main(String[] args) {
        Inventory box = new Inventory();
        JFrame frame = new JFrame();
        JLabel label1 = new JLabel();
        

        // int tempMonth = 0; 
        // int tempDay = 0;
        // int tempYear = 0;

        JPanel PanelInventory = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel botPanel = new JPanel();
        JPanel PanelList = new JPanel();
        
        

        PanelInventory.setBackground(Color.GREEN);
        PanelInventory.setPreferredSize(new Dimension(500,500));
        PanelInventory.setLayout(new FlowLayout());
        
        topPanel.setBackground(Color.black);
        topPanel.setLayout(new BorderLayout());
        topPanel.setBounds(0,0,50,100);
        

        PanelList.setBackground(Color.BLUE);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Metco Store");
        frame.setSize(500, 500);
        frame.setLayout( new BorderLayout());
        frame.setResizable(true);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, PanelInventory, PanelList);
        splitPane.setDividerLocation(500);
        splitPane.setBackground(Color.BLACK);
        

        // Buttons for the Product
        // JTextField inputName = new JTextField("Name");
        // inputName.setSize(100, 100);
        // inputName.setBounds(50, 50, 115, 30);
        
        // JTextField inputPrice = new JTextField("Price");
        // inputPrice.setSize(100, 100);
        // inputPrice.setBounds(50, 90, 115, 30);

        // JTextField inputQuantity = new JTextField("Quantity");
        // inputQuantity.setSize(100, 100);
        // inputQuantity.setBounds(50, 130, 115, 30);

        // //Button for EXPDate
        // JTextField inputMonth = new JTextField("MM");
        // inputMonth.setSize(100, 100);
        // inputMonth.setBounds(50, 170, 35, 30);

        // JTextField inputDay = new JTextField("DD");
        // inputDay.setSize(100, 100);
        // inputDay.setBounds(90, 170, 35, 30);

        // JTextField inputYear = new JTextField("YY");
        // inputYear.setSize(100, 100);
        // inputYear.setBounds(130, 170, 35, 30);
         
        // // Add and Remove Product
        // JButton addBtn = new JButton("Add Product");
        // addBtn.setSize(115, 30);
        // addBtn.setLocation(200,80);

        // JButton removeBtn = new JButton("Remove Product");
        // removeBtn.setSize(115, 30);
        // removeBtn.setLocation(200,120);
      
        
        //inventory
        // PanelInventory.add(inputName);
        // PanelInventory.add(inputPrice);
        // PanelInventory.add(inputQuantity);
        // PanelInventory.add(inputMonth);
        // PanelInventory.add(inputDay);
        // PanelInventory.add(inputYear);

        PanelInventory.add(topPanel);

        

        
        



        //list

        
        frame.getContentPane().add(splitPane);
        // frame.add(PanelInventory);
        // frame.add(PanelList);
        // frame.add(splitPane);

        

        frame.setVisible(true);
    }
}
