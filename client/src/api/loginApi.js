import axios from "axios";
import api from "./api";

const adminLogin = (email, pass) => {
  // const res = axios.post("http://localhost:3345/admin/login", { email, pass });
  // return res.data;

  const res = api.post("/admin/login", { email, pass });
  return res.data;

}

export default adminLogin;