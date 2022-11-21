const express = require("express");
const app = express();

require("./config/mongoose.config");

app.use(
    express.json(),
    express.urlencoded({extended: true})
);

const AllMyJokesRoutes = require("./routes/jokes.routes");
AllMyJokesRoutes(app);

app.listen(PORT = 8000,() => 
    console.log(`The server is all fired up on ${PORT}`)
);