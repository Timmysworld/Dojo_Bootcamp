from flask import Flask, render_template, sessions

app = Flask(__name__)
app.secret_key = "shhhhhh"