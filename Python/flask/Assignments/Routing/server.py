from flask import Flask  # Import Flask to allow us to create our app

app = Flask(__name__)    # Create a new instance of the Flask class called "app"

@app.route('/')          # The "@" decorator associates this route with the function immediately following
def hello_world():
    return 'Hello World!'  # Return the string 'Hello World!' as a response

@app.route('/dojo')
def dojo():
    return 'DOJO'

@app.route('/say/<name>')
def greetings(name):
    return "Hey, " + name

@app.route('/repeat/<string:bye>/<int:num>')
def repeat(bye,num):
    return f"Say {bye * num}"




if __name__=="__main__":   # Ensure this file is being run directly and not from a different module    
    app.run(debug=True, port=8000)    # Run the app in debug mode.

###### STILL NEED TO COMPLETE 
# NINJA BONUS: Ensure the names provided in the 3rd task are strings

# NINJA BONUS: For the 4th task, ensure the 2nd element in the URL is an integer, and the 3rd element is a string

# SENSEI BONUS: Ensure that if the user types in any route other than the ones specified, they receive an error message saying "Sorry! No response. Try again."