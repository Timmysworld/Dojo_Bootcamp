const express = require('express');
const cors = require('cors')
const app = express();
const port = 8000;


app.use(cors())
app.use(express.json()); // allows json objects to be posted
app.use(express.urlencoded({ extended: true })); // allows json objects with strings and arrays

require('./config/mongoose.config')
require('./routes/person.routes')(app); // IMPORTING THE ROUTES EXPORT (shorthand version)


app.listen(port, () => console.log(`Listening on port: ${port}`));




