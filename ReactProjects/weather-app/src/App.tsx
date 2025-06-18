import React, {useState } from 'react';
import { Weather } from './components/Weather';
import { SearchBar } from './components/SearchBar';

import './styles/App.css';


function App() {
  const [city, setCity] = useState<string>('');
  
  return (
    <div className='app-card'>
      {!city && <h1>Enter a city to get Weather</h1>}
        <SearchBar onSearch={setCity}/>
         {city && <Weather cityName={city}/>}
    </div>
  );
}

export default App;
