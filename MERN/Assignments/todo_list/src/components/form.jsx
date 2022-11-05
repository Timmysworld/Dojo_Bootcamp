import React from 'react'
import { useState } from 'react'

const Form = ({list,setList}) => {
    const [input, setInput] = useState("");

    const handleSubmit = e => {
        e.preventDefault();
        setList([...list,
            // get the input
            // default complete is false
            {content: input, complete : false}
        ])
        setInput("");
    }
    return (
        <div className="FormDiv">
            <div className='FormTitle'>
                <h2>To Do list</h2>
            </div>
            
            <form onSubmit={handleSubmit}>
                {/* use state to get the value */}
                <input 
                    type="text"
                    value={input}
                    name="input"
                    onChange={(e)=>setInput(e.target.value)}/>
                <button type="submit">ADD!</button>
            </form>
            {/* {input} */}

            
        </div>
    )
}

export default Form