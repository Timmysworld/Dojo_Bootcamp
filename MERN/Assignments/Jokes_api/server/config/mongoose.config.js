const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/jokes',{
    useNewUrlParser: true,
    useUnifiedTopology: true
})
    .then(()=> console.log('Established a connection to the database '))
    .catch(err => console.log('SOmething went wrong when trying to connect to database',err));