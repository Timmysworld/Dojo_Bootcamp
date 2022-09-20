from flask import Flask, render_template, session,redirect,request

app = Flask(__name__)
app.secret_key ="just do it"

@app.route('/')          
def survey():
    return render_template('/index.html') 

@app.route('/process', methods=['POST'])
def form_submission():
    # print("Processing your Information")
    session['name'] = request.form['name']
    session['location'] = request.form['location']
    session['favorite language'] = request.form['favorite language']
    session['comment'] = request.form['comment']
    return redirect('/results')

@app.route('/results')
def form_info():
    # print("Showing the User Info From the Form")
    # print(request.form)
    return render_template('/results.html')

if __name__=="__main__":    
    app.run(debug=True, port =8000)

## got to set it up to go back to index.html once button is clicked. on the results page.



#### NOTES ####
#IN TEMPLATE ITS METHOD BUT IN SERVER.PY ITS METHODS