
public class AlfredTest {
    /*
    * This main method will always be the launch point for a Java application
    * For now, we are using the main to test all our 
    * AlfredQuotes methods.
    */
    public static void main(String[] args) {
        // Make an instance of AlfredQuotes to access all its methods.
        AlfredQuotes alfredBot = new AlfredQuotes();
        
        // Make some test greetings, providing any necessary data
        String testGreeting = alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("Beth Kane", "Thursday");
        String testDateAnnouncement = alfredBot.dateAnnouncement();
        
        String alexisTest = alfredBot.respondBeforeAlexis(
                            "Alexis! Play some low-fi beats."
                            );
        String alfredTest = alfredBot.respondBeforeAlexis(
            "I can't find my yo-yo. Maybe Alfred will know where it is.");

        String notRelevantTest = alfredBot.respondBeforeAlexis(
            "Maybe that's what Batman is about. Not winning. But failing.."
        );

        // ALFRED's FEELINGS 
        String angry = alfredBot.emotions(
            "I am feeling pretty angry today!");

        String happy = alfredBot.emotions("I am feeling happy today! What can I do for you today?");
        
        String normal =  alfredBot.emotions(
            "My feelings are meh, What you need Batman?");
        
        // ALFRED's Age 
        String age = alfredBot.age(
            22
        );

        // Print the greetings to test.
        // System.out.println(testGreeting);
        
        // Uncomment these one at a time as you implement each method.
        // System.out.println(testGuestGreeting);
        // System.out.println(testDateAnnouncement);
        // System.out.println(alexisTest);
        // System.out.println(alfredTest);
        // System.out.println(notRelevantTest);
        // System.out.println(angry);
        // System.out.println(happy);
        // System.out.println(normal);
        // System.out.println(age);
    }
}

