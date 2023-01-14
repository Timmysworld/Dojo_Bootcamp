// package Java.Assignments.CafeBusinessLogic;
import java.util.ArrayList;
import java.util.Arrays;


public class TestCafe {
    public static void main(String[] args){
        // Make an instance for the CafeUtil to access all its methods.
        CafeUtil cafeJava = new CafeUtil();

        int getStreakGoalTest = cafeJava.getStreakGoal(10);

        //PRINT TEST CASES: 
        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", cafeJava.getStreakGoal(10));

        System.out.println("----- Order Total Test -----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n",cafeJava.getOrderTotal(lineItems));

        System.out.println("----- Display Menu Test -----");
        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("drip coffee");
        menuItems.add("cappuccino");
        menuItems.add("latte");
        menuItems.add("mocha");
        cafeJava.displayMenu(menuItems);
        System.out.println("---- Display Menu w/ Prices -----");
        ArrayList<Double>price = new ArrayList<Double>();
        price.add(1.00);
        price.add(2.00);
        price.add(3.00);
        price.add(4.00);
        cafeJava.displayMenu(menuItems, price);

        // System.out.println(menuItems);

        System.out.println("\n----- Add Customer Test -----");
        ArrayList<String> customers = new ArrayList<String>();
        //--- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            cafeJava.addCustomer(customers);
        System.out.println("\n");}

        //NINJA BONUSES: 
        System.out.println("\n---- Price Chart Test -----");
        cafeJava.printPriceChart("Colombian Coffee", 15.00, 3);
        

    }

}
