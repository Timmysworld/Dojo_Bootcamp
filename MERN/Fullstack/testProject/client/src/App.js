import './App.css'
import React from 'react';
import { BrowserRouter ,Routes, Route } from 'react-router-dom';
import Main from './views/Main';
import Detail from './components/Detail';


function App() {
  return (
    <div className="App">
      <header className="App-header">Test Project </header>
      <BrowserRouter>
        <Routes>
          <Route element={<Main/>} path="/api/people" />
          <Route element={<Detail/>} path="/api/people/:id" />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;






