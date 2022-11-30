const Product = require('../models/product.model');

const getProduct = (req, res) => {
    Product.find()
            .then((allProducts)=> res.json(allProducts))
            .catch((err)=> console.log(err))
};

const createProduct = (request, response) => {
    console.log("createBody")
    console.log(request.body)
    Product.create(request.body)
            .then(product=>response.json(product))
            .catch(err =>{console.log(err);
                response.json(err)})
};


module.exports = {
    getProduct,
    createProduct
}; 