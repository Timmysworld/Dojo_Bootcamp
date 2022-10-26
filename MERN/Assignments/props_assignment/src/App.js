import './App.css';
import PersonCard from './components/PersonCard';

function App() {
  return (
    <div className="App">
      <PersonCard 
          first_name={"John"}
          last_name={"Doe"}
          age={25}
          hair={"black"}
        />
      <PersonCard 
          first_name={"Jane"}
          last_name={"Doe"}
          age={35}
          hair={"blonde"}
        />
      <PersonCard 
          first_name={"Seth"}
          last_name={"Doe"}
          age={45}
          hair={"salt & pepper"}
        />
    </div>
  );
}

export default App;
