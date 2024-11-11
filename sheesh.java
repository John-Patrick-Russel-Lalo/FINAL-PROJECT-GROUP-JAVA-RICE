import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class sheesh{
    public static void main(String[] args) {
        Inventory box = new Inventory();
        JFrame frame = new JFrame();
        JLabel label1 = new JLabel();
        

        int tempMonth = 0; 
        int tempDay = 0;
        int tempYear = 0;

        JPanel Panel = new JPanel();
        JPanel Panel1 = new JPanel();
        JPanel Panel2 = new JPanel();
        JPanel Panel3 = new JPanel();
        JPanel Panel4 = new JPanel();

        Panel.setBackground(Color.GREEN);
        Panel1.setBackground(Color.yellow);
        Panel2.setBackground(Color.blue);
        Panel3.setBackground(Color.red);
        Panel4.setBackground(Color.white);

        Panel.setPreferredSize(new Dimension(100,100));
        Panel1.setPreferredSize(new Dimension(100,100));
        Panel2.setPreferredSize(new Dimension(100,100));
        Panel3.setPreferredSize(new Dimension(100,100));
        Panel4.setPreferredSize(new Dimension(100,100));



        box.setName("Adobo");
        box.setPrice(50.10);
        box.setQuantity(20);
        box.setExpiration(11, 2, 2076);
        box.addProduct();
        box.removeProduct();


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Metco Store");
        frame.setSize(500, 500);
        frame.setLayout( new BorderLayout());
        frame.setResizable(true);


        // Buttons for the Product
        JTextField inputTextName = new JTextField("Name");
        inputTextName.setSize(100, 100);
        inputTextName.setBounds(50, 50, 115, 30);
        
        JTextField inputTextName1 = new JTextField("Price");
        inputTextName1.setSize(100, 100);
        inputTextName1.setBounds(50, 90, 115, 30);

        JTextField inputTextName2 = new JTextField("Quantity");
        inputTextName2.setSize(100, 100);
        inputTextName2.setBounds(50, 130, 115, 30);

        //Button for EXPDate
        JTextField inputTextName3 = new JTextField("MM");
        inputTextName3.setSize(100, 100);
        inputTextName3.setBounds(50, 170, 35, 30);

        JTextField inputTextName4 = new JTextField("DD");
        inputTextName4.setSize(100, 100);
        inputTextName4.setBounds(90, 170, 35, 30);

        JTextField inputTextName5 = new JTextField("YY");
        inputTextName5.setSize(100, 100);
        inputTextName5.setBounds(130, 170, 35, 30);
         
        // Add and Remove Product
        JButton addBtn = new JButton("Add Product");
        addBtn.setSize(115, 30);
        addBtn.setLocation(200,80);

        JButton addBtn1 = new JButton("Remove Product");
        addBtn1.setSize(115, 30);
        addBtn1.setLocation(200,120);
      
        addBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String tempName = inputTextName.getText();
                String tempName1 = inputTextName1.getText();
                String tempName2 = inputTextName2.getText();
                double tempPrice = 0;
                int tempQuantity = 0;

                box.setName(tempName);
                box.setName(tempName1);
                box.setName(tempName2);
                box.setPrice(tempPrice);
                box.setQuantity(tempQuantity);
                box.setExpiration(tempMonth, tempDay, tempYear);
                label1.setText("Product Name: " + box.displayName());
                box.addProduct();

                inputTextName.setText(null);
                inputTextName1.setText(null);
                inputTextName2.setText(null);
            }

        });

        addBtn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String tempName = inputTextName.getText();
                String tempName1 = inputTextName1.getText();
                String tempName2 = inputTextName2.getText();
                double tempPrice = 0;
                int tempQuantity = 0;

                box.setName(tempName);
                box.setName(tempName1);
                box.setName(tempName2);
                box.setPrice(tempPrice);
                box.setQuantity(tempQuantity);
                box.setExpiration(tempMonth, tempDay, tempYear);
                label1.setText("Product Name: " + box.displayName());
                box.addProduct();

                inputTextName.setText(null);
                inputTextName1.setText(null);
                inputTextName2.setText(null);
            }

        });

        frame.add(inputTextName);
        frame.add(addBtn);
        frame.add(addBtn1);
        frame.add(label1);

        frame.add(inputTextName1);
        frame.add(addBtn);
        frame.add(addBtn1); 
        frame.add(label1);

        frame.add(inputTextName2);
        frame.add(addBtn);
        frame.add(addBtn1);
        frame.add(label1);

        frame.add(inputTextName3);
        frame.add(addBtn);
        frame.add(addBtn1); 
        frame.add(label1);

        frame.add(inputTextName4);
        frame.add(addBtn);
        frame.add(addBtn1); 
        frame.add(label1);

        frame.add(inputTextName5);
        frame.add(addBtn);
        frame.add(addBtn1); 
        frame.add(label1);

        frame.add(Panel,BorderLayout.NORTH);
        

        frame.setVisible(true);
    }
}