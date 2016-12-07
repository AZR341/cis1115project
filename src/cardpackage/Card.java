package cardpackage;

/**
 * Card shop inventory.
 * @author Jacob Greenawalt
 */
public class Card {
    private int id;
    private String name;
    private double price;
    private String set;
    private int quantity;

    public Card() {
    }

    public Card(int id, String name, double price, String set, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.set = set;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        //return "Card{" + "id= " + id + ", name= " + name + ", price= " + price + ", set= " + set + ", quantity= " + quantity + '}';
        return String.format("%-5d Card: %-20s Set: %-20s Price: %-8.2f Quantity: %-5d", id, name, set, price, quantity);
    }
    
    
    
    
}
