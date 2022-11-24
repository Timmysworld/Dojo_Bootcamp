import React, { useState } from 'react'
import axios from 'axios' 

const PersonForm = (props) => {
    const {people,setPeople} = props; //destructing state to use as props from /views/main.js
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");

    const onSubmitHandler = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8000/api/people',{
            firstName,
            lastName
        })
        .then(res=>{
            console.log(res);
            console.log(res.data)
            setPeople([...people,res.data]); //update the lifted state of our people array to include current value in state plus the single new object created and returned from ojur post request.
        })
        .catch(err=>console.log(err))
    }
        return(
            <form onSubmit={onSubmitHandler}>
            <p>
                <label>First Name</label><br/>
                {/* When the user types in this input, our onChange synthetic event 
                    runs this arrow function, setting that event's target's (input) 
                    value (what's typed into the input) to our updated state   */}
                <input type="text" onChange = {(e)=>setFirstName(e.target.value)}/>
            </p>
            <p>
                <label>Last Name</label><br/>
                <input type="text" onChange = {(e)=>setLastName(e.target.value)}/>
            </p>
            <input type="submit"/>
        </form>
        )
}

export default PersonForm;