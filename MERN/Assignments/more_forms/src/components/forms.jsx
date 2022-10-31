import React, {useState} from 'react';

const MoreForm = (props) => {
    const [first_name, setFirstName] = useState("");
    const [last_name, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    // const [errorMessage, setErrorMessage] = useState({first_name:"",last_name:"",email:"",password:"",confirmPassword:""});

    // const validations = () =>{
        
    //     if(first_name < 2){
    //         //prev = important when using previous last function of state.
    //         setErrorMessage(prev=>({...prev,first_name:"First Name must be at least 2 characters"}))
    //     }else{
    //          // an empty string is considered a "falsy" value
    //         setErrorMessage(prev=>({...prev,first_name:""}))
    //         setErrorMessage("");
    //     }
    //     if(last_name.length < 2){
    //         setErrorMessage(prev=>({...prev,last_name:"Last Name must be at least 2 characters"}))
    //     }else{
    //         setErrorMessage(prev=>({...prev,last_name:""}))
    //         setErrorMessage("");
    //     }
    // }

    return (
        <div>
            <form>
                <div>
                    <label htmlFor='first_name'>First Name:</label>
                    <input 
                        type="text" 
                        value={first_name} 
                        name="first_name" 
                        onChange={(e)=>setFirstName(e.target.value)}/>

                        {first_name.length < 2 && first_name.length > 0 ? (
                            <p>First Name must be at least 2 characters</p>
                        ) : null}
                </div>
                <div>
                    <label htmlFor='last_name'>Last Name:</label>
                    <input 
                    type="text" 
                    value={last_name} 
                    name="last_name" 
                    onChange={(e)=>setLastName(e.target.value)}/>

                    {last_name.length < 2 && last_name.length>0?(
                        <p>Last Name must be at least 2 characters.</p>
                    ): null}
                </div>
                <div>
                    <label htmlFor='email'>Email:</label>
                    <input type="text" value={email} name="email" onChange={(e)=>setEmail(e.target.value)}/>

                    {email.length < 4 && email.length> 0 ? (
                        <p>Email must be at least 4 characters. </p>
                    ): null}
                </div>
                <div>
                    <label htmlFor='password'>Password:</label>
                    <input type="password" value={password} name="password" onChange={(e)=>setPassword(e.target.value)}/> 

                    {password.length < 8 && password.length > 0 ? (
                        <p> Password must be at least 8 characters.</p>
                    ): null}
                </div>
                <div>
                    <label htmlFor='confirmPassword'>Confirm Password:</label>
                    <input type="text" value={confirmPassword} name="confirmPassword" onChange={(e)=>setConfirmPassword(e.target.value)}/>

                    {confirmPassword !== password ? (
                        <p> Password must match </p>
                    ): null }
                </div>
            </form>

            <div className="results">
            <h3>Your Form Results</h3>
            <div>
                <label htmlFor="first_name" className='l2' >First Name:</label>{first_name}
            </div>
            <div>
                <label htmlFor="last_name" className='l2' >Last Name:</label>{last_name}
            </div>
            <div>
                <label htmlFor="email" className='l2'>Email:</label>{email}
            </div>
            <div>
                <label htmlFor="password" className='l2'>Password:</label>{password}
            </div>
            <div>
            <label htmlFor="confirmPassword" className='l2'>Confirm Password</label>{confirmPassword}
            </div>
            
        </div>
        </div>
    )
};
export default MoreForm;
