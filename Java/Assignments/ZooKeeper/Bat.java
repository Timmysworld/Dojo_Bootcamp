public class Bat extends Mammal {
    //ATTRIBUTES
    private boolean isFlying;
    private int eatHumans;
    private String attackTown;

    //CONSTRUCTOR
    public Bat(){
        super();
        this.energyLevel = 300;
    }
    public Bat(Boolean isFlying, int energyLevel){
        super();
        this.isFlying = false;
    }
    public Bat(int eatHumans, int energyLevel){
        super();
        this.eatHumans = 0;
    }
    public Bat(String attackTown, int energyLevel){
        super();
        this.attackTown = attackTown;
    }

    //GETTERS & SETTERS
    public boolean getIsFlying(){
        return this.isFlying;
    }
    public void setIsFlying(Boolean isFlying){
        this.isFlying = isFlying;
    }

    public int getEatHumans(){
        return this.eatHumans;
    }
    public void setEatHumans(int amount){
        this.eatHumans = amount;
    }

    public String getAttackTown(){
        return this.attackTown;
    }
    public void setAttackTown(String word){
        this.attackTown = word;
    }

    //OTHER METHODS
    public void isFlying(boolean flying){
        if (flying = true){
            System.out.println("Whoooosh");
            energyLevel -=50;
        }else {
            System.out.println("No flight time");
        };
    }
    public void eatHumans(int number){
        energyLevel +=25 * number;
        System.out.println("mmmm Deliciosooo, I just ate " + number + " humans!");
    }

    public void attackTown(String word, int number){
        if( word == "hit"){
            System.out.println("HIT");
            energyLevel -=100 * number;
        }else{
            System.out.println("Missed");
            energyLevel-=number * number;
        }
        
    }

}
