
public class Beverage extends MenuItem {

    private String selectedSize;

    public Beverage() {
        super();
        selectedSize = "S";
    }

    public Beverage(String name, double basePrice, String itemCode, String selectedSize) {
        super(name, basePrice, itemCode);
        this.selectedSize = "S";
        updateSize(selectedSize);
    }

    public String getSelectedSize() {
        return selectedSize;
    }

    public void updateSize(String sizeOption) {

        if ("S".equals(sizeOption)) {
            selectedSize = "S";
        } else if ("M".equals(sizeOption)) {
            selectedSize = "M";
        } else if ("L".equals(sizeOption)) {
            selectedSize = "L";
        } else {
            System.out.println("Invalid beverage size. Please select S, M, or L.");
        }
    }

    @Override
    public double computePrice() {

        double price = basePrice;

        if ("M".equals(selectedSize)) {
            price = price + 15;
        } else if ("L".equals(selectedSize)) {
            price = price + 25;
        }

        return price;
    }

    @Override
    public String getDescription() {

        String details = super.getDescription();

        return details + " | Size: " + selectedSize;
    }
}
