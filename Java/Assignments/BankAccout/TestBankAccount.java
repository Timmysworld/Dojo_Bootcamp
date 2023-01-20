public class TestBankAccount {
    
    public static void main(String[] args){
        BankAccount MyBank = new BankAccount();
        System.out.println("New Acc No. - " + MyBank.getAccountNumber());

        MyBank.deposit(200.49, "checking");
		MyBank.deposit(3.00, "savings");
        System.out.println(BankAccount.totalBalance);
        System.out.println(BankAccount.numberOfAccounts);

		MyBank.withdraw(50, "checking");
		// MyBank.withdraw(50, "savings");
		MyBank.displayAccountBalance();

	}
}
