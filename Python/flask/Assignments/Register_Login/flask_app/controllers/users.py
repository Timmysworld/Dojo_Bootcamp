from flask_app import app
from flask import render_template, request, redirect, session, flash
from flask_app.models import user 
from flask_bcrypt import Bcrypt        
bcrypt = Bcrypt(app) 


@app.route('/')
def index():
    return render_template('index.html')

@app.route('/register/user', methods = ['POST'])
def register():
    print(request.form)
    is_user_valid = user.User.validate_user(request.form)
    print(is_user_valid)
    if not is_user_valid:
        return redirect('/')
    # validate the form here ...
    # create the hash
    pw_hash = bcrypt.generate_password_hash(request.form['password'])
    print(pw_hash)
    # put the pw_hash into the data dictionary
    data = {
        "fname": request.form['fname'],
        "lname": request.form['lname'],
        "email": request.form['email'],
        "password": pw_hash
    }
    # call the save @classmethod on User
    user_id = user.User.save(data)
    # store user id into session
    session['user_id'] = user_id
    return redirect('/dashboard')

#login
@app.route('/login', methods = ['POST'])
def login():
    # see if the email provided exists in the database
    data = {"email": request.form['email']}
    print(data)
    user_in_database = user.User.get_by_email(data)
    # if user is registered in the Database
    if not user_in_database:
        flash('Invalid Information',"login")
        return redirect('/')
    if not bcrypt.check_password_hash(user_in_database.password,request.form['password']):
        #if we get  False after checking the password
        flash("Invalid Information","login")
        return redirect('/')
    # if the passwords matched, we set the user_id into session
    session['user_id'] = user_in_database.id
    print("successful login")
    return redirect('/dashboard')

#logout
@app.route('/logout')
def logout():
    session.clear()
    return redirect('/')

#dashboard
@app.route('/dashboard')
def dashboard():
    if "user_id" not in session:
        return redirect('/')
    logged_in_user = user.User.get_by_id(session["user_id"])
    return render_template('dashboard.html', logged_in_user = logged_in_user)
