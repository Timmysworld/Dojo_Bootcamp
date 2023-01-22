// package Java.Assignments.ZooKeeper;
public class Gorilla extends Mammal{
    //ATTRIBUTES
    private String throwSomething;
    private int eatBananas;
    private boolean climb;
    public String item;

    //CONSTRUCTOR
    public Gorilla(){
        super();
    }

    public Gorilla(String throwSomething, int energyLevel){
        super();
        this.throwSomething = throwSomething;
    }
    public Gorilla(int eatBananas, int energyLevel){
        super();
        this.eatBananas = 0;
    }
    public Gorilla(boolean climb, int energyLevel){
        super();
        this.climb = climb;
    }

    //GETTERS & SETTERS

        //THROW
    public String getThrowSomething(){
        return this.throwSomething;
    }
    public void setThrowSomething(String item){
        this.item = item;
    }

        //BANANAS
    public int getEatBananas(){
        return this.eatBananas;
    }

    public void setEatBananas(String item){
        this.item = item;
    }
        //CLIMB 
    public boolean climb(){
        return this.climb;
    }
    public void setClimb(boolean climb){
        this.climb = climb;
    }

    //OTHER METHODS TO ACCESS THE CLASS
    public void throwSomething(String item){
        System.out.println("Gorilla threw  " + item + " at human");
        energyLevel -=5;
    }

    public void eatBananas(int num){
        energyLevel+=10 * num;
        System.out.println("Gorilla ate " + num + " bananas" );
    }

    public boolean climb(String item){
        System.out.println("Gorilla climb a " + item + "!");
        energyLevel-=10;
        return climb;
    }

    

}
