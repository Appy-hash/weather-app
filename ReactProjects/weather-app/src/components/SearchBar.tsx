import React, {useState } from "react";
import '../styles/SearchBar.css';

interface SearchProps {
    onSearch : (query : string) => void
}

export const SearchBar: React.FC<SearchProps> = ({onSearch}: { onSearch : (arg0: string) => void}) =>{
    const [searchInput, setSearchInput] = useState<string>('');

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) =>{
        const value = e.target.value;
        setSearchInput(value);
    }


    const handleKeyDown = (e: React.KeyboardEvent<HTMLInputElement>) =>{
        if(e.key === "Enter"){
            onSearch(searchInput.trim());
        }
    };
    
    return (
       <input 
            className='searchBar'
            type="text" 
            placeholder="Search city" 
            onChange={handleChange} 
            onKeyDown={handleKeyDown}
            value = {searchInput}
            style={{padding: '0.5rem', fontSize: '1rem', width: '250px'}} />
    )
}