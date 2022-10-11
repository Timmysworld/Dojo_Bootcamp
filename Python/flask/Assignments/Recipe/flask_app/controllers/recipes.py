from logging import LoggerAdapter
from flask_app import app
from flask import render_template, request, redirect, session,flash
from flask_app.models import user,recipe 


@app.route('/recipes')
def dashboard():
    if "user_id" not in session:
        return redirect('/')

    # data = {
    #     "id":session["user_id"]
    # }
    logged_in_user = user.User.get_by_id(session["user_id"])
    # logged_in_user = user.User.get_by_id(data)
    recipes = recipe.Recipe.get_all_recipes()
    return render_template('recipes.html', logged_in_user = logged_in_user, recipes = recipes)


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
    view_recipe = recipe.Recipe.get_recipe(id)
    return render_template("view-recipe.html", logged_in_user = logged_in_user, recipe = view_recipe)
    
@app.route('/recipe/<int:id>/edit')
def edit_recipe(id):
    if "user_id" not in session:
        return redirect('/')
    logged_in_user = user.User.get_by_id(session['user_id'])
    edit_recipe = recipe.Recipe.get_recipe(id)
    return render_template("edit-recipe.html", logged_in_user = logged_in_user, recipe = edit_recipe)

@app.route('/recipe/<int:id>/update', methods = ['POST'])
def update_recipe(id):
    if "user_id" not in session:
        return redirect('/')
    if recipe.Recipe.validate_recipes(request.form):
        data = {
            "id": id,
            "name": request.form['name'],
            "description": request.form['description'],
            "recipe_date": request.form['recipe_date'],
            "instructions": request.form['instructions'],
            "under_thirty": request.form['under_thirty']
        }
        recipe.Recipe.update_recipe(data)
        return redirect(f"/show/{id}")
    print("BBB")
    return redirect(f"/recipe/{id}/update")

@app.route("/show/<int:id>")
def get_recipe(id):
    if "user_id" not in session:
        return redirect("/")
    logged_in_user = user.User.get_by_id(session["user_id"])
    show_updated_recipe = recipe.Recipe.get_recipe(id)
    return render_template("view-recipe.html",logged_in_user=logged_in_user ,recipe = show_updated_recipe)

@app.route("/recipe/<int:id>/delete/")
def delete_recipe(id):
    if "user_id" not in session:
        return redirect("/")
    recipe.Recipe.delete_recipe(id)
    return redirect("/recipes")