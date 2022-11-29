import React, {useState} from 'react'
// import Details from '../components/Details';
import ProductForm from '../components/productForm';
import ProductList from '../components/productList';

const Main = (props) => {
    const [product, setProduct] = useState([]);
    return (
        <div>
            <ProductForm product={product} setProduct={setProduct}/> <hr/>
            <ProductList product={product} setProduct={setProduct}/>
        </div>
        
    )
}

export default Main