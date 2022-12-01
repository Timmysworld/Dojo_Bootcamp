import React, { useState } from 'react'
// import Details from '../components/Details';
import ProductForm from '../components/productForm';
import ProductList from '../components/productList';


const Main = (props) => {
const [products, setProducts] = useState([])

    const removeFromDom = pid => {
        setProducts(products.filter(product => product._id !== pid)); //We could also write this in our PersonList component
    }
    return (
        <div className='wrapper'>
            <ProductForm products={products} setProducts={setProducts}/> <hr/>
            <ProductList products={products} setProducts={setProducts} removeFromDom={removeFromDom}/>
        </div>
        
    )
}

export default Main