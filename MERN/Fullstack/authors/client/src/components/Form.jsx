import React from 'react'
import axios from 'axios'

const Form = ({authorName, setAuthorName}) => {

    const onSubmitHandler = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8000/api/author', {
            authorName
        })
        .then(res=>{
            console.log(res);
            console.log(res.data)
            setAuthorName ([...authorName,res.data])
        })
        .catch(err=>console.log(err))
    }


    return (
        <div>
            <a href="/">Home</a>
            <p>Add a new author</p>

            <form onSubmit={onSubmitHandler}>
                <label>Name:</label>
                <input type="text" 
                onChange={(e)=>setAuthorName(e.target.value)}
                />
                <div className="btn"> 
                    <button >Cancel</button> 
                    <input type='Submit'/>
                </div>
            </form>

        </div>
    )
}

export default Form