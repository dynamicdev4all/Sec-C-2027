import React, { useEffect, useState } from 'react'

const AdminDashboard = () => {
  const [users, setUsers] = useState([
  ])

  useEffect(()=>{
    const res = api.get("/admin/getAllUsers");
    setUsers(res);
  }, [])

  return (
    <div>
      <h1>Welcome to the Admin Page</h1>
        <h2>NAME : RDEC ADMIN</h2>
        <h2>ID : rdec123M</h2>
    <div>
      <h2>Total : {users.length}</h2>
    </div>
        <table>
          <th>ID</th>
          <th>Name</th>
          <th>Email</th>
          <th>Status</th>
          <th>Action</th>
          <tbody>
            {users.map((index, user)=>{
               <tr>
              <td>{user._id}</td>
              <td>{user.name}</td>
              <td>{user.email}</td>
              <td>{user.status}</td>
              <td>
                if(user.status === true){
                  <button>Un-Ban</button>
                }else if(user.status === false){
                  <button>Ban</button>
                }
                
              </td>
              <td>Button</td>
            </tr>
            })}
          </tbody>
        </table>
    </div>
  )
}

export default AdminDashboard