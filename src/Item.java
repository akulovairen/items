import java.util.Date;

public class Item {
    public String name;
    public String category;
    public int quantity;
    public double price;
    public Date expirationDate;

    public Item(String name, String category, int quantity, double price, Date expirationDate) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
