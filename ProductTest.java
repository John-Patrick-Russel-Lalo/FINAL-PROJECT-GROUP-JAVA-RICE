import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProductTest::createAndShowGUI);
    }

    // Method to create the JFrame GUI
    private static void createAndShowGUI() {
        // Create a frame
        JFrame frame = new JFrame("Product List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Create a table with column names
        String[] columnNames = {"Product Name", "Expiration Date", "Price", "Quantity"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Add data to the table
        List<Product> products = getProductList();
        for (Product product : products) {
            model.addRow(new Object[]{
                product.getName(),
                product.getExpirationDate(),
                product.getPrice(),
                product.getQuantity()
            });
        }

        // Create the JTable with the model
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        frame.add(scrollPane, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }

    // Method to create a list of products
    private static List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();

        // Add some sample products
        productList.add(new Product("Milk", "2024-12-31", 2.99, 10));
        productList.add(new Product("Eggs", "2024-11-15", 1.49, 25));
        productList.add(new Product("Bread", "2024-11-20", 1.99, 15));
        productList.add(new Product("Cheese", "2024-12-10", 5.49, 5));
        productList.add(new Product("Butter", "2024-10-30", 3.49, 8));

        return productList;
    }

    // Product class to hold product details
    static class Product {
        private String name;
        private String expirationDate;
        private double price;
        private int quantity;

        public Product(String name, String expirationDate, double price, int quantity) {
            this.name = name;
            this.expirationDate = expirationDate;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public String getExpirationDate() {
            return expirationDate;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }
    }
}

