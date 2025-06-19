import React, { ReactEventHandler, useEffect, useState } from 'react';
import styles from '../styles/FormPage.module.css';
import { FormData } from '../types/FormData';

export const FormPage = () => {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [experience, setExperience] = useState('');
    const [skills, setSkills] = useState<string[]>([]);
    const [formData, setFormData] = useState<FormData| null>(null);
    const [buttonState, setButtonState] = useState(true);

    const handleCheckBoxChange = (skill: string) =>
    {
        setSkills(skills => 
            skills.includes(skill) ? skills.filter(s => s !== skill)
            : [...skills, skill]
        );
    }

    useEffect( () =>{
        if(!name || !email || !experience || skills.length === 0){
            setButtonState(true);
        }else{
            setButtonState(false);
        }
    },[name, email, experience, skills]);
    

    function handleSubmit(): void {

        if(name && email && experience && skills){
            setFormData({name, email,experience, skills});
            setName('')
            setEmail('');
            setExperience('');
            setSkills([]);
        }else{
            alert("Please fill out required fields");
           
        }
    }

    return (
       <form onSubmit={(e) => handleSubmit()}>
        
        <div className={styles.formCard}>
        <h2>Job Application Form</h2>
            <div>
                <label>Name</label>
                <input 
                    id='name' 
                    type='text' 
                    onChange={e => setName(e.target.value)}
                    value={name}>
                </input>
            </div>

            <div>
                <label>Email</label>
                <input 
                    id='email' 
                    type='text' 
                    onChange={e => setEmail(e.target.value)}
                    value={email}>
                </input>
            </div>

            <div>
                <p>Experience Level</p>
                {['Junior', 'Mid-Level', 'Senior'].map(level => (
                    <label>
                    <input 
                        type='radio' 
                        value={level}
                        checked = {experience === level}
                        onChange={e => setExperience(e.target.value)}/>
                    {level}
                </label>
                )    
                )}
            
            </div>
            <div>
                <p>Skills</p>
               
                {["HTML", "CSS", "JS", "React", "Node"].map( skill =>(
                    <label>
                        <input 
                            type='checkbox' 
                            value={skill}
                            onChange={() => handleCheckBoxChange(skill)}
                            checked={skills.includes(skill)}>
                        </input>
                        {skill}
                    </label>
                ))}
                
            </div>
            <button disabled={buttonState} type="submit">Submit</button>
        </div>
        </form>
    )
};

