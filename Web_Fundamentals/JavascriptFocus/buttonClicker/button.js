function hide(element){
    element.remove();
}
// LogIn/LogOut Fucnction
function logout(element){
    if(element.innerText == "login"){
        element.innerText = "logout";
    }else {
        element.innerText = "Login";
    } 
};
// button clicked message
function message() {
    alert("Ninja was liked!");
}