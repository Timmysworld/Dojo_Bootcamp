import React, { useState } from 'react'
import Display from './components/Display';
import Form from './components/Form';
import './App.css'

const App = () => {
  //parent state
  const [list, setList] = useState([]);
  return (

    <div className='wrapper'>
      <Form list={list} setList={setList} />
      <Display list={list} setList={setList} />
    </div>
  )
}

export default App
