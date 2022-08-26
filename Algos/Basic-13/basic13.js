// 1. Print 1-255
// print1To255()
// Print all the integers from 1 to 255.


// 2. Print Odds 1-255
// printOdds1To255()
// Print all odd integers from 1 to 255.

// 3. Print Ints and Sum 0-255
// printIntsAndSum0To255()
// Print integers from 0 to 255, and with each integer
// print the sum so far.

// 4. Iterate and Print Array
// printArrayVals(arr)
// Iterate through a given array, printing each value.

// 5. Find and Print Max
// printMaxOfArray(arr)
// Given an array, find and print its largest element.

// 6. Get and Print Average
// printAverageOfArray(arr)
// Analyze an array’s values and print the average.

// 7. Array with Odds
// returnOddsArray1To255()
// Create an array with all the odd integers between 1
// and 255 (inclusive)

// 8. Square the Values
// squareArrayVals(arr)
// Square each value in a given array, returning that
// same array with changed values.

// 9. Greater than Y
// printArrayCountGreaterThanY(arr, y)
// Given an array and a value Y, count and print the
// number of array values greater than Y.


// 10. Zero Out Negative Numbers
// zeroOutArrayNegativeVals(arr)
// Return the given array, after setting any negative
// values to zero.

let Numbers = []

function zeroOutArrayNegativeVals(arr){
    for(let i =0; i<arr.length; i++){
        if (arr[i]< 0){
            arr[i] = 0
        }
    }
        return arr;
}

// 11. Max, Min, Average
// printMaxMinAverageArrayVals(arr)
// Given an array, print the max, min and average
// values for that array.

let max, min, average;

function printMaxMinAverageArrayVals(arr){
    max = arr[0]
    min = arr[0]
    average = 0

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
printMaxMinAverageArrayVals([2,7,6,1,4,9])

// 12. Shift Array Values
// shiftArrayValsLeft(arr)
// Given an array, move all values forward (to the left)
// by one index, dropping the first value and leaving a 0
// (zero) value at the end of the array.

var arr = [1,2,3,4,5]
//expected result
//[2,3,4,5,0]
function shiftArrayValsLeft(arr){
    for (var i = 1; i<arr.length; i++){
        arr[i-1]=arr[i];
    }
    arr[arr.length-1]=0;
    return arr;
}