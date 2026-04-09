import { BrowserRouter, Routes, Route } from 'react-router-dom'
import './App.css'
import { useState } from 'react'
import LoginPage from './admin/LoginPage'
import RegisterPage from './admin/RegisterPage'
import AdminDashboard from './admin/AdminDashboard'

function App() {

  const [admin, setAdmin] = useState(null)

  return (

    <BrowserRouter>
      <Routes>
        <Route path='/' Component={LoginPage} />
        <Route path='/login' Component={LoginPage} />
        <Route path='/register' Component={RegisterPage} />
        <Route path='/dashboard' Component={AdminDashboard} />
      </Routes>
    </BrowserRouter>


  )
}

export default App;
