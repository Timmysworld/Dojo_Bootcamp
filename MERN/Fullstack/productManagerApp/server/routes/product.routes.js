const ProductController = require('../controllers/product.controllers'); //IMPORT THE CODE FROM P.CONTROLLER.JS

module.exports = app => {
    app.get('/api',ProductController.getProducts);
    app.post('/api/product', ProductController.createProduct)
    app.get('/api/product/:id', ProductController.getAProduct)
}