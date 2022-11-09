import React, { useState } from 'react'

const Display = ({list,setList}) => {

    return (
        <main> 
            {list.map((item,index)=>
                <div className='colorBox'key={index} style={{backgroundColor: item}}>
                <p>{item}</p>
            </div>
            )}
        </main>
    )
}

export default Display