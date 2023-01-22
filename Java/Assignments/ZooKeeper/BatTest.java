public class BatTest {
    public static void main(String[] args){
        Bat b = new Bat();
        b.displayEnergy(0);
        b.isFlying(true);
        b.attackTown("hit", 3);
        b.eatHumans(3);
        b.displayEnergy(0);
    }

}
