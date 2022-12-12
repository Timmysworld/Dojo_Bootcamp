const mongoose = require('mongoose');

const AuthorsSchema = new mongoose.Schema(
    {
        name: String,
    },{ timestamps: true }
);

module.exports = mongoose.model('Authors', AuthorsSchema);