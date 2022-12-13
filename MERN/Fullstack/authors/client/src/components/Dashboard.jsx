import React from 'react'
import axios from 'axios';
import {useEffect} from 'react';
import {Link} from 'react-router-dom';

const Dashboard = ({name, setName}) => {

    useEffect(()=>{
        axios.get(`http://localhost:8000/api/all`)
            .then(res=>{
                console.log(res.data);
                setName(res.data)
            })
            .catch(err=>console.log(err));
    },[setName]);

    // const removeFromDom = aid => {
    //     setName(name.filter(name => name._id !== aid)); //We could also write this in our PersonList component
    // }

    const deleteAuthor = (aid) => {
        axios.delete('http://localhost:8000/api/author/' + aid)
            .then(res=>{
                console.log(res.data)
                setName(name.filter(name => name._id !== aid));
                // removeFromDom(aid)
                // setProducts(res.data)
            })
            .catch(err=>console.log(err))
    }

    return (
        <main>
            <a href='/new'>Add an author</a>
            <p>We have Quotes by:</p>
                <table >
                    <thead>
                        <tr>
                            <th>Author</th>
                            <th>Action Available</th>
                        </tr>
                    </thead>
                    <tbody>                              
                    {name.map((author,index)=>{
                        return <tr key={index}>
                            <td>{author.name}</td>
                            <td> <Link to={`/edit/${author._id}`}> Edit </Link> | <button onClick={(e)=>{deleteAuthor(author._id)}}>Delete</button></td>
                                </tr>
                                })}
                    </tbody>
                </table>
    </main>
    )
}

export default Dashboard

// const removeFromDom = pid => {
//     setProducts(products.filter(product => product._id !== pid)); //We could also write this in our PersonList component
// }
// removeFromDom={removeFromDom}