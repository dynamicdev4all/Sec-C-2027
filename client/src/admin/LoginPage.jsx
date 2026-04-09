import React, { useState } from 'react'
import adminLogin from '../api/loginApi';

const LoginPage = () => {
    const [email, setEmail] = useState("");
    const [pass, setPass] = useState("");


    const handleLogin = ()=>{
      const res = adminLogin(email, pass);
      if(res === "Login Success"){
        //navigate to dashboard
      }else{
        console.log(res)
      }
    }
  return (
    <div>
      <h1>Admin Login</h1>
        <form  onSubmit={handleLogin}>
            <input type="email" name="adminEmail" id="" onChange={(e)=>setEmail(e.target.value)}/>
            <input type="password" name="adminPass" id="" onChange={(e)=>setPass(e.target.value)}/>
            <button type="submit">Login Now</button>
        </form>
    </div>
  )
}

export default LoginPage