
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item();
        item1.name = "mocha";
        item1.price = 5.00;

        Item item2 = new Item();
        item2.name = "latte";
        item2.price = 2.50;

        Item item3 = new Item();
        item3.name = "drip coffee";
        item3.price = 1.50;

        Item item4 = new Item();
        item4.name = "cappucino";
        item4.price = 3.00;

    
        // Order variables -- order1, order2 etc.
        Order Order1 = new Order();
        Order1.name = "Cindhuri"; 
        
        Order Order2 = new Order();
        Order2.name = "Jimmy"; 

        Order Order3 = new Order();
        Order3.name = "Noah";

        Order Order4 = new Order();
        Order4.name = "Sam"; 
        
        // Application Simulations
        Order2.items.add(item1);
        Order2.total += item1.price;

        Order3.items.add(item4);
        Order3.total += item3.price;

        Order4.items.add(item2);
        Order4.total += item2.price;
        Order4.items.add(item2);
        Order4.total += item2.price * 2;

        Order1.ready = true;
        Order2.ready = true;

        // Use this example code to test various orders' updates
        System.out.println("---ORDER 1 ---");
        System.out.printf("Name: %s\n", Order1.name);
        // System.out.printf("Total: %s\n", Order1.total);
        System.out.printf("Ready: %s\n", Order1.ready);
        System.out.printf( "\n");

        System.out.println("---ORDER 2 ---");
        System.out.printf("Name: %s\n", Order2.name);
        System.out.printf("Total: %s\n", Order2.total);
        System.out.printf("Ready: %s\n", Order2.ready);
        System.out.printf( "\n");

        System.out.println("---ORDER 3 ---");
        System.out.printf("Name: %s\n", Order3.name);
        System.out.printf("Total: %s\n", Order3.total);
        System.out.printf( "\n");

        System.out.println("---ORDER 4 ---");
        System.out.printf("Name: %s\n", Order4.name);
        System.out.printf("Total: %s\n", Order4.total);
    }
}
