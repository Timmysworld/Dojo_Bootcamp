//package Java.Practice_Assignments.CafeJava;


public class CafeJava {
    public static void main(String[] args){
        //APP VARIABLES
        // LINES OF TEXT THAT WILL APPEAR IN THE APP.

        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage  =  "Your total is $";

        //MENU VARIABLES (ADD YOURS BELOW)
        double mochaPrice = 3.5;
        double dripCoffee = 2.0;
        double latte = 4.5;
        double cappucino = 5.0;

        //CUSTOMER NAME VARIABLES (ADD YOURS BELOW)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        //ORDER COMPLETIONS (ADD YOURS BELOW)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true; 

        //APP INTERACTION SIMULATION (ADD YOUR CODE FOR THE CHALLENGE BELOW)

        //EXAMPLE: 
        System.out.println(generalGreeting + customer1); 

        //CUSTOMER INTERACTION PRINTS
        System.out.println(generalGreeting + customer2);
        System.out.println(generalGreeting + customer3);
        System.out.println(generalGreeting + customer4);

        //Tasks 1:
        System.out.println(customer1 +  pendingMessage);
        
        //Tasks 2:
        if (isReadyOrder4){
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + cappucino);
        }
        else {
            System.out.println(pendingMessage);
        }

        //Tasks 3: 
        System.out.println(displayTotalMessage + latte *2);
        if (isReadyOrder2){
            System.out.println(customer2 + readyMessage);
        }
        else{
            System.out.println(customer2 + pendingMessage);
        }

        //Tasks 4: 
        // System.out.println(dripCoffee - latte);
        System.out.println(displayTotalMessage + (latte - dripCoffee));

    }
}
