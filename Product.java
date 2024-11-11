public class Product {
    private String name;
    private double price;
    private int quantity;
    private String expDate;

    public Product(String name, double price, int quantity, String expDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expDate = expDate;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getExpDate(){
        return expDate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "\n" + "Name: " + name + ", Price: " + price + ", Quantity: " + quantity + ", ExpDate: " + expDate + "\n";
    }
}