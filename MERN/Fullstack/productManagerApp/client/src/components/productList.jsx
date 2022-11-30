import React from 'react'
import axios from 'axios'
import { useEffect } from 'react';
import {Link} from 'react-router-dom';

const ProductList = (props) => {
    const {products, setProducts} = props;

    useEffect(()=>{
        axios.get("http://localhost:8000/api/")
            .then((res)=>{
                //res is an object
                console.log(res.data);
                setProducts(res.data);
            })
            .catch((err)=>{
                console.log(err);
            });
    },[setProducts])
    return(
        <div>
            <h1> All Products </h1>
            { 
            // console.log(product);
            //map through the getter from props
                products.map((product, index)=>{
                    // console.log(product)
                    return (
                        //make the key unique DO NOT USE INDEX 
                        <div key={product.id}>
                            <Link to={`/api/product/${product._id}`}>{product.product}</Link> 
                        </div>
                    )
                })
            }
        </div>
    
    );
}

export default ProductList