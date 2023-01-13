// package Java.Practice_Assignments.AlfredBot;

import java.util.Date;

public class AlfredQuotes {
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name, String dayPeriod
    ) {
        // YOUR CODE HERE
        return "Hello " + name  + ".lovely to see you. " + "Its a beautiful " + dayPeriod;
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE 
        // can use the .format for string interpolation
        Date date = new Date();
        return "Its currently " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        if(conversation.indexOf("Alexis")> -1){
            return conversation;
        }
        if(conversation.indexOf("Alfred")> -1){
            return conversation;
        }
        return conversation;
    }

    public String emotions(String feelings){
        if (feelings.indexOf("angry")>-1){
            return feelings;
        }
        if (feelings.indexOf("happy")>-1){
            return feelings;
        }
        return feelings;
    }
    
    public String age(int age){
        return "I am " + age;
        
    }

    
}


