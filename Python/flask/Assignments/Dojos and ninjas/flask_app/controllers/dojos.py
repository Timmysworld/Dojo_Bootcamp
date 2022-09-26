from flask_app import app
from flask_app import render_template, redirect, request
from flask_app.models import dojo

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/create_dojo', methods =['POST'])
def create_dojo():
    # print("A")
    # print(request.form)
    data = {
        "name": request.form['name'],
    }
    dojo.Dojo.save(data)
    return redirect('/')

@app.route("/dojos")
def dojos():
    dojos = dojo.Dojo.get_all()
    return render_template('index.html', all_dojos = dojos)