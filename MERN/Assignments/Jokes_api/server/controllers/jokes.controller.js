const Joke = require('../models/jokes.model');

const getAllJokes = (req, res) => {
    Joke.find()
        .then((allJokes) => res.json(allJokes))
        .catch((err) => console.log(err));
};

const findOneSingleJoke = (req,res)=>{
    const {params} = req
    Joke.findOne({_id: params.id})
        .then((oneSingleJoke) => res.json(oneSingleJoke))
        .catch((err)=> console.log(err));
};

const createNewJoke = (req, res) => {
    const { body } = req; // <== destructuring
    Joke.create(body)
        .then((newlyCreatedJoke) => res.json( newlyCreatedJoke))
        .catch((err) => console.log( err ));
};

const updateExistingJoke = (req, res) => {
    Joke.findOneAndUpdate(
        { _id: req.params.id },
        req.body,
        { new: true, runValidators: true }
    )
        .then((updatedJoke) => res.json( updatedJoke ))
        .catch((err) => console.log(err ));
};

const deleteAnExistingJoke = (req, res) => {
    Joke.deleteOne({ _id: req.params.id })
        .then((result) => res.json(result ))
        .catch((err) => console.log(err))
};

module.exports = {
        getAllJokes,
        findOneSingleJoke,
        createNewJoke,
        updateExistingJoke,
        deleteAnExistingJoke,
        };