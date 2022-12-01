const PersonController = require('../controllers/person.controller'); //IMPORT THE CODE FROM P.CONTROLLER.JS

module.exports = app => {

    app.get('/api',PersonController.index);
    
    // CREATE 
    app.post('/api/people', PersonController.createPerson)

    // READ
    app.get('/api/people',PersonController.getAllPeople)
    app.get('/api/people/:id', PersonController.getOnePerson)

    // UPDATE & DELETE 
    app.put('/api/people/:id',PersonController.updatePerson)
    app.delete('/api/people/:id', PersonController.deletePerson); //note: "id" here MUST match params in controller
}

