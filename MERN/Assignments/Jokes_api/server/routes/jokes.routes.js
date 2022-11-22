const JokesController  = require('../controllers/jokes.controller');

module.exports = app => {
    app.get('/api/jokes', JokesController.getAllJokes);
    app.post('/api/jokes',JokesController.createNewJoke);
    app.get('/api/jokes/:_id', JokesController.findOneSingleJoke);
    app.put('/api/jokes/:_id', JokesController.updateExistingJoke);
    app.delete('/api/jokes/:_id', JokesController.deleteAnExistingJoke);
}