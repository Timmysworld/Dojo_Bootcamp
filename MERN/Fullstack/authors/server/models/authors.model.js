const mongoose = require('mongoose');

const AuthorsSchema = new mongoose.Schema(
    {
        name:{
            type: String,
            required:[
                true,
                "Name is required"
                
            ],
            minlength: [
                3, "minimum length is 3 characters"
            ]
        },
    },{ timestamps: true }
);

module.exports = mongoose.model('Authors', AuthorsSchema);