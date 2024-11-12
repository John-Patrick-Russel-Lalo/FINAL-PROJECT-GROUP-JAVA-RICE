import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Custom Item class to represent each item with multiple properties
class Item {
    private String name;
    private String description;
    private Color color; // Example additional property

    public Item(String name, String description, Color color) {
        this.name = name;
        this.description = description;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return name;  // Display name in the JList
    }
}

public class SwingListExample {

    private JFrame frame;
    private JList<Item> list;
    private DefaultListModel<Item> listModel;
    private JButton addButton, removeButton;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingListExample example = new SwingListExample();
        example.createAndShowGUI();
    }

    public SwingListExample() {
        frame = new JFrame("Enhanced Swing JList Example");

        // Item model for the JList with Item objects
        listModel = new DefaultListModel<>();
        listModel.addElement(new Item("Item 1", "Description 1", Color.RED));
        listModel.addElement(new Item("Item 2", "Description 2", Color.BLUE));
        listModel.addElement(new Item("Item 3", "Description 3", Color.GREEN));

        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setVisibleRowCount(5);

        // Scroll pane for the JList
        JScrollPane listScrollPane = new JScrollPane(list);

        // Create buttons with tooltips
        addButton = new JButton("Add Item");
        addButton.setToolTipText("Add a new item to the list");
        removeButton = new JButton("Remove Item");
        removeButton.setToolTipText("Remove the selected item from the list");

        // Action listeners for buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add a new item with a default name, description, and color
                String itemName = "Item " + (listModel.getSize() + 1);
                listModel.addElement(new Item(itemName, "New Description", Color.ORANGE));
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(frame, "No item selected to remove.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Layout setup with BorderLayout for list and FlowLayout for buttons
        frame.setLayout(new BorderLayout());
        frame.add(new JLabel("Item List"), BorderLayout.NORTH);
        frame.add(listScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Frame settings
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    private void createAndShowGUI() {
        frame.setVisible(true);
    }
}
