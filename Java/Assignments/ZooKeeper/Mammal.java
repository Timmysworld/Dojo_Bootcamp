public class Mammal{
    //ATTRIBUTES
    protected int energyLevel;
    
    //CONSTRUCTOR 
    public Mammal(){
        this.energyLevel = 100;
    }

    //SETTERS & GETTERS
    public int getEnergyLevel(){
        return this.energyLevel;
    }

    public void setEnergyLevel(int energy){
        this.energyLevel = energy;
    }

    //OTHER METHODS TO ACCESS THE CLASS 
    public void displayEnergy(int energy){
        System.out.println(String.format("Current Energy Level:  %s", + this.energyLevel));
    }

}