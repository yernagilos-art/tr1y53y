
public class Order {

    private Customer buyer;
    private MenuItem firstItem, secondItem, thirdItem;
    private int quantity;
    private String referenceNumber;

    public Order(String referenceNumber, Customer buyer) {
        this.quantity = 0;
        setReferenceNumber(referenceNumber);
        setBuyer(buyer);
    }

    public Customer getBuyer() {
        return buyer;
    }

    public void setBuyer(Customer buyer) {
        this.buyer = buyer;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean addItem(MenuItem newItem) {

        if (firstItem == null) {
            firstItem = newItem;
        } else if (secondItem == null) {
            secondItem = newItem;
        } else if (thirdItem == null) {
            thirdItem = newItem;
        } else {
            System.out.println("Order limit reached! " +
                    "Cannot add: " + newItem.getDescription());
            return false;
        }

        quantity++;
        return true;
    }

    public double calculateSubtotal() {

        double amount = 0;

        if (firstItem != null) {
            amount += firstItem.computePrice();
        }

        if (secondItem != null) {
            amount += secondItem.computePrice();
        }

        if (thirdItem != null) {
            amount += thirdItem.computePrice();
        }

        return amount;
    }

    public double calculateTotal() {

        double amount = calculateSubtotal();

        if (buyer.isStudent()) {
            amount = amount * 0.90;
        }

        return amount;
    }

    public double calculateTotal(double voucherAmount) {

        double amount = calculateTotal() - voucherAmount;

        if (amount < 0) {
            System.out.println("Invalid transaction! Total cannot be negative.");
            return 0;
        }

        return amount;
    }

    public void displayReceipt() {
        displayReceipt(0);
    }

    public void displayReceipt(double voucherAmount) {

        double subtotal = calculateSubtotal();
        double regularTotal = calculateTotal();
        double finalAmount = calculateTotal(voucherAmount);
        double discountAmount = subtotal - regularTotal;

        System.out.println("================================");
        System.out.println("          ORDER RECEIPT         ");
        System.out.println("================================");

        if (buyer.isStudent()) {
            System.out.println("Order No.: " + referenceNumber +
                    " - " + buyer.getCustomerName() + " (Student)");
        } else {
            System.out.println("Order No.: " + referenceNumber +
                    " - " + buyer.getCustomerName());
        }

        if (firstItem != null) {
            System.out.println(firstItem.getDescription() +
                    " ............ " + firstItem.computePrice());
        }

        if (secondItem != null) {
            System.out.println(secondItem.getDescription() +
                    " ............ " + secondItem.computePrice());
        }

        if (thirdItem != null) {
            System.out.println(thirdItem.getDescription() +
                    " ............ " + thirdItem.computePrice());
        }

        System.out.println("--------------------------------");
        System.out.println("Subtotal: " + subtotal);

        if (buyer.isStudent()) {
            System.out.println("Student Discount (10%): -" +
                    discountAmount);
        }

        if (voucherAmount > 0) {
            System.out.println("Voucher: -" + voucherAmount);
        }

        System.out.println("--------------------------------");
        System.out.println("Total Payment: " + finalAmount);
        System.out.println("================================");

        buyer.addPoints(finalAmount);

        System.out.println("Loyalty Points: " +
                buyer.getPoints());
    }
}
