from flask import Flask, render_template, redirect, request
# import the class from friend.py
app = Flask(__name__)
app.secret_key = "shhhhhh"