// 1. PRINT 1-255
// print1To255()
// Print all the integers from 1 to 255.

for(let i = 1; i<=255; i++){
    console.log(i);
}


// 2. PRINT ODDS 1-255
// printOdds1To255()
// Print all odd integers from 1 to 255.

for (let i = 1; i<=255; i+=2){
    console.log(i);
}

// 3. PRINT INTEGERS AND SUM OF 0-255
// printIntsAndSum0To255()
// Print integers from 0 to 255, and with each integer
// print the sum so far.

function printIntsAndSum0To255(){
    let sum = 0;
    for (let num=0; num<=255; num++){
        sum +=num;
        console.log(num);
    }
}
printIntsAndSum0To255();

// 4. ITERATE AND PRINT THE ARRAY
// Iterate through a given array, printing each value.

let colors = ["Red", "Blue", "Green", "Black"]
function basicColors(){
    for(let i = 0; i<colors.length; i++){
        console.log(colors[i]);
    }
}
basicColors();

// 5. FIND AND PRINT THE MAX
// printMaxOfArray(arr)
// Given an array, find and print its largest element.

function printMaxOfArray(arr){
    var max = arr[0];
    for(let i=1; i <arr.length; i++){
        if (max < arr[i]){
            max = arr[i];
        }
    }
    return max;
}
var array = [11, 325, 45, 95, 9808];
var output = printMaxOfArray(array);
console.log(output);


// 6. GET AND PRINT THE AVERAGE
// printAverageOfArray(arr)
// Analyze an array’s values and print the average.

function printAverageOfArray(arr){
    let sum = 0; 
    for(let number of arr){
        sum +=number;
    }
    average = sum/arr.length;
}
var result = printAverageOfArray([11,325,45,95,150]);
console.log(average);


// 7. ARRAY WITH ODDS
// returnOddsArray1To255()
// Create an array with all the odd integers between 1
// and 255 (inclusive)

let oddNum = [];
function returnOddsArray1To255(){
    for (let i = 1; i<=255; i+=2){
        // console.log(i);
        oddNum.push(i);
        // console.log(oddNum);
    }
    return oddNum;
}
returnOddsArray1To255();

// 8. SQUARE THE VALUES
// squareArrayVals(arr)
// Square each value in a given array, returning that
// same array with changed values.

let arr = [1,2,4,6,8];
// let arr2 = [2,4,6,8];
function squareArrayVals(myArr){
    for(let i =0; i<myArr.length; i++){
        // console.log(myArr);
        myArr[i]= Math.pow(myArr[i],2);
    }
    // console.log(myArr);
    return myArr;
    
}
// squareArrayVals(arr);
console.log(squareArrayVals(arr));
//NOTES:
//Math.pow(x,y)
//DYNAMICALLY DUE TO CREATING A PARAMETER.
//myArr IS JUST A PLACE HOLDER THAT ACCESSES THE arr ARRAY.


// 9. GREATER THAN Y
// printArrayCountGreaterThanY(arr, y)
// Given an array and a value Y, count and print the
// number of array values greater than Y.



// 10. ZERO OUT NEGATIVE NUMBERS
// zeroOutArrayNegativeVals(arr)
// Return the given array, after setting any negative
// values to zero.

let Numbers = [];

function zeroOutArrayNegativeVals(arr){
    for(let i =0; i<arr.length; i++){
        if (arr[i]< 0){
            arr[i] = 0
        }
    }
        return arr;
}

// 11. MAX, MIN, AVERAGE
// printMaxMinAverageArrayVals(arr)
// Given an array, print the max, min and average
// values for that array.

let max, min, average;

function printMaxMinAverageArrayVals(arr){
    max = arr[0];
    min = arr[0];
    average = 0;

    for ( let i =0; i<arr.length; i++){
        max = arr[0]
        if(arr[i] > max){
            max = arr[i]
        }
        if (arr[i]<min){
            min =arr[i]
        }
        average = average + arr[i]
    }
        average = average/arr.length;
}
printMaxMinAverageArrayVals([2,7,6,1,4,9]);

// 12 SHIFT ARRAY VALUES
// shiftArrayValsLeft(arr)
// Given an array, move all values forward (to the left)
// by one index, dropping the first value and leaving a 0
// (zero) value at the end of the array.

var arr = [1,2,3,4,5];
//expected result
//[2,3,4,5,0]
function shiftArrayValsLeft(arr){
    for (var i = 1; i<arr.length; i++){
        arr[i-1]=arr[i];
    }
    arr[arr.length-1]=0;
    return arr;
}

// 13. SWAP STRING FOR ARRAY NEGATIVE VALUES
// swapStringForArrayNegativeVals(arr)
// Given an array of numbers, replace any negative
// values with the string 'Dojo'.