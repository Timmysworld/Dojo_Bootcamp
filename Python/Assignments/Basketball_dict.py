# #List of Players Dictionary
players = [
    {
    	"name": "Kevin Durant", 
    	"age":34, 
    	"position": "small forward", 
    	"team": "Brooklyn Nets"
    },
    {
    	"name": "Jason Tatum", 
    	"age":24, 
    	"position": "small forward", 
    	"team": "Boston Celtics"
    },
    {
    	"name": "Kyrie Irving", 
    	"age":32, 
        "position": "Point Guard", 
    	"team": "Brooklyn Nets"
    },
    {
    	"name": "Damian Lillard", 
    	"age":33, 
        "position": "Point Guard", 
    	"team": "Portland Trailblazers"
    },
    {
    	"name": "Joel Embiid", 
    	"age":32, 
        "position": "Power Forward", 
    	"team": "Philadelphia 76ers"
    },
    {
    	"name": "Kobe Bryant", 
    	"age":38, 
    	"position": "Point Guard", 
    	"team": "LA Lakers"
    }
]

# Assignment Tasks
# Challenge 1: Update the Constructor
# Update the constructor to accept a dictionary with a single player's information instead of individual arguments for the attributes.

# Challenge 2: Create instances using individual player dictionaries.
# Given these variables, create Player instances for each of the following dictionaries. Be sure to instantiate these outside the class     definition, in the outer scope.

# Challenge 3: Make a list of Player instances from a list of dictionaries
# Finally, given the example list of players at the top of this module (the one with many players) write a for loop that will populate an empty list with Player objects from the original list of dictionaries.

# NINJA BONUS: Add a get_team(cls, team_list) @class method
# Add an @class method called get_team(cls, team_list) that, given a list of dictionaries populates and returns a new list of Player objects. Be sure to test your method!

class Player:

    # new class attribute - a list of all the players
    the_dream_team = []

    def __init__(self, data):
        self.name = data['name']
        self.age = data['age']
        self.position = data['position']
        self.team = data['team']
        
        

    def display_player_info(self): #instances method
        print(f"=========================================")
        print(f"Name: {self.name}")
        print(f"Age: {self.age}")
        print(f"Position: {self.position}")
        print(f"Team: {self.team}")
        print(f"=========================================")
        return self
    
    @classmethod
    def draft_pick(cls, data): # Adding to a List 
        for team in data:
            Player.the_dream_team.append(Player(team)) 

    @classmethod
    # Showing a Roster of Team members
    def my_roster(cls): #instances method 
        for player in cls.the_dream_team:
            print(f"Roster:")
            print(f"Name: {player.name}\nTeam: {player.team}")
            print(f"=========================")

#CREATE PLAYERS 
# Player 1-6 = Class Instances 
player1 = Player(players[0])
# player1.display_player_info()
player2 = Player(players[1])
# player2.display_player_info()
player3 = Player(players[2])
# player3.display_player_info()
player4 = Player(players[3])
# player4.display_player_info()
player5 = Player(players[4])
# player5.display_player_info()
player6 = Player(players[5])
# player6.display_player_info()

player1.draft_pick(players)
Player.my_roster()




