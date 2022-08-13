function loadWeather(element){
    alert("Loading weather report for " + element.id);
}
//Remove Cookies Function: 
function acceptance(){
    var accept = document.querySelector(".box-cookies");
    accept.remove();
}

//Change Temperature base on Temperature Scale ( Fahrenheit or Celsius)
function convert_temperature(element) {
    var tempElements = document.querySelectorAll(".temperature > h3");//creating a list ; all of h3 whose parent have class of temperature
    for(var i = 0; i<8; i++){ //iterating through the list 
        var temp = parseInt(tempElements[i].innerText);// capture the text (temperature) inside each element within the list
        if(element.value == "celsius"){ //if the new value is celsius then its converted to fahrenheit.
            temp = (temp -32) * 5/9;
        }else{
            temp = temp * 9/5+32; //if the new value is fahrenheit then its converted to celsius.
        }
        tempElements[i].innerText = Math.round(temp) + "°";//for each iteration of the for loop replace the old value with new value using .innerText
    }
    
}
//NOTES
//tempElements[i].innerText
    //when you want to read it - goes on the left 
    //when you want to replace it - goes on the right 

