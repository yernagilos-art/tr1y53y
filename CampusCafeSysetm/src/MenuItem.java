
public abstract class MenuItem {

    protected String itemName;
    protected double price;
    private String code;

    public MenuItem() {
        itemName = "Unknown Item";
        price = 0.0;
        code = "N/A";
    }

    public MenuItem(String itemName, double price, String code) {
        this.itemName = itemName;
        setPrice(price);
        this.code = code;
    }

    private void setPrice(double price) {
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public String getCode() {
        return code;
    }

    public void changeName(String newName) {
        itemName = newName;
    }

    public void changePrice(double newPrice) {

        if (newPrice >= 0) {
            price = newPrice;
        } else {
            System.out.println("Invalid price! Price cannot be negative.");
        }
    }

    public void changeCode(String newCode) {
        code = newCode;
    }

    public String getDescription() {
        return itemName + " [" + code + "]";
    }

    public abstract double computePrice();
}
