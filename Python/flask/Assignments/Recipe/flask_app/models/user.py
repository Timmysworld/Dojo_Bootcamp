from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
from flask_app import app 
from flask_bcrypt import Bcrypt       
bcrypt = Bcrypt(app) 
import re
# the regex module
# create a regular expression object that we'll use later   
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')


class User:
    db = "recipe"
    def __init__(self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.password = data['password']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @staticmethod
    def validate_user(user):
        is_valid = True 
        user_in_database = User.get_by_email(user["email"])
        if len(user['fname'])<3:
            flash("First Name needs to be at least 3 characters.","register")
            is_valid = False
        if len(user['lname'])<3:
            flash("Last Name needs to be at least 3 characters.","register")
            is_valid = False
        if len(user['email']) == 0 or not EMAIL_REGEX.match(user['email']): 
            flash("Invalid email address!","register")
            is_valid = False
        if user_in_database is not False:
            flash("email is already in use!!!","register")
        if len(user['password'])<10:
            flash("Password must be at least 10 characters.","register")
            is_valid = False
        if user['confirmpass'] != user['password']:
            flash('Password does not Match Try again',"register")
            is_valid = False
        return is_valid
    
    @staticmethod
    def validate_login(user):
        is_valid =True
        user_in_database = User.get_by_email(user["email"])
        if len(user['email']) == 0 or not EMAIL_REGEX.match(user['email']): 
            flash("Invalid email address!","login")
            is_valid = False
        if user_in_database is False:
            flash("Invalid Information","login")
            is_valid = False
        if len(user["password"]) < 10 or not bcrypt.check_password_hash(user_in_database.password,user["password"]):
            flash("Invalid Information","login")
            is_valid = False
        if is_valid:
            return user_in_database
        else:
            return is_valid

    @classmethod
    def save(cls,data):
        query = """
        INSERT INTO users (first_name, last_name,email, password)
        VALUES (%(fname)s,%(lname)s,%(email)s,%(password)s)
        ;"""
        return connectToMySQL(cls.db).query_db(query, data)

    @classmethod
    def get_by_email(cls,email):
        print(email)
        data = {"email": email}
        print(data)
        query = "SELECT * FROM users WHERE email = %(email)s;"
        result = connectToMySQL(cls.db).query_db(query,data)
        print(result)
        # Didn't find a matching user
        if len(result) == 0:
            return False
        else:
            return cls(result[0])

    #for recipe route
    @classmethod
    def get_by_id(cls,id):
        data = {"id":id}
        query = "SELECT * FROM users WHERE id = %(id)s;"
        result = connectToMySQL(cls.db).query_db(query,data)
        return cls(result[0])