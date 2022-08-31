#1   MY PREDICTIONS: 5
def number_of_food_groups():
    return 5
print(number_of_food_groups())
#outcome: 5


#2  MY PREDICTIONS: 5 
def number_of_military_branches():
    return 5
print(number_of_days_in_a_week_silicon_or_triangle_sides() + number_of_military_branches())
#outcome: NameError: name 'number_of_days_in_a_week_silicon_or_triangle_sides' is not defined

#3 MY PREDICTIONS: 5 10
def number_of_books_on_hold():
    return 5
    return 10
print(number_of_books_on_hold())
#outcome: Printed only 5

#4 MY PREDICTIONS: 10
def number_of_fingers():
    return 5
    print(10)
print(number_of_fingers())
#outcome: Printed 5

#5 MY PREDICTIONS: 5
def number_of_great_lakes():
    print(5)
x = number_of_great_lakes()
print(x)
#outcome: Printed 5 and None


#6 MY PREDICTIONS: 3  5 
def add(b,c):
    print(b+c)
print(add(1,2) + add(2,3))
#outcome: Printed 3,5 also printed TypeError: unsupported operand type(s) for +: 'NoneType' and 'NoneType'

#7 MY PREDICTIONS: 25
def concatenate(b,c):
    return str(b)+str(c)
print(concatenate(2,5))
#outcome: 25 

#8 MY PREDICTIONS:  100 10 7
def number_of_oceans_or_fingers_or_continents():
    b = 100
    print(b)
    if b < 10:
        return 5
    else:
        return 10
    return 7
print(number_of_oceans_or_fingers_or_continents())
#outcome: 100 10

#9 MY PREDICTIONS: 7 14 7 14
def number_of_days_in_a_week_silicon_or_triangle_sides(b,c):
    if b<c:
        return 7
    else:
        return 14
    return 3
print(number_of_days_in_a_week_silicon_or_triangle_sides(2,3))
print(number_of_days_in_a_week_silicon_or_triangle_sides(5,3))
print(number_of_days_in_a_week_silicon_or_triangle_sides(2,3) + number_of_days_in_a_week_silicon_or_triangle_sides(5,3))
# #outcome: 7 14 21

#10 MY PREDICTIONS: 8 10
def addition(b,c):
    return b+c
    return 10
print(addition(3,5))
#outcome: 8

#11 MY PREDICTIONS: 500 300
b = 500
print(b)
def foobar():
    b = 300
    print(b)
print(b)
foobar()
print(b)
#outcome: 500 500 300 500


#12 MY PREDICTIONS: 500 500 500 300
b = 500
print(b)
def foobar():
    b = 300
    print(b)
    return b
print(b)
foobar()
print(b)
#outcome: 500 500 300 500

#13 MY PREDICTIONS: 500 500 300 300
b = 500
print(b)
def foobar():
    b = 300
    print(b)
    return b
print(b)
b=foobar()
print(b)
# outcome: 500 500 300 300


# #14 MY PREDICTIONS: ??? 
def foo():
    print(1)
    bar()
    print(2)
def bar():
    print(3)
foo()
#outcome: 1 3 2 

# #15 MY PREDICTIONS: 1 3 3 1
def foo():
    print(1)
    x = bar()
    print(x)
    return 10
def bar():
    print(3)
    return 5
y = foo()
print(y)
#outcome: 1 3 5 10