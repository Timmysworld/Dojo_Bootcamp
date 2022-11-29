import './App.css';
// import Details from './components/Details';
// import ProductForm from './components/productForm';
// import { BrowserRouter, Routes, Route} from 'react-router-dom'
import Main from './views/Main';


function App() {
  return (
    <div className="App">
      <header className="App-header"><h1>Product Manager</h1></header>
      {/* <BrowserRouter>
        <Routes>
          <Route element={<Main/>} path='/api/product'/>
          <Route element={<Details/>} path='/api/product/:id'/>
        </Routes>
      </BrowserRouter> */}
      <Main/>
    </div>
  );
}

export default App;
