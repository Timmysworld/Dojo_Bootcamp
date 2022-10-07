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
    return redirect('/recipe')


@app.route('/recipe/new', methods = ['POST'])
def new_recipe():
    return


#READ --> get_by_id(user.py)
@app.route('/recipe')
def dashboard():
    if "user_id" not in session:
        return redirect('/')
    logged_in_user = user.User.get_by_id(session["user_id"])
    return render_template('recipes.html', logged_in_user = logged_in_user)

#UPDATE

#DELETE

#LOG IN LOG OUT --> get_by_email(user.py)
@app.route('/login', methods = ['POST'])
def login():
    data = {"email": request.form['email']}
    user_in_database = user.User.get_by_email(data)
    if not user_in_database:
        flash("Invalid Login Information", "login")
        return redirect('/')
    if not bcrypt.check_password_hash(user_in_database.password,request.form['password']):
        flash("Invalid Login Information", "login")
        return redirect('/')
    session['user_id'] = user_in_database.id
    return redirect('/recipe')
    
@app.route('/logout')
def logout():
    session.clear()
    return redirect('/')