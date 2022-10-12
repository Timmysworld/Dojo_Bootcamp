from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
from flask_app import app 
from flask_app.models import user

class Recipe:
    db ="recipe"
    def __init__(self,data):
        self.id = data['id']
        self.name = data['name']
        self.description = data['description']
        self.under_thirty = data['under_thirty']
        self.instructions = data['instructions']
        self.recipe_date = data['recipe_date']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.user_id = data["user_id"]
        self.user = None # accesses the User class

    @staticmethod
    def validate_recipes(recipe):
        is_valid = True
        if len(recipe['name'])< 5:
            flash("Name needs to be at least 5 character.", "recipe")
            is_valid = False
        if len(recipe['description']) == 0:
            flash("You must describe your dish.","recipe")
            is_valid = False
        if len(recipe['instructions']) == 0:
            flash("Please add how to instructions", "recipe")
            is_valid = False
        if not recipe['recipe_date']:
            flash("Date cooked must be added", "recipe")
            is_valid = False
        return is_valid

    @classmethod
    def create_recipe(cls, data):
        query = """
        INSERT INTO recipes (name,description,under_thirty,instructions,recipe_date,user_id)
        Values (%(name)s, %(description)s, %(under_thirty)s, %(instructions)s, %(recipe_date)s, %(user_id)s);"""
        return connectToMySQL(cls.db).query_db(query,data)
    
    @classmethod
    def get_all_recipes(cls):
        query = """
        SELECT * FROM recipes 
        JOIN users ON recipes.user_id = users.id;
        """
        results = connectToMySQL(cls.db).query_db(query)
        recipes= []
        
        for recipe in results: #class association
            this_recipe = cls(recipe)
            this_user = user.User.get_by_id(recipe["user_id"])
            this_recipe.user = this_user
            recipes.append(this_recipe)
        return recipes

    @classmethod
    def get_recipe(cls,recipe_id):
        data = {"id": recipe_id}
        query = """
        SELECT * FROM recipes 
        JOIN users ON recipes.user_id = users.id 
        WHERE recipes.id = %(id)s;
        """
        results = connectToMySQL(cls.db).query_db(query,data)
        recipe = cls(results[0])
        return recipe

    @classmethod
    def update_recipe(cls,data):
        query = """
        UPDATE recipes SET 
        name = %(name)s, description = %(description)s, recipe_date = %(recipe_date)s, instructions = %(instructions)s, under_thirty = %(under_thirty)s 
        WHERE recipes.id = %(id)s;
        """
        return  connectToMySQL(cls.db).query_db(query,data)

    @classmethod
    def delete_recipe(cls,recipe_id):
        data = {"id":recipe_id}
        query = """
        DELETE FROM recipes WHERE id=%(id)s;
        """
        return connectToMySQL(cls.db).query_db(query,data)

