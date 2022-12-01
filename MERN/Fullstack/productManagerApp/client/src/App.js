import './App.css';
import Details from './components/Details';
import { Routes, Route} from 'react-router-dom'
import Main from './views/Main';
import Update from './components/Update';
// import React, {useState} from 'react';


function App() {
  // const [products, setProducts] = useState([])
  return (
    <div className="App">
      <header className="App-header"><h1>Product Manager</h1></header>
        <Routes>
          <Route element={<Main />} path='/'/>
          <Route element={<Details/>} path='/api/product/:id'/>
          <Route element={<Update />} path="/api/product/edit/:id"/>
        </Routes>
      {/* <Main/> */}
    </div>
  );
}

export default App;

// if calling state on app.js (MAIN) You must pass in the state to whomever child components you want to use.