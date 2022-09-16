from curses import can_change_color
from flask import Flask, render_template

app = Flask (__name__)

@app.route('/')
def home():
    return " go to http://localhost:8000/play to begin"

@app.route('/play')
def lets_play():
    return render_template("play.html")

@app.route('/play/<num_of_boxes>')
def number_of_boxes(num_of_boxes):
    repeat = int(num_of_boxes)
    return render_template("play.html", repeat = repeat)

@app.route('/play/<num_of_boxes>/<color>')
def boxes_color(num_of_boxes,color):
    repeat = int(num_of_boxes)
    color = color
    return render_template("play.html",repeat = repeat, color = color)



if __name__ == "__main__":
    app.run(debug=True, port=8000)
