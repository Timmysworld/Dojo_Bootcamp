import './App.css';
import React,{useState} from 'react'
import NavBar from './components/navbar';
import Form from './components/form';
import Display from './components/display';

function App() {
  const arr = [
    {content: 'conquer world', complete : false},
    {content: 'be amazing', complete: false}];
  const [list, setList] = useState(arr);

  return (
    <div className="App">
      <header className="App-header">
        <NavBar/>
      </header>

      <wrapper> 
        <Form list={list} setList={setList}/>
        <Display list={list} setList={setList} />
      </wrapper>
      

    </div>
  );
}

export default App;
