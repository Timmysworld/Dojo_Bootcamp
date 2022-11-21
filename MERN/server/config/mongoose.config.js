const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/name_of_your_DB', {
    // Note: The useNewUrlParser and useUnifiedTopology are options we pass to get rid of deprecation messages in our terminal.
    // Note: If you connect to a database that doesn't exist, Mongoose will create the DB for you as soon as you create your first document!
    useNewUrlParser: true,
    useUnifiedTopology: true
})
    .then(() => console.log('Established a connection to the database'))
    .catch(err => console.log('Something went wrong when connecting to the database ', err));

