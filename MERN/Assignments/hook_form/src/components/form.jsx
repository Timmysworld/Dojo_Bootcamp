import React, {useState} from 'react';

const UseForm = (props) => {
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");

    return (
        <div>
            <form>
            <div>
                <label htmlFor="username">Username: </label> 
                <input type="text" value={username} name="username" onChange={(e)=>setUsername(e.target.value) }/>
            </div>
            <div>
                <label htmlFor="email">Email: </label>
                <input type="text" value= {email} name="email" onChange={(e)=>setEmail(e.target.value)} />
            </div>
            <div>
                <label htmlFor="password">Password </label>
                <input type="password" value={password} name="password" onChange={(e)=>setPassword(e.target.value)} />
            </div>
            <div>
                <label htmlFor="confirmPassword">Confirm Password </label>
                <input type="password" value={confirmPassword} name="confirmpassword" onChange={(e)=>setConfirmPassword(e.target.value)} />
            </div>
        </form>

        <div className="results">
            <h3>Your Form Results</h3>
            <div>
                <label htmlFor="username" className='l2' >Username:</label>{username}
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

        
        
        
    );
    

};
export default UseForm;