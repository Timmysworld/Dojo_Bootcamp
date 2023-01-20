import java.util.Random;
public class BankAccount {
        //ATTRIBUTES
    private double checkingBalance;
    private double savingsBalance;
    private int accountNumber;

        // STATIC METHOD TO TRACK THE TOTAL BALANCE OF MONEY WITHIN EVERY ACCOUNT & THE NUMBER OF ACCOUNTS CREATED 
    public static int totalBalance = 0;
    public static int numberOfAccounts  = 0; 

        // GENERATES RANDOM ACCOUNT NUMBER
    private static int rndAcctNumber(){
        Random rnd = new Random();
        int nxt = rnd.nextInt(1000000000) + (999999999);
        return nxt;

    }

        // CONSTRUCTOR METHOD  
    public BankAccount (){
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        this.accountNumber  = BankAccount.rndAcctNumber();
        numberOfAccounts++;
        totalBalance++;
    }
    
    // SETTERS AND GETTERS FOR BOTH CHECKING AND SAVINGS ACCOUNTS
        // For Account Number
    public int getAccountNumber(){
        return this.accountNumber;
    }

        // For Checking Account
    public double getCheckingBalance(){
        return this.checkingBalance;
    }
    public void setCheckingBalance(double checking){
        this.checkingBalance = checking;
    }

        //For Saving Account
    public double getSavingsBalance(){
        return this.savingsBalance;
    }
    public void setSavingsBalance(double savings){
        this.savingsBalance = savings;
    }


    // OTHER METHODS TO ACCESS THE BANK ACCOUNT CLASS
    public void deposit(double amount, String accountType){
        if(accountType.equals("savings"))
            this.savingsBalance += amount;
        else if(accountType.equals("checking"))
            this.checkingBalance += amount;
        BankAccount.totalBalance += amount;
}

    public void withdraw(double amount, String accountType){
        boolean successful  = false;
        if (accountType.equals("savings")){
            if( this.savingsBalance - amount >=0 ){
                successful = true;
                this.savingsBalance -=amount;
            }
        }else if(accountType.equals("checking")){
            if( this.checkingBalance - amount >= 0){
                successful = true; 
                this.checkingBalance -= amount;
            }
        }if (successful){
            BankAccount.totalBalance -= amount;
        }else{
            System.out.println("Insufficient Funds!");
        }
    }

    public void displayAccountBalance(){
        System.out.println(String.format("Savings: %.2f, Checking: %.2f", this.savingsBalance, this.checkingBalance));
    }

}


