import './App.css';
import {BrowserRouter,Routes,Route} from 'react-router-dom';
import Home from './component/Home';
import Main from './component/Main';

function App() {

  return (
    <div className="App">
      <BrowserRouter>
          <h1>Welcome to my App</h1>
          <Routes>
            <Route path="/home" element={<Home/>}/>
            <Route path="/:word" element={<Main/>}/>
            <Route path="/:word/:color/:bgCol" element={<Main/>}/>
          </Routes>
      </BrowserRouter>,
    </div>
  );
}

export default App;
