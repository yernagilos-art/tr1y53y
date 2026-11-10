
public class Pastry extends MenuItem {

    private boolean heated;

    public Pastry() {
        super();
        heated = false;
    }

    public Pastry(String name, double basePrice, String itemCode, boolean heated) {
        super(name, basePrice, itemCode);
        this.heated = heated;
    }

    public boolean getHeatedStatus() {
        return heated;
    }

    public void changeHeatingStatus(boolean status) {
        heated = status;
    }

    @Override
    public double computePrice() {

        double totalPrice = basePrice;

        if (heated) {
            totalPrice += 10;
        }

        return totalPrice;
    }

    @Override
    public String getDescription() {

        String condition = heated ? " (Heated)" : "";

        return super.getDescription() + condition;
    }
}
