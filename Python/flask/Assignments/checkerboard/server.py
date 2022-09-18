from timeit import repeat
from flask import Flask, render_template


app = Flask(__name__)    

@app.route('/')         
def home():
    return 'Welcome!! start here --> http://localhost:800/board'  

@app.route('/board')
def checker_board():
    return render_template('/checkerboard.html', repeat = 8, color = "blue", color2 = "black")

@app.route('/board/<int:num_of_box>/<color>/<color2>')
def checker_board_box(num_of_box,color,color2):
    return render_template('/checkerboard.html',repeat = num_of_box, color = color, color2 = color2)

@app.route('/board/<color>/<color2>')
def change_board_color(color,color2):
    return render_template('/checkerboard.html',repeat = 8, color = color,color2 = color2  )

if __name__=="__main__":      
    app.run(debug = True, port = 8000)