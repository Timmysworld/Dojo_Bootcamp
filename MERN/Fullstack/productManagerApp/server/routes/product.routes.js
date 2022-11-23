const ProductController = require('../controllers/product.controllers'); //IMPORT THE CODE FROM P.CONTROLLER.JS

module.exports = app => {
    app.get('/api',ProductController.getProduct);
    app.post('/api/product', ProductController.createProduct)
}