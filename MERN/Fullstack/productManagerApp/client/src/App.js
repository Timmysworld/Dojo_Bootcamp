import './App.css';
import Details from './components/Details';
import { Routes, Route} from 'react-router-dom'
import Main from './views/Main';


function App() {
  return (
    <div className="App">
      <header className="App-header"><h1>Product Manager</h1></header>
        <Routes>
          <Route element={<Main/>} path='/'/>
          <Route element={<Details/>} path='/api/product/:id'/>
        </Routes>
      {/* <Main/> */}
    </div>
  );
}

export default App;
