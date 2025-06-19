import  {useEffect, useState} from 'react';
import { WeatherData } from '../types/weather';
import { fetchWeatherData } from "../api/api";
import '../styles/Weather.css';
import React from 'react';

export const Weather = ({cityName}: {cityName: string}) => {
    const [weather, setWeather] = useState<WeatherData|null>(null);
    const [loading ,setLoading] = useState(false);
    const [error, setErrorMessage] = useState("");
  
    useEffect(() =>{

        if(!cityName){
            return;
        }
        
        const getWeatherData = async () => {
            try{
                setLoading(true);
                const response = await fetchWeatherData(cityName);
                setWeather(response);
                setErrorMessage("");
            }catch(err){
                setErrorMessage("Failed to get weather data.");
                setWeather(null);
            }finally{
                setLoading(false);
            }
        };
    
        getWeatherData();
    }, [cityName]);

    if(loading){
        return <p>Loading...</p>;
    }
    if(!weather || error){
        return <p>{error}</p>;
    }

    

    return (
        <div className='weather-card'>
        <h2>Weather in {weather.name}</h2>
        <p>{weather.weather[0].main} - {weather.weather[0].description}</p>
        <p>Temperature: {weather.main.temp}</p>
        <p>Feels like : {weather.main.feels_like}</p>
        <p>Humidity {weather.main.humidity}</p>
        <p>Wind Speed: {weather.wind.speed}</p>
    </div>  
    
    )
    
}
   