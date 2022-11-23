import React,{ useState } from 'react'
import axios from 'axios'

const ProductForm = () => {
    const [product,setProduct] = useState("");
    const [price, setPrice] = useState("");
    const [description, setDescription] = useState("");

    const onSubmitHandler = (e) =>{
        e.preventDefault();
        axios.post('http://localhost:8000/api/product',{
            product,
            price,
            description
        })
        .then(res=>{
            console.log(res);
            console.log(res.data)
        })
        .catch(err=>console.log(err))

    }
    return (
        <div>
        <form onSubmit={onSubmitHandler}>
            <div className='form-fields'>
                <label>Product</label><br/>
                <input type="text" onChange = {(e)=>setProduct(e.target.value)}/>
            </div>
            <div className='form-fields'>
                <label>Price</label><br/>
                <input type="text" onChange = {(e)=>setPrice(e.target.value)}/>
            </div>
            <div className='form-fields'>
                <label>Description</label><br/>
                <input type="text" onChange = {(e)=>setDescription(e.target.value)}/>
            </div>
            <input type="submit" className='submit-input'/>
            
        </form>
        </div>
            
    )
}

export default ProductForm
