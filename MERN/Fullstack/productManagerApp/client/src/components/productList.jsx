import React from 'react'
import axios from 'axios'
import { useEffect } from 'react';
import {Link} from 'react-router-dom';

const ProductList = (props) => {
    const {products, setProducts, removeFromDom} = props;

    const deleteProduct = (pid) => {
        axios.delete('http://localhost:8000/api/product/' + pid)
            .then(res=>{
                console.log(res.data)
                removeFromDom(pid)
                // setProducts(res.data)
            })
            .catch(err=>console.log(err))
    }

    //Anytime you want to READ your list you want to use useEffect
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
                            <Link to={`/api/product/${product._id}`}>
                                {product.product}
                            </Link> 
                                |
                            <Link to={'/api/product/edit/' + product._id}>
                                Edit
                            </Link>   
                                |
                            <button onClick={(e)=>{deleteProduct(product._id)}}>
                            Delete
                            </button>
                        </div>
                    )
                })
            }
        </div>
    
    );
}

export default ProductList

