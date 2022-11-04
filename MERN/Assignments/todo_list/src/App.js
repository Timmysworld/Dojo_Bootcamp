import './App.css';
import NavBar from './components/navbar';
import Form from './components/form';
import Display from './components/display';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <NavBar/>
      </header>

      <wrapper> 
        <Form/>
        <Display/>
      </wrapper>
      

    </div>
  );
}

export default App;
