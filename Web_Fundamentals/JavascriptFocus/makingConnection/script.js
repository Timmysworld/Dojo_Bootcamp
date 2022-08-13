// Change Profile Name when edit button is clicked
function changeName(element){
    var name = document.querySelector("h2");
    name.innerHTML = "Timmy Doe";
    // console.log(name)
}


var number =[2, 500];
// console.log(number);

function accept(element){
    var listOfNumbers = document.querySelectorAll(".number");
    number[0]--;
    number[1]++;
    listOfNumbers[0].innerHTML = number[0];
    listOfNumbers[1].innerHTML = number[1];
    var decline = document.querySelector("." + element.id)
    decline.remove();
}

function reject(element){
    var listOfNumbers = document.querySelectorAll(".number");
    number[0]--;
    listOfNumbers[0].innerHTML = number[0];
    var decline = document.querySelector("." + element.id)
    decline.remove();
}



