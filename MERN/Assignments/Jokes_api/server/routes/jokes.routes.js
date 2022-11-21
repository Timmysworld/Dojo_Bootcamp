const JokesController  = require('../controllers/jokes.controller');

module.exports = app => {
    app.get('/api/jokes', JokesController.findAllJokes);
    app.post('/api/jokes',JokesController.createNewJoke);
    app.get('/api/jokes/:_id', JokesController.findOneSingleJoke);
    app.put('/api/jokes/:_id', JokesController.updateExistingJoke);
    app.delete('/api/jokes/_:id', JokesController.deleteAnExistingJoke);
}