import java.util.ArrayList;

// ? Why do I have red squiggly lines under my instance.
// ? Also when I tried to write the code with the commented out section on the menu items the compiler threw and error. not sure why? it works even though i have squigglies. 

public class TestOrder {
    public static void main( String[] args){

        //MENU ITEMS 
        Item item1 = new Item("drip coffee", 1.00);
        // item1.name = "drip coffee";
        // item1.price = 1.00;

        Item item2 = new Item("cappucino",2.50);
        // item2.name = "cappucino";
        // item2.price = 2.50;

        Item item3 = new Item("latte",1.50);
        // item3.name = "latte";
        // item3.price = 1.50;

        Item item4 = new Item("mocha",3.00);
        // item4.name = "mocha";
        // item4.price = 3.00;

        // * Make an instance for Order Class to access all its methods.

        // Create 2 orders for unspecified guests (without specifying a name);
        
        Order baristaOrder1 = new Order();
        
        Order baristaOrder2 = new Order();

        // Create 3 orders using the overloaded constructor to give each a name for the order.
        
        Order baristaOrder3 = new Order("Jimmy");
        
        Order baristaOrder4 = new Order("Timmy");
        
        Order baristaOrder5 = new Order("Kimmy");

        // Add at least 2 items to each of the orders using the addItem method you wrote, for example, to add item1 to order3 you would need to call the addItem method from the order3 instance like so: order3.addItem(item1);
        
        baristaOrder1.addItem(item2);
        baristaOrder1.addItem(item1);

        baristaOrder2.addItem(item3);
        baristaOrder2.addItem(item3);

        baristaOrder3.addItem(item1);
        baristaOrder3.addItem(item4);

        baristaOrder4.addItem(item2);
        baristaOrder4.addItem(item2);

        baristaOrder5.addItem(item1);
        baristaOrder5.addItem(item4);

        // Test the results and the display method by calling the display method on all of your orders, like so: order3.display();
        
        baristaOrder1.display();
        System.out.print("\n");
        baristaOrder2.display();
        System.out.print("\n");
        baristaOrder3.display();
        System.out.print("\n");
        baristaOrder4.display();
        System.out.print("\n");
        baristaOrder5.display();

        // Test your getStatusMessage functionality by setting some orders to ready and printing the messages for each order. For example: order2.setReady(true); System.out.println(order2.getStatusMessage());

        System.out.print("\n");
        baristaOrder1.setReady(false);
        System.out.println(baristaOrder1.getStatusMessage());
        baristaOrder2.setReady(true);
        System.out.println(baristaOrder2.getStatusMessage());
        baristaOrder3.setReady(true);
        System.out.println(baristaOrder3.getStatusMessage());
        baristaOrder2.setReady(false);
        System.out.println(baristaOrder4.getStatusMessage());
        baristaOrder2.setReady(true);
        System.out.println(baristaOrder5.getStatusMessage());

        // Implement the getOrderTotal method within the Order class
        // Test the total by printing the return value like so: System.out.println(order1.getOrderTotal());
        System.out.print("\n");
        System.out.println(baristaOrder4.getOrderTotal());
    }
}
