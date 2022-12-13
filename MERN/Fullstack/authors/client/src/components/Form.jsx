import React, {useState} from 'react'
import axios from 'axios'
import {useNavigate} from 'react-router-dom'


const Form = () => {
    const [name, setName] = useState("");
    const [errors, setErrors] = useState({}); 
    const navigate = useNavigate();

    const onSubmitHandler = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8000/api/author', {
            name
        })
        .then(res=>{
            console.log(res);
            console.log(res.data)
            // setAuthorName ([...authorName,res.data])
            navigate("/");
        })
        .catch((err) => {
            console.log(err)
            console.log(err.response.data.error.errors);
            setErrors(err.response.data.error.errors);
        });

    }
    return (
        <div>
            <a href="/">Home</a>
            <p>Add a new author</p>

            <form onSubmit={onSubmitHandler}>
                <label>Name:</label>
                {errors.name ?
                    <p style={{color:"red"}}>{errors.name.message}</p>
                    : null}
                <input type="text" 
                onChange={(e)=>setName(e.target.value)}
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

// .then((res) => {
//     console.log(res.data);
//     //if we have validation errors NOT errors with server
//     if(res.data.error){
//         setErrors(res.data.error.errors)
//         // console.log("CHECKING SOMETHING");
//     }
//     else {
//         // on success 
//         navigate("/products/");
//     }
// })
// //on failure, save errors in state so the user can correct the incorrect inputs
// .catch((err) => {
//     console.log(err);
// })
// }
        // .catch(err=>{
        //     const errorResponse = err.response.data.errors; // Get the errors from err.response.data
        //     console.log(err)
        //     const errorArr = []; // Define a temp error array to push the messages in
        //     for (const key of Object.keys(errorResponse)) { // Loop through all errors and get the messages
        //         errorArr.push(errorResponse[key].message)
        //     }
        //     // Set Errors
        //     setErrors(errorArr);
        // })            
        // .catch(err=>console.log(err))