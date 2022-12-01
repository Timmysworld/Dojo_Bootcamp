const Person = require('../models/person.model');

const index = (req, res) => {
    res.json({
        message:"Hello,  and Welcome to a FULL STACK CRUD Application "
    });
}

const createPerson = (request, response) => {
    Person.create(request.body)
            .then(person=>response.json(person))
            .catch(err =>response.json(err))
}

const getAllPeople = (request, response) => {
    Person.find({})
        .then(person=>{
            console.log(person);
            response.json(person);
        })
        .catch(err => response.json(err))
}
//The findOne method needs a condition that lets it know what type of information we require. 
const getOnePerson =(request,response) => {
    Person.findOne({_id:request.params.id}) 
        .then(person=>response.json(person))
        .catch(err=>response.json(err));
}

const updatePerson =(request,response) => {
    Person.findOneAndUpdate({_id:request.params.id}, request.body, {new:true})
        .then(updatePerson=>response.json(updatePerson))
        .catch(err=>response.json(err));
}

const deletePerson = (request, response) => {
    Person.deleteOne({ _id: request.params.id }) //note: "id" here MUST match id in corresponding route
        .then(deleteConfirmation => response.json(deleteConfirmation))
        .catch(err => response.json(err))
}
module.exports = {
    index,
    createPerson,
    getAllPeople,
    getOnePerson,
    updatePerson,
    deletePerson,
}; 

// FindOne METHOD : we are telling this method to return a document using our document's _id field, and we are specifying that this information will come via the client's request. The field specified must be written exactly as it is in your Schema (firstName, lastName, _id, etc). The client's request has an attribute called params. We can name our params whatever we want in your routes file. However, it MUST MATCH the variable in our route EXACTLY.