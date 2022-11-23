const PersonController = require('../controllers/person.controller'); //IMPORT THE CODE FROM P.CONTROLLER.JS

module.exports = app => {
    app.get('/api',PersonController.index);
    app.post('/api/people', PersonController.createPerson)
}

