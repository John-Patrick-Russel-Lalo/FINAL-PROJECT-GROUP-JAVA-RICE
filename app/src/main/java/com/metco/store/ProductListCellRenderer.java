package com.metco.store;
import javax.swing.*;
import java.awt.*;

public class ProductListCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Product product = (Product) value;
        String displayText = String.format("<html><b>%s</b><br>Price: $%.2f<br>Quantity: %d<br>Expires on: %s</html>",
                product.getName(), product.getPrice(), product.getQuantity(), product.getExpDate());

        JLabel label = new JLabel(displayText);
        label.setOpaque(true);
        
        if (isSelected) {
            label.setBackground(Color.LIGHT_GRAY);
        } else {
            label.setBackground(Color.WHITE);
        }
        
        return label;
    }
}