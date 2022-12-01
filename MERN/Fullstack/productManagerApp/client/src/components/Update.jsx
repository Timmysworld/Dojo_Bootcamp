import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { useNavigate, useParams } from 'react-router-dom';

const Update = (products,setProducts) => {
    const {id} = useParams();

    const [product, setProduct] = useState();
    const [price, setPrice] = useState();
    const [description, setDescription] = useState();
    const navigate = useNavigate();

    useEffect(()=>{
        axios.get(`http://localhost:8000/api/product/${id}`)
            .then(res => {
                setProduct(res.data.product);
                setPrice(res.data.price);
                setDescription(res.data.description);
            })
            .catch(err => console.log(err))
    }, [id])

    const updateProduct = (e) => {
        e.preventDefault();
        axios.put(`http://localhost:8000/api/product/${id}`,{
            product,
            price,
            description
        })
            .then(res =>{
                console.log(res);
                navigate('/');
            })
            .catch(err=>console.log(err))
    }
    return (
        <div>
            <h1>Update Product</h1>
            <form onSubmit ={updateProduct}>
                <p>
                    <label>Product</label><br/>
                    <input type="text"
                    name='product'
                    value={product}
                    onChange ={(e)=>{
                        setProduct(e.target.value)}}/>
                </p>
                <p>
                    <label>Price</label><br/>
                    <input type="number"
                    name='price'
                    value={price}
                    onChange ={(e)=>{
                        setPrice(e.target.value)}}/>
                </p>
                <p>
                    <label>Description</label><br/>
                    <input type="text"
                    name='Description'
                    value={description}
                    onChange ={(e)=>{
                        setDescription(e.target.value)}}/>
                </p>
                <input type="submit" />
            </form>
        </div>
    ) 
}

export default Update