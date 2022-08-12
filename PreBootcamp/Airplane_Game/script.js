// PLAYER OBJECT: you can add more or subtract the amount of players
var player = {  
    left: 450,
    top:620
}
// ENEMY OBJECT: you can add more or subtract the amount of enemies 
var enemies = [
    {left: 450, top: 200},
    {left: 350, top: 250},
    {left: 250, top: 300},
    {left: 550, top: 255},
    {left: 625, top: 325}
]
var missiles = [];

// FUNCTIONS : 
function drawPlayer(){
    content = "<div class='player' style= 'left:"+player.left+"px; top:"+player.top+"px'></div>";
    document.getElementById("players").innerHTML = content;
}

// For loop to draw multiple enemies on game 
function drawEnemies(){
    content ="";
    for(var idx = 0; idx<enemies.length; idx++){
        content += "<div class='enemy' style= 'left:"+enemies[idx].left+"px; top:"+enemies[idx].top+"px'></div>";
    }
    document.getElementById("enemies").innerHTML = content;
}

function drawMissiles(){
    content = "";
    for(var idx = 0; idx<missiles.length; idx++){
        content += "<div id='missiles' style='left:"+missiles[idx].left+"px; top:"+missiles[idx].top+"px'></div>"
    }
    document.getElementById("missiles").innerHTML = content;
}

function moveEnemies(){
    for(var idx = 0; idx<enemies.length; idx++){
        enemies[idx].top = enemies[idx].top + 1;
    }
}
function moveMissles(){
    for(var idx = 0; idx<missiles.length; idx++){
        missiles[idx].top = missiles[idx].top - 4;
    }
}

// PLAYER MOVEMENTS IF STATEMENTS 
document.onkeydown = function(e) {
    if(e.keyCode == 37) { //LEFT
        player.left = player.left - 20;
    }
    if(e.keyCode == 39){ //RIGHT
        player.left = player.left + 20
    } 
    if(e.keyCode == 38 && player.top > 500){
        player.top = player.top -20; //UP
    }
    if(e.keyCode == 40 && player.top < 700){
        player.top = player.top +20; // DOWN
    }
    if(e.keyCode == 32){ //FIRE
        missiles.push({left: (player.left + 34), top:(player.top - 8)})
        drawMissiles();
        console.log(missiles);
    } 
    drawPlayer();
}

//FUNCTION : GAME LOOP TO RUN X AMOUNT OF TIMES 
function gameLoop(){
    console.log("gameLoop is running!");
    drawPlayer();
    moveEnemies();
    drawEnemies();
    moveMissles();
    drawMissiles();
    setTimeout(gameLoop, 10)
}
gameLoop();