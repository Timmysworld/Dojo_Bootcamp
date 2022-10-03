from flask_app import app
from flask_app import render_template
from flask_app.models import user 

@app.route('/')
def register():
    return render_template('index.html')
