import React, { useState } from 'react'

const Form = ({list,setList}) => {
    const [boxColor, setBoxColor] = useState("");

    const submitHandler = (e) =>{
        e.preventDefault();
        setList([...list,boxColor])
        console.log(list);
    }
    return (
        <div className='formBox mx-auto'>
            <h1>Box Generator</h1>
            <form onSubmit={submitHandler}>
                <div className='col-auto form-control'>
                    <label htmlFor="color">Color:</label>
                    <input 
                        className='form-control'
                        type="text"
                        name="color" 
                        value={boxColor} 
                        onChange={(e)=>setBoxColor(e.target.value) } />
                    <button className='btn btn-primary form-control mt-2'>Add</button>
                </div>
                <div className="col-auto">
                    
                </div>
            </form>
        </div>
    )
}

export default Form

