import React from 'react'
import axios from 'axios'
import { useEffect } from 'react';
// import {Link} from 'react-router-dom';

const ProductList = (props) => {
    const {product, setProduct} = props;

    useEffect(()=>{
        axios.get("http://localhost:8000/api/")
            .then((res)=>{
                console.log(res.data);
                setProduct(res.data);
            })
            .catch((err)=>{
                console.log(err);
            });
    },[setProduct])
    return(
        <div>
            <h1> All Products </h1>
            { 
            // console.log(product);
                product.map((product,index)=>{
                    // console.log(product)
                    return (
                        <div key={index}>
                            <p>{product.product}</p>
                            {/* <Link to={`/product/${product._id}`}></Link> */}
                        </div>
                    )
                })
            }
        </div>
    
    );
}

export default ProductList