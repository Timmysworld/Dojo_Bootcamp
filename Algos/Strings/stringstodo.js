// 1.Remove Blanks
// Create a function that, given a string, returns all of that string’s contents, but without blanks. 

// Examples:

// removeBlanks(" Pl ayTha tF u nkyM usi c ") => "PlayThatFunkyMusic"
// removeBlanks("I can not BELIEVE it's not BUTTER") => "IcannotBELIEVEit'snotBUTTER"
function removeBlanks(str){
    //make a new string
    let newStr = ""
    //loop through string 
    for( i = 0; i < str.length; i++){
        //if character is not space
        if(str[i] != " "){
            newStr += str[i]
        }
    }
    return newStr
}

// console.log(removeBlanks(" Pl ayTha tF u nkyM usi c "));
// console.log(removeBlanks("I can not BELIEVE it's not BUTTER"));

// 2.Get Digits
// Create a JavaScript function that given a string, returns the integer made from the string’s digits. You are allowed to use isNaN() and Number().

// Examples:

// getDigits("abc8c0d1ngd0j0!8") => 801008

// getDigits("0s1a3y5w7h9a2t4?6!8?0") => 1357924680
function getDigits(str){
    let newDigits = ""
    for(let char in str){
        //check if charcter is not a number
        if(!isNaN(str[char])){
            //add to a new string
            newDigits += str[char]
        }
    }
    //return and change into a number
    return Number(newDigits)
}
//console.log(getDigits("abc8c0d1ngd0j0!8"));
//console.log(getDigits("0s1a3y5w7h9a2t4?6!8?0"))


// 3.Acronyms
// Create a function that, given a string, returns the string’s acronym (first letter of the word capitalized). You are allowed to use .split() and .toUpperCase().

// acronym(" there's no free lunch - gotta pay yer way. ") => "TNFL-GPYW". 

// acronym("Live from New York, it's Saturday Night!") => "LFNYISN".
function acronym(str){
    let wordsArr = str.split(' ')
    let acronymStr = ''
    //loop through array 
    for(let word in wordsArr){
        //grab first letter of word 
        if(wordsArr[word].length > 0){
             //transform & concatenate first letter to uppercase String
            acronymStr += wordsArr[word][0].toUpperCase()
            
        }
    }
    return acronymStr
}
// console.log(acronym(" there's no free lunch - gotta pay yer way. "));
// console.log(acronym("Live from New York, it's Saturday Night!"));

// 4.Count Non-Spaces
// Create a function that, given a string, returns the number of non-space characters found in the string. 

// Examples:

// countNonSpaces("Honey pie, you are driving me crazy") => 29
// countNonSpaces("Hello world !") => 11

function countNonSpaces(str){
    //counter variable 
    let counter = 0
    //loop through string 
    for(let char in str){
    //if char is not a space 
        if(str[char]  != " "){
              //increment counter
            counter ++
        }
    }
    return counter
}
// console.log(countNonSpaces("Honey pie, you are driving me crazy"));
// console.log(countNonSpaces("Hello world !"));


// Remove Shorter Strings
// Create a function that, given an array of strings and a numerical value, returns an array that only contains strings longer than or equal to the given value.

// Examples:

// removeShorterStrings(['Good morning', 'sunshine', 'the', 'Earth', 'says', 'hello'], 4) => ['Good morning', 'sunshine', 'Earth', 'says', 'hello']
// removeShorterStrings(['There', 'is', 'a', 'bug', 'in', 'the', 'system'], 3) => ['There', 'bug', 'the', 'system']

function removeShorterStrings(arr,len){
    //create new array
    let newStr = []
    //initialize next index variable
    let nextIndex = 0
    //loop through array 
    for(let value in arr){
        //test if length in array is >= length 
        if(arr[value].length >= len)
            //add valuable to new array 
            newStr[nextIndex++] = arr[value]
    }
    return newStr
}
console.log(removeShorterStrings(['Good morning', 'sunshine', 'the', 'Earth', 'says', 'hello'], 4));
console.log(removeShorterStrings(['There', 'is', 'a', 'bug', 'in', 'the', 'system'], 3));