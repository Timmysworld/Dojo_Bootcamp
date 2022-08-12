var number = [ 9,12,9]; // [0,1,2]  parameters of each button position 
var count = document.querySelectorAll(".number"); 
// console.log(count);

function increaseLikes(id){ //passing [id] to grab index from var number array.
    number[id]++; //increases the number of every time button is clicked
    count[id].innerText = number[id]; 
    // console.log(id);
}


//Notes: 
// always provide an index within the HTML to grab a specific item in the array/list..

