package com.metco.store;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class JListRenderer extends JLabel implements ListCellRenderer<Product>{
    
        @Override
        public Component getListCellRendererComponent(JList<? extends Product> list, Product product, int index, boolean isSelected,
                boolean cellHasFocus) {
    
                setText("<html><head><style>html{height: 100%; width: 100%;</style></head><div style=\"width: 100vw; border: 3px solid black; border-radius: 20px; margin: 2px; padding: 2px;\">" + 
                        "<h3>Name | " + product.getName() + "</h3>" +
                        "<br><p>Price | ₱ " + product.getPrice() + 
                        "<br>Quantity | " + product.getQuantity() + 
                        "<br>Expiration Date | " + product.getExpDate() + "</p>" +
                        "</div></html>");
                if(cellHasFocus){
                        setBackground(list.getSelectionBackground());
                        setForeground(list.getSelectionForeground());
                } else {
                        setBackground(list.getBackground());
                        setBackground(list.getForeground());
                }
                
                setOpaque(true);
                return this;
    }

}