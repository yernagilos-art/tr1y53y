
public class CafeApp {

    public static void main(String[] args) {

        System.out.println("====== CAFE ORDERING SYSTEM ======");

        Customer firstCustomer = new Customer("Ana Reyes", true);
        Customer secondCustomer = new Customer("Ben Cruz");


        Beverage latte = new Beverage("Iced Latte", 95, "B-01", "L");
        Pastry ensaymada = new Pastry("Ensaymada", 45, "P-01", true);
        Meal adobo = new Meal("Chicken Adobo", 110, "M-01", true, 1);


        Beverage hotChocolate = new Beverage();
        hotChocolate.setName("Hot Chocolate");
        hotChocolate.setItemCode("B-02");
        hotChocolate.setSize("M");
        hotChocolate.setBasePrice(-5);
        hotChocolate.setBasePrice(80);


        Pastry cookie = new Pastry();
        cookie.setName("Cookie");
        cookie.setItemCode("P-02");
        cookie.setBasePrice(30);


        Meal beefTapa = new Meal();
        beefTapa.setName("Beef Tapa");
        beefTapa.setItemCode("M-02");
        beefTapa.setBasePrice(130);
        beefTapa.setUpsized(false);
        beefTapa.setExtraSides(0);


        Order firstOrder = new Order("1001", firstCustomer);

        firstOrder.addItem(latte);
        firstOrder.addItem(ensaymada);
        firstOrder.addItem(adobo);


        firstOrder.printReceipt();

        System.out.println();


        Order secondOrder = new Order("1002", secondCustomer);

        secondOrder.addItem(hotChocolate);
        secondOrder.addItem(beefTapa);


        secondOrder.printReceipt(20);

        System.out.println();
        System.out.println("====== THANK YOU FOR VISITING! ======");
    }
}
