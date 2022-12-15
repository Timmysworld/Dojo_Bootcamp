import './App.css';
import Dashboard from './components/Dashboard';
import {Routes, Route} from 'react-router-dom'
import Form from './components/Form';
import Update from './components/Update';
import React, {useState} from 'react';

function App() {
  const [name,setName] = useState([]);
  const [authorName, setAuthorName]= useState("");
  return (
    <div className="App">
      <h1>Favorite Authors</h1>
      <Routes>
        <Route path='/' element={<Dashboard name={name} setName={setName}/>}/>
        
        <Route path='/new' element={<Form/>}/>
        <Route path='/edit/:id' element={<Update authorName={authorName} setAuthorName={setAuthorName}/>}/>
      </Routes>
    </div>

  );
}

export default App;
