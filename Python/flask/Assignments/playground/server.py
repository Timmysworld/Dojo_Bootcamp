from flask import Flask, render_template

app = Flask (__name__)

@app.route('/')
def home():
    return " go to http://localhost:8000/play to begin"

@app.route('/play')
def lets_play():
    return render_template("play.html",repeat = 3, color = "blue")

@app.route('/play/<int:num_of_boxes>')
def number_of_boxes(num_of_boxes):
    return render_template("play.html", repeat = num_of_boxes)

@app.route('/play/<int:num_of_boxes>/<color>')
def boxes_color(num_of_boxes,color):
    return render_template("play.html",repeat = num_of_boxes, color = color)



if __name__ == "__main__":
    app.run(debug=True, port=8000)

# NOTES ####
# REPEAT CONTEXT VARIABLE WILL WORK FOR MULTIPLE IF WANTED SAME AMOUNT, IF WANT A DIFFERENT AMOUNT MUCH CREATE NEW @APP.ROUTE