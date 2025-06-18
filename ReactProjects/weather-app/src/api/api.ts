import axios from 'axios';
import { WeatherData } from '../types/weather';

const WEATHER_API_URL
 = "https://api.openweathermap.org/data/2.5/weather";
export async function fetchWeatherData(city:string) {
    try{
        const params = { q: city, appid: "dc747fd9427c97c7ae8b8a41284bb411",units: "imperial"};
        const response = await axios.get<WeatherData>(WEATHER_API_URL, {
            params
        });
        return response.data;
    } catch (error) {
        console.error("failed to fetch weather data:" , error);
        throw error;
    }
}