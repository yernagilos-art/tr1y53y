
public class Meal extends MenuItem {

    private boolean largeSize;
    private int sideOrders;

    public Meal() {
        super();
        largeSize = false;
        sideOrders = 0;
    }

    public Meal(String name, double basePrice, String itemCode,
                boolean largeSize, int sideOrders) {

        super(name, basePrice, itemCode);

        this.largeSize = largeSize;
        this.sideOrders = 0;
        setSideOrders(sideOrders);
    }

    public boolean getLargeSize() {
        return largeSize;
    }

    public int getSideOrders() {
        return sideOrders;
    }

    public void changeSize(boolean newSize) {
        largeSize = newSize;
    }

    public void changeSideOrders(int quantity) {

        if (quantity < 0) {
            System.out.println("Invalid quantity! Side orders cannot be negative.");
        } else {
            sideOrders = quantity;
        }
    }

    public void setSideOrders(int quantity) {
        changeSideOrders(quantity);
    }

    @Override
    public double computePrice() {

        double total = basePrice + (sideOrders * 12);

        if (largeSize) {
            total += 20;
        }

        return total;
    }

    @Override
    public String getDescription() {

        String sizeDescription = largeSize ? "Upsized" : "Regular";

        return super.getDescription() + " " +
                sizeDescription + ", " + sideOrders + " side/s";
    }
}
