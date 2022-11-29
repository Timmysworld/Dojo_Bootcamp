const Product = require('../models/product.model');

const getProduct = (req, res) => {
    Product.find()
            .then((allProducts)=> res.json(allProducts))
            .catch((err)=> console.log(err))
};

const createProduct = (request, response) => {
    Product.create(request.body)
            .then(product=>response.json(product))
            .catch(err =>response.json(err))
};


module.exports = {
    getProduct,
    createProduct
}; 