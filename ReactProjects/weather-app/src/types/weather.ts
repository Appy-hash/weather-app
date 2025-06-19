export interface WeatherData {
    wind: any;
    name: string;
    main: {
        humidity: number;
        feels_like: number;
        temp: number;
    };
    weather: {
        main: string;
        description: string;
        icon: string;
    }[] ;
}