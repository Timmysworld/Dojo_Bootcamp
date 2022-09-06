from pickle import TRUE
from tkinter import FALSE

# For this assignment you will create the user class and add a couple methods!

class User:
    def __init__(self,first_name,last_name,email,age,is_rewards_member,gold_card_points):
        self.first_name = first_name
        self.last_name = last_name
        self.email = email
        self.age = age
        self.is_rewards_member = is_rewards_member
        self.gold_card_points = gold_card_points
        self.member_status = "Entry"

    def display_info(self):
        print(f"First Name: {self.first_name}")
        print(f"Last Name: {self.last_name}")
        print(f"Email:{self.email}")
        print(f"Age:{self.age}")
        print(f"Rewards Member: {self.is_rewards_member}")
        print(f"Gold Points:{self.gold_card_points}")
        print(f"Member Status:{self.member_status}")
        print(f"========================================")

    def enroll(self):
        if self.is_rewards_member == False:
            self.is_rewards_member = True 
            self.gold_card_points = 200 
            self.member_status = "Bronze"
            return True
        else:
            print("Already a Member")
            return False

    def bonus_points(self):
        if self.gold_card_points == 200:
            print(f"In 6 months you will gain more points")
        elif self.gold_card_points < 200:
            self.gold_card_points += 50
            if self.gold_card_points > 200 and self.gold_card_points < 650:
                self.member_status ="Silver"
        elif self.gold_card_points > 200:
            self.gold_card_points += 25
            if self.gold_card_points > 650:
                self.member_status = "Gold"

    def spend_points(self, amount):
        if (amount < self.gold_card_points):
            self.gold_card_points -= amount
        elif (amount == self.gold_card_points):
            print(f"Watch your spending {self.first_name}")
        else:
            print(f"Sorry you don't have enough points to spend {self.first_name}")

                
            

Anonymous_User = User("John","Doe","John.D@hotmail.com",32,False,0)
Anonymous_User2 = User("Tiffany","New","T.New@gmail.com",27,False,0)
Anonymous_User.display_info().enroll().display_info().spend_points(200).display_info()
Anonymous_User2.display_info().enroll().display_info().spend_points(200).display_info()


# Update Code Logic for if user is a member but have no points 
