import React, {useState} from 'react';


const PersonCard = (props) => {
    const [isAge, setAge]  = useState(props.age)
    return (
        <div>
            <h2>{props.first_name} {props.last_name}</h2>
            <p> Age: {isAge}</p>
            <p> Hair Color: {props.hair}</p>
            <button onClick={(event) => setAge(isAge + 1)}>{props.first_name} Birthday</button>
        </div>
    )
}
export default PersonCard;

// rafce