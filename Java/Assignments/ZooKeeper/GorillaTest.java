public class GorillaTest {
    public static void main(String[] arg){
        Gorilla g = new Gorilla();
        g.displayEnergy(0);
        g.throwSomething("ball");
        g.throwSomething("block");
        g.throwSomething("toy");
        // g.displayEnergy(0);

        g.eatBananas(3);
        // g.displayEnergy(0);

        boolean climb = g.climb("tree");

        if (climb){
            System.out.println("Gorilla climb a tree!");
        }
        
        g.displayEnergy(0);
    }
    
}
