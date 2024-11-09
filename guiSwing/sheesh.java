import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class sheesh {
    public static void main(String[] args) {
        Inventory box = new Inventory();
        JFrame frame = new JFrame();
        JLabel label1 = new JLabel();

        int tempMonth = 0; 
        int tempDay = 0;
        int tempYear = 0;

        
        box.setName("Adobo");
        box.setPrice(50.10);
        box.setQuantity(20);
        box.setExpiration(11, 2, 2076);
        box.addProduct();

        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(true);

        JTextField inputTextName = new JTextField();
        inputTextName.setSize(100, 100);
        inputTextName.setBounds(100, 100, 100, 100);
        
        JButton addBtn = new JButton("Add Product");
        addBtn.setSize(100, 50);
        addBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String tempName = inputTextName.getText();
                double tempPrice = 0;
                int tempQuantity = 0;
                
                box.setName(tempName);
                box.setPrice(tempPrice);
                box.setQuantity(tempQuantity);
                box.setExpiration(tempMonth, tempDay, tempYear);
                label1.setText("Product Name: " + box.displayName());
                box.addProduct();

                inputTextName.setText(null);
            }

        });
        
        frame.add(inputTextName);
        frame.add(addBtn);
        frame.add(label1);

        frame.setVisible(true);
    }
}
