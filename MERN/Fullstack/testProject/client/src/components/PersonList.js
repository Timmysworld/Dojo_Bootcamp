import React from 'react'
import axios from 'axios';
import {Link} from 'react-router-dom';


const PersonList = (props) => {
    /* We deconstruct getter and setter which were passed down 
    via props by the parent component (app.js) to our child 
    component (PersonList.js). Now we can easily use the getter 
    and setter without having to write props.getter or props.setter every time: */
    const {removeFromDom, people, setPeople} = props;

    const deletePerson = (personId) => {
        axios.delete('http://localhost:8000/api/people/' + personId)
            .then(res => {
                console.log(res.data)
                removeFromDom(personId)
                setPeople(res.data)
            })
            .catch(err => console.log(err))
    }
    
    // useEffect(()=>{
    // axios.get("http://localhost:8000/api/people")
    //     .then((res)=>{
    //         console.log(res.data);
    //         setPeople(res.data);
	// })
    //     .catch((err)=>{
    //         console.log(err);
    //     });
    // },  )
    
    return (
        <div>
            {
                people.map((person, index)=>{ 
                return (
                    <div key={index}> 
                        <Link to={"/api/people/" + person._id}>
                            {person.lastName}, {person.firstName}
                        </Link>
                            |
                        <Link to={"/api/people/edit/" + person._id}>
                            Edit
                        </Link>
                            |
                        <button onClick={(e)=>{deletePerson(person._id)}}>
                            Delete
                        </button>
                    </div> 
                )})
            }
        </div>
    );
}
export default PersonList;

/* Like our JSX return, map requires ONE parent element, so let's refactor. */
/* Look to Code Block 3. That :id gets its value right here. 

Clicking this element will assign the "id" param the value of this document's _id field 

This will take us to a path similar to "localhost:3000/people/627837837af9898989c9848"  */