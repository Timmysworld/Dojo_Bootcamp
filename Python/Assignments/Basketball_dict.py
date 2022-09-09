# #List of Players Dictionary
# players = [
#     {
#     	"name": "Kevin Durant", 
#     	"age":34, 
#     	"position": "small forward", 
#     	"team": "Brooklyn Nets"
#     },
#     {
#     	"name": "Jason Tatum", 
#     	"age":24, 
#     	"position": "small forward", 
#     	"team": "Boston Celtics"
#     },
#     {
#     	"name": "Kyrie Irving", 
#     	"age":32, "position": "Point Guard", 
#     	"team": "Brooklyn Nets"
#     },
#     {
#     	"name": "Damian Lillard", 
#     	"age":33, "position": "Point Guard", 
#     	"team": "Portland Trailblazers"
#     },
#     {
#     	"name": "Joel Embiid", 
#     	"age":32, "position": "Power Foward", 
#     	"team": "Philidelphia 76ers"
#     },
#     {
#     	"name": "", 
#     	"age":16, 
#     	"position": "P", 
#     	"team": "en"
#     }
# ]

# Assignment Tasks
# Challenge 1: Update the Constructor
# Update the constructor to accept a dictionary with a single player's information instead of individual arguments for the attributes.

class Player:
    def __init__(self, name, age, position, team):
        self.name = name
        self.age = age
        self.position = position
        self.team = team
        self.player_info = {
            'name':self.name,
            'age': self.age,
            'position': self.position,
            'team': self.team,
        }
        self.fantasy_team = []

        # self.player_info = {
        #     'name':[],
        #     'age': [],
        #     'position': [],
        #     'team': [],
        # }

    def display_player_info(self):
        print(f"=========================================")
        print(f"Name: {self.player_info['name']}")
        print(f"Age: {self.player_info['age']}")
        print(f"Position: {self.player_info['position']}")
        print(f"Team: {self.player_info['team']}")
        print(f"=========================================")
        return self

    #USE THIS FUNCTION IF YOU WANTED TO CREATE A LIST WITH IN THE DICT PLAYER_INFO
    # def record_player_info(self):
    #     self.player_info['name'].append(self.name)
    #     self.player_info['age'].append(self.age)
    #     self.player_info['position'].append(self.position)
    #     self.player_info['team'].append(self.team)
    #     return self

    def pick_team(self,draft_pick):
        if type(draft_pick) is dict:
            for i in range(len(draft_pick)):
                self.fantasy_team.append(draft_pick[i])
            print(self.fantasy_team)
    
    # def display_my_team(self):


#CREATE PLAYERS
player1 = Player("Kevin Durant","34", "Small Forward", "Brooklyn Nets")
player2 = Player("Jason Tatum","24","Small Forward","Boston Celtics")
player3 = Player("kyrie Irving","32","Point Guard","Brooklyn Nets")

player1.display_player_info().pick_team(player1)
print(self.fantasy_team)
# player2.display_player_info()
# player3.display_player_info()

#CALLING PLAYERS INFORMATION WHEN USING THE RECORD_PLAYER_INFO 
# player1.record_player_info().display_player_info()
# player2.record_player_info().display_player_info()
# player3.record_player_info().display_player_info()

# print(player1.player_info["team"][0])
# print(player1.display_player_info())


