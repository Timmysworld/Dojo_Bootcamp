//  1. Always Hungry
// Write a function that is given an array and each time the value is "food" it should console log "yummy". If "food" was not present in the array console log "I'm hungry" once.

function alwaysHungry(arr) {
    // your code here
    var hasEaten=  false;
    for (var i = 0; i<arr.length; i++){
        if (arr[i] == "food"){     
            hasEaten = true;
            console.log("yummy"); 
        } 
    } if ( !hasEaten){
    console.log("I'm hungry");
    }
}

alwaysHungry([3.14, "food", "pie", true, "food"]);
// this should console log "yummy", "yummy"
alwaysHungry([4, 1, 5, 7, 2]);
// this should console log "I'm hungry"


//NOTES: 
//ONCES THE FIRST IF IS COMPLETE THE SECOND ARRAY OF NUMBERS WILL EXECUTE.
// TO MAKE BOOLEAN FALSE USE ! IN FRONT OF VARIABLE
//CONSOLE.LOG("I'M HUNGRY") IS RUNNING INDEPENDENTLY OF BEGINNING FOR LOOP.
//THE IDEA IS TO ONLY KNOW YOU'RE HUNGRY AFTER ALL ARRAYS HAS BEEN CHECKED!


// 2. High Pass Filter
//Given an array and a value cutoff, return a new array containing only the values larger than cutoff.
function highPass(arr, cutoff) {
    var filteredArr = [];
    // your code here
    for ( var i =0; i<arr.length; i++){
        if (arr[i] > cutoff){
            filteredArr.push(arr[i]);
        }
    }
    return filteredArr;
}
var result = highPass([6, 8, 3, 10, -2, 5, 9], 5);
console.log(result); // we expect back [6, 8, 10, 9]


// 3. Better than average
//Given an array of numbers return a count of how many of the numbers are larger than the average.
function betterThanAverage(arr) {
    var sum = 0;
    // calculate the average
    for (var i = 0; i<arr.length; i++){
        sum += arr[i];
    }
    var avg = sum / arr.length;
    var count = 0
    // count how many values are greater than the average
    for (var i = 0; i<arr.length; i++){
        if (arr[i] > avg){
            count ++;
        }
    }
    return count;
}
var result = betterThanAverage([6, 8, 3, 10, -2, 5, 9]);
console.log(result); // we expect back 4

//NOTES
//.PUSH AND .LENGTH ONLY WORKS WITH ARRAYS
//WHEN FINDING THE AVERAGE YOU WANT GRAB THE SUM OF ALL VALUE WITHIN ARRAY AND THE CREATE A VARIABLE TO PLACE SUM / BY LENGTH OF ARRAY.
//MATH.FLOOR() OR MATH.CEIL() FOR ROUNDING DECIMAL 

// 4. Array Reverse
//Write a function that will reverse the values an array and return them.
function reverse(arr) {
    // your code here 
    //1ST APPROACH:
    var newArr = [];
    for (var i = arr.length-1; i >=0; i-- ){
        console.log(arr[i]);
        newArr.push(arr[i]);
    }
    
    
    return newArr;
}

var result = reverse(["a", "b", "c", "d", "e"]);
console.log(result); // we expect back ["e", "d", "c", "b", "a"]

//NOTES: 
//WRITES A FUNCTION THAT TAKES IN AN ARRAY
//CREATE AN EMPTY ARRAY IN THE FUNCTION
//LOOP THROUGH THE ORIGINAL ARRAY starting at end working backwards
//ADD VALUES IN REVERSE ORDER TO M NEW ARRAY

// 2ND APPROACH: SWAP IN PLACE
function reverse(arr){
    for ( var i = 0; i < Math.floor(arr.length / 2); i++){
        var temp = arr[i];
        arr[i] = arr[arr.length-1-i];
        arr[arr.length-1-i]= temp;
        
        }
    return arr;
}
var result = reverse(["a", "b", "c", "d", "e"]);
console.log(result); // we expect back ["e", "d", "c", "b", "a"]


// 5. Fibonacci Array
//Fibonacci numbers have been studied for years and appear often in nature. Write a function that will return an array of Fibonacci numbers up to a given length n. Fibonacci numbers are calculated by adding the last two values in the sequence together. So if the 4th value is 2 and the 5th value is 3 then the next value in the sequence is 5.
function fibonacciArray(n) {
    // the [0, 1] are the starting values of the array to calculate the rest from
    var fibArr = [0, 1];
    // your code here
    for(var i=fibArr.length; i<10; i++) {
        fibArr[i] = fibArr[i-2] + fibArr[i-1];
    }
    return fibArr;
}

var result = fibonacciArray(10);
console.log(result); // we expect back [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
