var pizza = {
    size: ["Small","Medium","Large","X-Large"],
    crust: ["Deep Dish", "Hand Tossed","Brooklyn Style", "Thin Crust", "traditional"],
    sauce: ["Marinara","Honey BBQ", "Garlic Parmesan", "alfredo Sauce","Ranch"],
    cheese: ["Light","Normal","Extra", "Feta"],
    meats:["Ham","Beef","Salami","Pepperoni","Italian Sausage","Premium Chicken","Bacon","Philly Steak"],
    veggies: ["Jalapeno Peppers","Onions","Banana Peppers","Tomatoes","Olives","Pineapples","Spinach","Feta Cheese","Shredded Parmesan Asiago", "Mushrooms"]
};

function pizzaOven(size,crust, sauce, cheese, meats, veggies){
    var pizza = {};
    pizza.size = size;
    pizza.crust = crust;
    pizza.sauce = sauce;
    pizza.cheese = cheese;
    pizza.meats = meats;
    pizza.veggies = veggies;
    return pizza;
}

var p1 = pizzaOven("X-Large","Deep Dish","Marinara", "Normal",["Pepperoni","Italian Sausage"], "Pineapples")
console.log(p1);

var p2 = pizzaOven("Small", "Hand Tossed", "Marinara", ["Normal","Feta"],"None",["Mushrooms","Olives","Onions"]);
console.log(p2);

// BONUS CHALLENGE:
function randomPizza(){
    var newPizza = {}; //NEW DICTIONARY WHERE THE randomPizza function will be placed.
    // console.log(newPizza);
    for(var k in pizza){  // LOOP THROUGH PIZZA DICTIONARY 
        var i = Math.floor(Math.random() * pizza[k].length);
        newPizza[k] = pizza[k][i]; //newPizza[k] => WRITING DICTIONARY KEY / pizza[k] => READING DICTIONARY KEY  
        // console.log(newPizza1);
    }
    return newPizza; 
};
var pizza1 = randomPizza();
var pizza2 = randomPizza();
var pizza3 = randomPizza();
console.log(pizza1);
console.log(pizza2);
console.log(pizza3);

//NOTES:
// obj  IS MY VAR PIZZA DICTIONARY OBJECT. 
// THE obj INSIDE RANDOM PIZZA FUNCTION IS A PARAMETER THAT YOU PASS IN. 
// obj = in this case represent a dictionary. (KEYS are specific to dictionaries)
// NEW_VALUE PASSES NEW ITEMS INTO THE DICTIONARY newPizza. 
// keys open dictionary and index opens lists 
//accessing a dictionary of lists ( dictionary['key'][index])


