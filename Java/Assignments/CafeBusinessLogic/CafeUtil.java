import java.util.ArrayList;
import java.text.*;
// import java.util.Scanner;

// package Java.Assignments.CafeBusinessLogic;

public class CafeUtil {
    public int getStreakGoal(int numWeeks) {
        int sum = 0;
        for( int i = 1; i <= numWeeks; i++){
            sum += i ;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices){
        double total = 0.0;
        for( double lineItems : prices){
            total += lineItems;
        }
        return total; 
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for( int id = 0; id < menuItems.size(); id++){
            String menu = menuItems.get(id);
            System.out.println(menu);
        }
    }

    public void displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices){
        for( int id = 0; id< menuItems.size(); id++){
            String menu  = menuItems.get(id);
            Double price = prices.get(id);
            System.out.println(id + " - " + menu + " - " + price );
        }
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name: ");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s! ", userName);
        System.out.printf("There are %s people in front of you \n",  customers.size());
        customers.add(userName);
        System.out.println(customers);
    }
    //NINJA BONUSES : 
    public void printPriceChart(String product, double price, int maxQuantity){
        System.out.println(product);
        double qPrice = 0;
        for (int quantity = 1; quantity <= maxQuantity; quantity++ ){
            qPrice = quantity * price;
            System.out.println(quantity + " - $" + qPrice);
        }
        
        
    }
}
