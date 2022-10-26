import React from 'react';

const PersonCard = (props) => {
    return (
        <div>
            <h2>{props.first_name} {props.last_name}</h2>
            <p> Age: {props.age}</p>
            <p> Hair Color: {props.hair}</p>
        </div>
    )
}
export default PersonCard;