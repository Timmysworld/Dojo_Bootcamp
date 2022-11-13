import './App.css';
import {useEffect, useState} from 'react'
import axios from 'axios' 

function App() {
  const [pokemon, setPokemon] = useState([])

  useEffect(() => {
    axios.get('https://pokeapi.co/api/v2/pokemon?limit=807&offset=0')
    .then((res)=>{
      console.log(res)
      setPokemon(res.data.results)
    })
    .catch((err)=>{
      console.log(err)
    })
  },[])
  
  return (
    <div className="App">
      <header className="App-header">
        <h1> Pokemon </h1>
        <p>Gotta catch 'em All! </p>
        <p> api call using axios </p>
      </header>

      <>
        {
          pokemon.map((poké)=>(
            // key must be unique, usually its an id of what we are rendering
              <ul key={poké.name}> 
                <li>{poké.name}</li>
              </ul>
            ))
        }
      </>

    </div>
  );
}

export default App;
