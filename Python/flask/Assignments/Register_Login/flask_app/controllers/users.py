from flask_app import app
from flask_app import render_template, request, redirect, session
from flask_app.models import user 
from flask_bcrypt import Bcrypt        
bcrypt = Bcrypt(app) 

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/create', methods = ['POST'])
def create_user():
    if not user.User.validate_user(request.form):
        return redirect('/')
    user.User.save(request.form)
    return redirect('/users')

@app.route('/register/user', methods = ['POST'])
def register():
    print(request.form)
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
    return redirect('/')
