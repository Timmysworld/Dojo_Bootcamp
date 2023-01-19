import java.util.ArrayList;
    
// Here we're creating a new data type called Order
public class Order {
    
    // MEMBER VARIABLES(ATTRIBUTES)
    private String name; // default value of null
    private boolean isReady; // default value false
    private ArrayList<Item> items; // defaults to null
    
    // CONSTRUCTOR - gets executed ONLY when object is created
    // No arguments, sets name to "Guest", initializes items as an empty list.
    public Order(){
        this.name = "Guest";
        this.items = new ArrayList<Item>();
    }
    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    public Order(String name){
        this.name = name;
        this.items = new ArrayList<Item>();
    }
    
    	// Most of your code will go here, 
    	// so implement the getters and setters first!
    
    // GETTERS & SETTERS - used to get information from member variables
    public String getName(){
        return this.name;
    }
    public boolean getReady(){
        return this.isReady;
    }
    public ArrayList<Item>getItems(){
        return this.items;
    }
        //SETTERS
    public void setName(String name){
        this.name = name;
    }

    public void setReady(Boolean isReady){
        this.isReady = isReady;
    }

    public void setItems(ArrayList<Item> items){
        this.items = items;
    }

     // OTHER ORDER METHODS - Does not have to have same name as class and can be use multiple times on an object
    public void addItem(Item item){
        items.add(item);
    }

    public String getStatusMessage(){
        if (isReady){
            return "Your order is ready.";
        }
        return "Thank you for waiting. Your order will be ready soon.";
    }

    public double getOrderTotal(){
        double total = 0.0;
        for(Item item : items){
            total += item.getPrice();
        }
        return total;
    }

    public void display(){
        System.out.println("Customer Name: "+ this.name);
        for(Item item : items){
            System.out.println(item.getName()+" - $"+item.getPrice());
        }
        System.out.println("Total: $ " + getOrderTotal());
    }



}


