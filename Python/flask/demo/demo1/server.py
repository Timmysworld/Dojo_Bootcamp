from flask import Flask, render_template # Import Flask to allow us to create our app


app = Flask (__name__) # Create a new instance of the Flask class called "app" You will need this line in every application you build with Flask.

@app.route("/") # The "@" decorator associates this route with the function immediately following  # @app.route("/home/_____") anything after '/hello/' gets passed as a variable 'name'
def index():
    return render_template("index.html", name="Timothy") # Return the string 'Hello World!' as a response

@app.route('/users/<username>/<id>')
def show_user_profile(username, id):
    print(username)
    print(id)
    return "username: " + username + ", id: " + id 

if __name__ == "__main__":  # Ensure this file is being run directly and not from a different module  
    app.run(debug=True, port=8000)  # Run the app in debug mode. mac users must use port 8000