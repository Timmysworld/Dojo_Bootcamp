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
    def __init__( self , data ):
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
        if len(user['fname'])<3:
            flash("First Name needs to be at least 3 characters.","register")
            is_valid = False
        if len(user['lname'])<3:
            flash("Last Name needs to be at least 3 characters.","register")
            is_valid = False
        if len(user['email']) == 0 or not EMAIL_REGEX.match(user['email']): 
            flash("Invalid email address!","register")
            is_valid = False
        if len(user['password'])<10:
            flash("Password must be at least 10 characters.","register")
            is_valid = False
        if user['confirmpass'] != user['password']:
            flash('Password does not Match Try again',"register")
            is_valid = False
        # if user is not False:
        #     flash("email is already in use!!", "register")
        #     is_valid = False
        return is_valid

    @classmethod
    def save(cls,data):
        query = """
        INSERT INTO users (first_name, last_name,email, password)
        VALUES (%(fname)s,%(lname)s,%(email)s, %(password)s)
        ;"""
        return connectToMySQL("Register_login").query_db(query, data)

    @classmethod
    def get_by_email(cls,data):
        query = "SELECT * FROM users WHERE email = %(email)s;"
        result = connectToMySQL("Register_login").query_db(query,data)
        # Didn't find a matching user
        if len(result) < 1:
            return False
        return cls(result[0])

#for dashboard route
    @classmethod
    def get_by_id(cls, id):
        data = {"id": id}
        query = "SELECT * FROM users WHERE id = %(id)s;"
        result = connectToMySQL("Register_login").query_db(query,data)
        return cls(result[0])