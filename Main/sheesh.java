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
        JTextField inputName = new JTextField("Name");
        inputName.setSize(100, 100);
        inputName.setBounds(50, 50, 115, 30);
        
        JTextField inputPrice = new JTextField("Price");
        inputPrice.setSize(100, 100);
        inputPrice.setBounds(50, 90, 115, 30);

        JTextField inputQuantity = new JTextField("Quantity");
        inputQuantity.setSize(100, 100);
        inputQuantity.setBounds(50, 130, 115, 30);

        //Button for EXPDate
        JTextField inputMonth = new JTextField("MM");
        inputMonth.setSize(100, 100);
        inputMonth.setBounds(50, 170, 35, 30);

        JTextField inputDay = new JTextField("DD");
        inputDay.setSize(100, 100);
        inputDay.setBounds(90, 170, 35, 30);

        JTextField inputYear = new JTextField("YY");
        inputYear.setSize(100, 100);
        inputYear.setBounds(130, 170, 35, 30);
         
        // Add and Remove Product
        JButton addBtn = new JButton("Add Product");
        addBtn.setSize(115, 30);
        addBtn.setLocation(200,80);

        JButton removeBtn = new JButton("Remove Product");
        removeBtn.setSize(115, 30);
        removeBtn.setLocation(200,120);
      
        addBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String tempName = inputName.getText();
                double tempPrice = 0;
                int tempQuantity = 0;

                box.setName(tempName);
                box.setPrice(tempPrice);
                box.setQuantity(tempQuantity);
                box.setExpiration(tempMonth, tempDay, tempYear);
                label1.setText("Product Name: " + box.displayName());
                box.addProduct();

                inputName.setText(null);
            }

        });

        removeBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String tempName = inputName.getText();
                double tempPrice = 0;
                int tempQuantity = 0;

                box.setName(tempName);
                box.setPrice(tempPrice);
                box.setQuantity(tempQuantity);
                box.setExpiration(tempMonth, tempDay, tempYear);
                label1.setText("Product Name: " + box.displayName());
                box.addProduct();

                inputName.setText(null);
            }

        });

        frame.add(inputName);

        

        frame.add(Panel,BorderLayout.NORTH);
        

        frame.setVisible(true);
    }
}
