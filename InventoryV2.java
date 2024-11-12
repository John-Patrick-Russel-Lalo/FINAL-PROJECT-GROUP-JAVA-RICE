import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class InventoryV2 extends JFrame {

    Inventory inventory = new Inventory();
    
    public InventoryV2(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(true);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JTextField inputName = new JTextField();
        addPlaceholder(inputName, "Product Name");
        inputName.setSize(100, 100);
        
        JTextField inputPrice = new JTextField("Price");
        inputPrice.setSize(100, 100);

        JTextField inputQuantity = new JTextField("Quantity");
        inputQuantity.setSize(100, 100);

        JTextField inputExpMonth = new JTextField("Month");
        inputExpMonth.setSize(100, 100);
        
        JTextField inputExpDay = new JTextField("Day");
        inputExpDay.setSize(100, 100);
        
        JTextField inputExpYear = new JTextField("Year");
        inputExpYear.setSize(100, 100);
        
        JButton addBtn = new JButton("Add Product");
        addBtn.addActionListener(e -> inventory.addProduct());
        addBtn.setSize(115, 30);

        JButton removeBtn = new JButton("Remove Product");
        removeBtn.setSize(115, 30);
        
        JPanel Panel = new JPanel(new BorderLayout());
        JPanel mainPanel = new JPanel();
        JPanel listPanel = new JPanel();

        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        mainPanel.add(addBtn);
        mainPanel.add(removeBtn);
        mainPanel.add(inputName);
        mainPanel.add(inputPrice);
        mainPanel.add(inputQuantity);
        mainPanel.add(inputExpDay);
        mainPanel.add(inputExpMonth);
        mainPanel.add(inputExpYear);

        listPanel.add(new JLabel("Search Result: "));

        Panel.add(mainPanel, BorderLayout.WEST);
        Panel.add(listPanel, BorderLayout.EAST);

        add(Panel);

        setVisible(true);
    }

    public static void main(String args[]){
        SwingUtilities.invokeLater(() -> {
            InventoryV2 inventoryV2 = new InventoryV2();
            inventoryV2.setVisible(true);
        });
    }

    public static void addPlaceholder(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        // Add focus listener to handle placeholder behavior
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }
}