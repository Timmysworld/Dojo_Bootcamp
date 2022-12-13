import React, {useEffect, useState} from 'react'
import axios from 'axios';
import {useNavigate, useParams} from 'react-router-dom';

const Update = (props) => {
    const {id} = useParams();

    const [name,setName] = useState();
    const [errors, setErrors] = useState({});
    const navigate = useNavigate();

    useEffect(()=>{
        axios.get(`http://localhost:8000/api/author/${id}`)
            .then(res => {
                console.log(res.data)
                setName(res.data.name);
            })
            .catch(err => console.log(err))
    }, [id, setName])

    const updateOneAuthor = (e)=>{
        e.preventDefault();
        axios.put(`http://localhost:8000/api/author/${id}`,{
            name
        })
            .then(res=> {
                console.log(res);
                console.log(res.data)
                navigate('/');
            })
            .catch((err) => {
                console.log(err)
                console.log(err.response.data.error.errors);
                setErrors(err.response.data.error.errors);
            });
            // .catch(err=>console.log(err))
    }

    return (
        <div>
            <h1>Update Author</h1>
            <form onSubmit={updateOneAuthor}>
                <div>
                    <label>Name:</label><br/>
                    {errors.name ?
                    <p style={{color:"red"}}>{errors.name.message}</p>
                    : null}
                    <input type="text"
                    name="name"
                    value={name}
                    onChange ={(e)=>{
                        setName(e.target.value)
                    }}/>
                </div>
                <input type="submit" />
            </form>
        </div>
    )
}

export default Update