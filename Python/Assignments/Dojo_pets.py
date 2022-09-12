
class Ninja:
    def __init__(self, first_name , last_name):
        self.first_name = first_name
        self.last_name = last_name
        # self.pet_name = pet_name
        # self.treats = treats
        # self.pet_food = pet_food
        
    def display_info(self):
        print(f"===========================")
        print(f"Owner: {self.first_name} {self.last_name}")
        # print(f"Pet: {self.pet_name}")
        # print(f"===========================")

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
        if self.health <= 25 and self.health < 50:
            self.health += level
            self.energy = "low"
            print(f"{self.name} is feeling sick go see a vet.")
        elif self.health == 50 and self.health <= 75:
            self.health += level
            self.energy = "Medium"
            print(f"{self.name} is feeling tired let him REST.")
        elif self.health >= 75 and self.health == 100:
            self.health += level 
            self.energy = "high"
            print(f"{self.name} is feeling like a Champ go play")
        # self.health += level
        return self

    def sleep(self, level):
        if Pet.can_sleep(self.energy):
            self.energy += level
        return self

        
    def eat(self):
        pass
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

        
    @staticmethod
    def can_sleep(time):
        if time > 0:
            return False
        else:
            return True


#CREATE NINJA 
# pet_owner1 = Ninja('Timothy', 'Singleton')
# pet_owner1.display_info()

#CREATE PET
pet1 = Pet('Stitch','Dog',100,'sit')
pet1.display_pet_info().pet_health(50)


# # implement the following methods:
# # sleep() - increases the pets energy by 25
# # eat() - increases the pet's energy by 5 & health by 10
# # play() - increases the pet's health by 5
# # noise() - prints out the pet's sound
