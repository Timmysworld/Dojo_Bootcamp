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

const updateProduct =(request, response) => {
    Product.findOneAndUpdate({_id:request.params.id},request.body, {new:true})
        .then(updateProduct=>response.json(updateProduct))
        .catch(err=>response.json(err));
}

const deleteProduct =(request, response) =>{
    Product.deleteOne({_id: request.params.id})
        .then(deleteConfirmation => response.json(deleteConfirmation))
        .catch(err => response.json(err))
}


module.exports = {
    getProducts,
    createProduct,
    getAProduct,
    updateProduct,
    deleteProduct,
}; 