// const { response } = require('express');
const AuthorsController = require('../controller/authors.controllers');

module.exports = app  => {
    app.get('/api',AuthorsController.getAuthors);

    //CREATE 
    app.post('/api/author',AuthorsController.createAuthors);

    //READ 
    app.get('/api/author/:id', AuthorsController.getOneAuthor);

    //UPDATE & DELETE 
    app.put('/api/author/:id', AuthorsController.updateAuthor)
    app.delete('/api/author/:id', AuthorsController.deleteAuthor)
}

