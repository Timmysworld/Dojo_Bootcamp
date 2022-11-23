const Person = require('../models/person.model');

const index = (req, res) => {
    res.json({
        message:"Hello World"
    });
}

const createPerson = (request, response) => {
    Person.create(request.body)
            .then(person=>response.json(person))
            .catch(err =>response.json(err))
}

module.exports = {
    index,
    createPerson
}; 