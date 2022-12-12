const mongoose = require('mongoose');
//This will create a database named "person" if one doesn't already exist (no need for mongo shell!):
mongoose.connect("mongodb://localhost:27017/Authors", { 
    useNewUrlParser: true, 
    useUnifiedTopology: true,
})
    .then(() => console.log("Established a connection to the database"))
    .catch(err => console.log("Something went wrong when connecting to the database", err));

//172.0.0.1:27017