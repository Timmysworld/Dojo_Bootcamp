class User: 

    def __init__(self,name, email):
        self.name = name
        self.email = email
        self.account = { # when creating a user it automatically creates an instances of bank account
            'Checking': BankAccount(int_rate=0.2, balance = 0), 
            'Savings': BankAccount(int_rate=0.2, balance = 0)
            }

    def display_account_info(self):
        print(f"===========================================")
        print(f"User: {self.name}")
        print(f"Checking: ${self.account['Checking'].balance}")
        print(f"Savings: ${self.account['Savings'].balance}")
        print(f"===========================================")
        return self

    def make_deposit(self,amount,account_name):
        self.account[account_name].deposit(amount)
        return self

    def make_withdraw(self,amount,account_name):
        self.account[account_name].withdraw(amount,account_name)
        return self
    
    def transfer_money(self,account_name, amount, other_user, to_account):
            self.account[account_name].withdraw(amount,account_name)  
            other_user.account[to_account].deposit(amount)
            print(f"You've transfer ${amount} to {other_user.name}'s {to_account}")
            return self

    
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

    def withdraw(self, amount,account_name):
        if BankAccount.can_withdraw(self.balance,amount): # with Static method all bank accounts can be checked for insufficient funds.
            self.balance -= amount
            print(f"You've withdrawn: ${amount} from {account_name}")
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

user1 = User("Timothy", "t.singleton89@hotmail.com")
# user1.display_account_info().make_deposit(100.00, "Checking").make_deposit(150.00, "Savings").make_withdraw(25.00, "Checking").display_account_info()
user2 =User("John","John.Doe@email.com")

user2.display_account_info().make_deposit(100.00, "Checking").display_account_info().make_withdraw(25.00,"Checking").transfer_money("Checking", 25.00, user1, "Savings").display_account_info()
user1.display_account_info()
# user1.display_account_info()
# user2.display_account_info()
# account_name, amount, other_user, to_account



# checking = BankAccount(0.10, 500.00)
# checking.display_account_info().withdraw(100.00).yield_interest()

# savings = BankAccount(0.1, 1000.00)
# savings.display_account_info().withdraw(100.00).yield_interest()

# calling the Method total_accounts (class.method)
# print(f"Total Cash: ${BankAccount.total_accounts()}")



#Update the User class __init__ method

# Add a make_deposit method to the User class that calls on it's bank account's instance methods.

# Add a make_withdrawal method to the User class that calls on it's bank account's instance methods.

# Add a display_user_balance method to the User class that displays user's account balance

# SENSEI BONUS: Allow a user to have multiple accounts; update methods so the user has to specify which account they are withdrawing or depositing to

# SENPAI BONUS: Add a transfer_money(self, amount, other_user) method to the user class that takes an amount and a different User instance, and transfers money from the user's account into another user's account.