import React, {useState} from 'react'
// import Details from '../components/Details';
import ProductForm from '../components/productForm';
import ProductList from '../components/productList';

const Main = (props) => {
    const [products, setProducts] = useState([]);
    return (
        <div>
            <ProductForm products={products} setProducts={setProducts}/> <hr/>
            <ProductList products={products} setProducts={setProducts}/>
        </div>
        
    )
}

export default Main