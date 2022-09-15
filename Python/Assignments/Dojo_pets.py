
class Ninja:
    def __init__(self, first_name , last_name):
        self.first_name = first_name
        self.last_name = last_name
        self.pet = {
            'dog': Pet(name="", type="", health="", tricks="" )
        }
        # self.pet_name = pet_name
        # self.treats = treats
        # self.pet_food = pet_food
        
    def display_info(self):
        print(f"===========================")
        print(f"Owner: {self.first_name} {self.last_name}")
        # print(f"Pet: {self.pet_name}")
        # print(f"===========================")
    def walk(self):
        return self 
# implement the following methods:
# walk() - walks the ninja's pet invoking the pet play() method
# feed() - feeds the ninja's pet invoking the pet eat() method
# bathe() - cleans the ninja's pet invoking the pet noise() method


class Pet:
    def __init__(self, name , type, health, tricks ):
        self.name = name
        self.type = type
        self.health = health
        self.energy = "high"
        self.tricks = tricks

    def pet_health(self,level):
        if  self.health <= 25:
            self.health = level
            # self.energy = "low"
            print(f"{self.name} is feeling sick go see a vet.")
        

        # if self.health == 75 and self.health >= 50:
        #     self.health = level
        #     self.energy = "medium"
        #     print(f"{self.name} is feeling tired let him REST.")
        # elif self.health < 50: 
        #     self.health = level
        #     self.energy = "low"
        #     print(f"{self.name} is feeling sick go see a vet.")
        # elif self.health == 100:
        #     self.health = level
        #     self.energy = "high"
        #     print(f"{self.name} is feeling like a Champ go play")

            
        # self.health += level
        return self

    def sleep(self, time):
        if Pet.can_sleep(time):
            self.health -= time * 5
            print(f"{self.name} needs some rest")
        else: 
            print(f"{self.name} slept good, time to play")
        return self

    def eat(self, amount):
        if Pet.feeding(amount):
            self.energy = "low"
            print(f"{self.name} needs to eat! ")
        else:
            self.energy = "high"
            print(f"{self.name} Ate pretty good")
        return self
        
    def play(self):
        
        pass
    
    def display_pet_info(self):
        # print(f"===========================")
        print(f"Pet Name: {self.name}")
        print(f"Pet Type: {self.type}")
        print(f"Pet Health: {self.health}")
        print(f"Energy Levels: {self.energy}")
        print(f"Tricks: {self.tricks}")
        print(f"===========================")
        return self
        
    @staticmethod
    def can_sleep(time):
        if time < 13:
            return True
        else:
            return False

    def feeding(amount):
        if amount <= 2.5: # amount is in cups 
            return True
        else: 
            return False
#CREATE NINJA 
pet_owner1 = Ninja('Timothy', 'Singleton')
# pet_owner1.display_info()

#CREATE PET
pet1 = Pet('Stitch','Dog',100,'sit')
pet1.display_pet_info().sleep(10).display_pet_info()
# pet1.pet_health(25).display_pet_info()


# # implement the following methods:
# # sleep() - increases the pets energy by 25
# # eat() - increases the pet's energy by 5 & health by 10
# # play() - increases the pet's health by 5
# # noise() - prints out the pet's sound

#Attribute ERROR: 'NoneType' object has no attribute ---- Check to see if RETURN SELF is on classes.
