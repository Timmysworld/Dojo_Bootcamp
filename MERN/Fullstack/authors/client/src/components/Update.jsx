import React, {useEffect, useState} from 'react'
import axios from 'axios';
import {useNavigate, useParams} from 'react-router-dom';

const Update = (authorName, setAuthorName) => {
    const {id} = useParams();

    const [name,setName] = useState();
    const navigate = useNavigate();

    useEffect(()=>{
        axios.get(`http://localhost:8000/api/author/${id}`)
            .then(res => {
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
                navigate('/');
            })
            .catch(err=>console.log(err))
    }

    return (
        <div>
            <h1>Update Author</h1>
            <form onSubmit={updateOneAuthor}>
                <p>
                    <label>Name:</label><br/>
                    <input type="text"
                    name="name"
                    value={name}
                    onChange ={(e)=>{
                        setName(e.target.value)
                    }}/>
                </p>
                <input type="submit" />
            </form>
        </div>
    )
}

export default Update