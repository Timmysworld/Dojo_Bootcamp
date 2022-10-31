import React, {useState} from 'react';

const MoreForm = (props) => {
    const [first_name, setFirstName] = useState("");
    const [last_name, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const [errorMessage, setErrorMessage] = useState({first_name:"",last_name:"",email:"",password:"",confirmPassword:""});

    const validations = () =>{
        
        if(first_name && name.length< 2){
            //prev = important when using previous last function of state.
            setErrorMessage(prev=>({...prev,first_name:"First Name must be at least 2 characters"}))
        }else{
             // an empty string is considered a "falsy" value
            setErrorMessage(prev=>({...prev,first_name:""}))
            setErrorMessage("");
        }
        if(email.length < 2){
            setErrorMessage(prev=>({...prev,last_name:"Last Name must be at least 2 characters"}))
        }else{
            setErrorMessage(prev=>({...prev,last_name:""}))
            setErrorMessage("");
        }
    }

    return (
        <div>
            <form>
                <div>
                    <label htmlFor='first_name'>First Name:</label>
                    <input 
                        type="text" 
                        value={first_name} 
                        name="first_name" 
                        onChange={(e)=>{
                            setFirstName(e.target.value)
                            validations()
                        }}
                    />
                    {
                        errorMessage.first_name?
                        <p>{errorMessage.first_name}</p> :
                        ''
                    }
                </div>
                <div>
                    <label htmlFor='last_name'>Last Name:</label>
                    <input 
                    type="text" 
                    value={last_name} 
                    name="last_name" 
                    onChange={(e)=>{
                        setLastName(e.target.value)
                        validations()
                    }}
                    />
                    {
                        errorMessage.last_name?
                        <p>{errorMessage.last_name}</p> :
                        ''
                    }
                </div>
                <div>
                    <label htmlFor='email'>Email:</label>
                    <input type="text" value={email} name="email" onChange={(e)=>setEmail(e.target.value)}/>
                </div>
                <div>
                    <label htmlFor='password'>Password:</label>
                    <input type="password" value={password} name="password" onChange={(e)=>setPassword(e.target.value)}/>
                </div>
                <div>
                    <label htmlFor='confirmPassword'>Confirm Password:</label>
                    <input type="text" value={confirmPassword} name="confirmPassword" onChange={(e)=>setConfirmPassword(e.target.value)}/>
                </div>
            </form>
        </div>
    )
};
export default MoreForm;
