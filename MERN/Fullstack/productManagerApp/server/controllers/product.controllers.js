const Product = require('../models/product.model');

const getProducts = (req, res) => {
    Product.find()
            .then((allProducts)=> res.json(allProducts))
            .catch((err)=> console.log(err))
};

const createProduct = (request, response) => {
    Product.create(request.body)
            .then(product=>response.json(product))
            .catch(err =>{console.log(err);
                response.json(err)})
};

const getAProduct = (request,response) => {
    Product.findOne({_id:request.params.id})
    // console.log(product)
            .then(product=>response.json(product))
            .catch(err=>response.json(err));
}


module.exports = {
    getProducts,
    createProduct,
    getAProduct,
}; 