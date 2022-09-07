class BankAccount:
    # new class attribute - a list of all the accounts!
    # all_accounts = []

    def __init__(self, int_rate, balance): 
        self.int_rate = int_rate
        self.balance = balance
        # BankAccount.all_accounts.append(self)
        return None

    def deposit(self, amount):
        self.balance += amount
        return self

    def display_account_info(self):
        print(f" Account Balance: ${self.balance}")
        return self

    def withdraw(self, amount):
        if self.balance > amount:
            self.balance -= amount
            # print(f"You've withdrawn: $ ")
        else: 
            print(f"Insufficient Funds ${self.balance}")
        return self

    def yield_interest(self):
        if self.balance == self.balance:
            self.balance += 0.1
            print(f"Your new balance is: ${self.balance}")
        else:
            # if self.balance:
                print(f"Sorry your account is Negative")
        return self

checking = BankAccount(0.1, 500.00)
checking.display_account_info().withdraw(100).yield_interest()

savings = BankAccount(0.1, 1000.00)
savings.display_account_info().withdraw(1000).yield_interest()

# QUESTIONS TO ASK:
# Can not seem to get the logic to test if self.balance is a negative number or see that account has insufficient funds and can not yield interest on account.
# want to figure out how to show the amount withdrawn in print statement 
