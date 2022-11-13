import './App.css';
import {useEffect, useState} from 'react'


function App() {
    const [pokemon, setPokemon] = useState([])
    
    useEffect(()=>{
      fetch('https://pokeapi.co/api/v2/pokemon?limit=807&offset=0')
      // .then(res =>res.json())
      // .then(res =>setPokemon(res.result))
      .then((res)=>{
        return res.json()
      })
      .then((res)=>{
        console.log(res.results)
        setPokemon(res.results)
      })
      .catch((err)=>{
        console.log(err)
      })
    },[]);

  return (
    <div className="App">
      <header className="App-header">
        <h1> POKEMON</h1>
        <p>Gotta catch 'em all</p>
      </header>

      <>
      {
        pokemon.map((pName,index)=>(
          <ul>
            <li>{pName.name}</li>
          </ul>
        ))
      }

  
      </>

    </div>
  );
}

export default App;
