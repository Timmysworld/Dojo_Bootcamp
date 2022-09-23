from flask_app import app
from flask_app import render_template, redirect, request
from flask_app.models.user import User

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/create_user', methods=['POST'])
def create_user():
    data = {
        "fname": request.form['fname'],
        "lname": request.form['lname'],
        "email": request.form['email']
    }
    User.save(data)
    return redirect('/users/all')

@app.route('/users/all')
def user_info():
    users = User.get_all()
    return render_template('all-users.html',all_users = users)

@app.route('/users/<id>/delete')
def delete_user(id):
    #file.class.classmethod()
    Users.User.delete_user(id)
    return redirect('/users/all')
