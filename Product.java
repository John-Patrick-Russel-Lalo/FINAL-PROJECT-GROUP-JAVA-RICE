public class Product {
    private int ID;
    private String name;
    private double price;
    private int quantity;
    private String expDate;

    public Product(int ID, String name, double price, int quantity, String expDate) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expDate = expDate;
    }

    public int getID(){
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getExpDate(){
        return this.expDate;
    }

    
    @Override
    public String toString() {
        return "\n" + "ID: " + ID  + ", Name: " + name + ", Price: " + price + ", Quantity: " + quantity + ", ExpDate: " + expDate + "\n";
    }
}
