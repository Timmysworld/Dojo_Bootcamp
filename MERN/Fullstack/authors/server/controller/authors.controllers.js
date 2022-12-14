const Authors = require('../models/authors.model');

const getAuthors = (req, res) => {
    Authors.find()
        .then((allAuthors)=>res.json(allAuthors))
        .catch(err => response.status(400).json({ message: "Oh no! Something went wrong!", error: err }));
        //.catch((err)=>console.log(err))
};

const createAuthors = (request, response) => {
    Authors.create(request.body)
        .then(authors=>response.json(authors))
        .catch(err => response.status(400).json({ message: "Oh no! Something went wrong!", error: err }));
        // .catch(err => {console.log(err);
        //     response.json(err)})
};

const getOneAuthor = (request, response) => {
    Authors.findOne({_id:request.params.id})
        .then(author=>response.json(author))
        .catch(err => response.status(400).json({ message: "Oh no! Something went wrong!", error: err }));
        //.catch(err=> response.json(err));
}

const updateAuthor = (request, response) => {
    Authors.findOneAndUpdate({_id:request.params.id},request.body, {new:true,runValidators:true})
        .then(author=>response.json(author))
        .catch(err => response.status(400).json({ message: "Oh no! Something went wrong!", error: err }));
        //.catch(err=>response.json(err));
};

const deleteAuthor = (request, response)=> {
    Authors.deleteOne({_id:request.params.id})
        .then(deleteConfirmation => response.json(deleteConfirmation))
        .catch(err => response.status(400).json({ message: "Oh no! Something went wrong!", error: err }));
        //.catch(err => response.json(err))
}


module.exports ={
    getAuthors,
    createAuthors,
    getOneAuthor,
    updateAuthor,
    deleteAuthor,
};