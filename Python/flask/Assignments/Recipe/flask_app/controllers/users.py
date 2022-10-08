from flask_app import app
from flask import render_template, request, redirect, session, flash
from flask_app.models import user 
from flask_bcrypt import Bcrypt        
bcrypt = Bcrypt(app) 


@app.route('/')
def index():
    return render_template('index.html')


#CREATE --> save(user.py)
@app.route('/register/user', methods = ['POST'])
def register():
    is_user_valid = user.User.validate_user(request.form)
    if not is_user_valid:
        return redirect('/')
    pw_hash = bcrypt.generate_password_hash(request.form['password'])

    data ={
        "fname" : request.form['fname'],
        "lname" : request.form['lname'],
        "email" : request.form['email'],
        "password" : pw_hash
    }

    user_id = user.User.save(data)
    session['user_id'] = user_id
    return redirect('/recipes')


#LOG IN LOG OUT --> get_by_email(user.py)
@app.route('/login', methods = ['POST'])
def login():
    user_in_database = user.User.get_by_email(request.form['email'])
    if not user_in_database:
        flash("Invalid Login Information", "login")
        return redirect('/')
    if not bcrypt.check_password_hash(user_in_database.password,request.form['password']):
        flash("Invalid Login Information", "login")
        return redirect('/')
    session['user_id'] = user_in_database.id
    return redirect('/recipes')
    
@app.route('/logout')
def logout():
    session.clear()
    return redirect('/')