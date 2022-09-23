from flask_app import app
from flask_app import render_template, redirect, request
from flask_app.models import user

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
    user.User.save(data)
    return redirect('/users/all')

@app.route('/users/all')
def user_info():
    users = user.User.get_all()
    return render_template('all-users.html',all_users = users)

@app.route('/users/<int:id>/delete')
def delete_user(id):
    #file.class.classmethod()
    user.User.delete_user(id)
    return redirect('/users/all')

#######
#show the form data 
@app.route('/users/<int:id>/edit')
def edit_user(id):
    users = user.User.show_user(id)
    return render_template('edit.html', show_users = users)

#take data from form 
@app.route('/users/<int:id>/update', methods=['POST'])
def update_user(id):
    data = {
        "id": id,
        "fname": request.form['fname'],
        "lname": request.form['lname'],
        "email": request.form['email']
    }
    user.User.edit_user(data)
    return redirect('show')
####### 

@app.route('/users/<int:id>/show')
def show(id):
    users = user.User.show_user(id)
    return render_template('show.html', show_users = users)


## html=>(via- url, request.form)=> server/controller=> (via model method/ user.save) -> model=> (via- mysqlconnection.py ) =>Db