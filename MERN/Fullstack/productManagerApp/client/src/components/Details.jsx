import React from 'react'
import axios from 'axios';
import {useParams} from "react-router-dom";
import {useState,useEffect} from 'react';

const Details = (props) => {
    const [product, setProduct] = useState({})
    const {id} = useParams();

    useEffect(() =>{
        axios.get("http://localhost:8000/api/" + id)
            .then(res => {
                console.log(res.data);
                setProduct(res.data)
            })
            .catch(err=> console.log(err) );
    });
    return (
        <div>
            <h1> All Products</h1>
            <p>{product.product}</p>
        </div>
    )
}

export default Details