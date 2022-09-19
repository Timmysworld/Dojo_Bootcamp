from cgitb import reset
from itertools import count
from operator import countOf
from flask import Flask, render_template, session, redirect


app = Flask(__name__)
app.secret_key = '1234567890'

@app.route('/')          
def lets_count():
    if "count" in session:
        print('key exists!')
        session["count"] += 1
    elif "count2" in session:
        session["count2"] = session["count"]+2
    else:
        print("sorry i only went up once")
        session["count"] = 0
        # print("Session does NOT exist")
    return render_template('counter.html') 


@app.route('/destroy_session')
def rest_session():
    session.clear()
    print("session is destroyed")
    return redirect('/')

if __name__=="__main__":   
    app.run(debug=True, port =8000)  

# session.clear()		# clears all keys
# session.pop('key_name')		# clears a specific key
