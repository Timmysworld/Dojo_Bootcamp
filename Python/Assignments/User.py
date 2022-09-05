from pickle import TRUE
from tkinter import FALSE

# For this assignment you will create the user class and add a couple methods!

class User:
    def __init__(self,first_name,last_name,email,age,is_rewards_member, gold_card_points):
        self.first_name = first_name
        self.last_name = last_name
        self.email = email
        self.age = age
        self.is_rewards_member = is_rewards_member
        self.gold_card_points = gold_card_points

    def display_info(self):
        print(f"First Name: {self.first_name}")
        print(f"Last Name: {self.last_name}")
        print(f"Email:{self.email}")
        print(f"Age:{self.age}")
        print(f"Rewards Member: {self.is_rewards_member}")
        print(f"Gold Points:{self.gold_card_points}")
        print(f"========================================")

    def enroll(self):
        if (self.is_rewards_member) == False:
            self.is_rewards_member = True 
            self.gold_card_points = 200 
            return True
        else:
            print("Already a Member")
            return False

    def spend_points(self, amount):
        if (amount > 200):
            self.gold_card_points = amount - 200
        elif (amount == 200):
            print(f"Watch your spending {self.first_name}")
        else:
            print(f"Sorry you don't have enough point to spend {self.first_name}")

                
            

Anonymous_User = User("John","Doe","John.D@hotmail.com",32,"False",0)
Anonymous_User.display_info()
Anonymous_User.enroll()
Anonymous_User.display_info()
# Anonymous_User.spend_points(100)
# Anonymous_User.display_info()


