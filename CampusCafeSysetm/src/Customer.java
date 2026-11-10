
public class Customer {

    private String customerName;
    private boolean isStudent;
    private int points;

    public Customer() {
        customerName = "Guest";
        isStudent = false;
        points = 0;
    }

    public Customer(String customerName) {
        this.customerName = customerName;
        isStudent = false;
        points = 0;
    }

    public Customer(String customerName, boolean isStudent) {
        this.customerName = customerName;
        this.isStudent = isStudent;
        points = 0;
    }

    public String getCustomerName() {
        return customerName;
    }

    public boolean getStudentStatus() {
        return isStudent;
    }

    public int getPoints() {
        return points;
    }

    public void earnPoints(int newPoints) {

        if (newPoints >= 0) {
            points = points + newPoints;
        } else {
            System.out.println("Invalid points entered.");
        }
    }

    public void earnPoints(double payment) {

        if (payment >= 0) {
            int earned = (int) (payment / 50);
            earnPoints(earned);
        } else {
            System.out.println("Invalid payment amount.");
        }
    }

    public void updateName(String newName) {
        customerName = newName;
    }

    public void updatePoints(int newPoints) {

        if (newPoints >= 0) {
            points = newPoints;
        } else {
            System.out.println("Points must not be negative.");
        }
    }

    public void updateStudentStatus(boolean status) {
        isStudent = status;
    }
}
