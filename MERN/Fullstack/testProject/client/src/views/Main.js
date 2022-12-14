// It is important that when we add a new person using our form we will see that addition appear in the list of people being displayed. To do this, both the PersonForm and PersonList will need to share some state.

import React, { useState } from 'react'
import PersonForm from '../components/PersonForm';
import PersonList from '../components/PersonList';

const Main = (props) => {
    
    const [people, setPeople] = useState([]);

    const removeFromDom = personId => {
        setPeople(people.filter(person => person._id !== personId)); //We could also write this in our PersonList component
    }
    
    return (
        <div>
            <PersonForm people={people} setPeople={setPeople} /> 
            <hr/>
            <PersonList people={people} setPeople={setPeople} removeFromDom={removeFromDom}/>
        </div>
    )
}
export default Main;


/* PersonForm and Person List can both utilize the getter and setter established in their parent component:  */