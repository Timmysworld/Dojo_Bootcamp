const PersonController = require('../controllers/person.controller'); //IMPORT THE CODE FROM P.CONTROLLER.JS

module.exports = app => {
    app.get('/api',PersonController.index);
    app.post('/api/people', PersonController.createPerson)
    app.get('/api/people',PersonController.getAllPeople)
    app.get('/api/people/:id', PersonController.getOnePerson)
}

