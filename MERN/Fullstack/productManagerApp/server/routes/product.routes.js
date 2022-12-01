const ProductController = require('../controllers/product.controllers'); //IMPORT THE CODE FROM P.CONTROLLER.JS

module.exports = app => {
    app.get('/api',ProductController.getProducts);

    //CREATE 
    app.post('/api/product', ProductController.createProduct)

    //READ
    app.get('/api/product/:id', ProductController.getAProduct)

    // UPDATE & DELETE
    app.put('/api/product/:id',ProductController.updateProduct)
    app.delete('/api/product/:id',ProductController.deleteProduct)
}