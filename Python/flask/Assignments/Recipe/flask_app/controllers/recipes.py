from logging import LoggerAdapter
from flask_app import app
from flask import render_template, request, redirect, session,flash
from flask_app.models import user,recipe 

#READ --> get_by_id(user.py)
@app.route('/recipes')
def dashboard():
    if "user_id" not in session:
        return redirect('/')
    logged_in_user = user.User.get_by_id(session["user_id"])
    recipes = recipe.Recipe.get_all_recipes()
    return render_template('recipes.html', logged_in_user = logged_in_user, recipes = recipes)

## UPDATE 
@app.route('/recipe/new', methods = ['POST'])
def create_recipe():
    if "user_id" not in session:
        return redirect('/')
    if recipe.Recipe.validate_recipes(request.form):
        recipe.Recipe.create_recipe(request.form)
        return redirect("/recipes")
    return redirect("/recipe/new")

#Serves the Form
@app.route('/add-recipe')
def add_recipe():
    if "user_id" not in session:
        return redirect("/")
    logged_in_user = user.User.get_by_id(session["user_id"])
    return render_template("new_recipe.html",logged_in_user=logged_in_user)
## END UPDATE

@app.route('/recipe/<int:id>/view')
def view_recipe(id):
    if "user_id" not in session:
        return redirect('/')
    logged_in_user = user.User.get_by_id(session['user_id'])
    view_recipes = recipe.Recipe.get_recipe(id)
    return render_template("view-recipe.html", logged_in_user = logged_in_user, view_recipes = view_recipes)
    


