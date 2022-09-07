class BankAccount:
    # new class attribute - a list of all the accounts!
    all_accounts = []

    def __init__(self, int_rate, balance): 
        self.int_rate = int_rate
        self.balance = balance
        BankAccount.all_accounts.append(self)


    def deposit(self, amount):
        self.balance += amount
        return self

    def display_account_info(self):
        print(f"Account Balance: ${self.balance}")
        return self

    def withdraw(self, amount):
        if BankAccount.can_withdraw(self.balance,amount): # with Static method all bank accounts can be checked for insufficient funds.
            self.balance -= amount
            print(f"You've withdrawn: ${amount} ")
        else: 
            print(f"Insufficient Funds ${self.balance}")
        return self

    def yield_interest(self):
        if self.balance == 0:
                print(f"Sorry your account is Negative")
        elif self.balance == self.balance:
            self.balance += 0.10
            print(f"Your new balance is: ${self.balance}")
        return self
        
# static methods have no access to any attribute
# only to what is passed into it
    @staticmethod
    def can_withdraw(balance,amount):
        if (balance - amount) < 0:
            return False
        else:
            return True

    @classmethod 
    def total_accounts(cls):
        sum = 0
        for account in cls.all_accounts:
            sum += account.balance
        return sum

checking = BankAccount(0.10, 500.00)
checking.display_account_info().withdraw(100.00).yield_interest()

savings = BankAccount(0.1, 1000.00)
savings.display_account_info().withdraw(100.00).yield_interest()

# calling the Method total_accounts (class.method)
print(f"Total Cash: ${BankAccount.total_accounts()}")
# x = BankAccount.total_accounts()
# print(x)


