import axios from "axios"

const addCompanyDetails=(company)=>{
  const token=localStorage.getItem("token");
  const config={
    headers: {
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin':"*",
      'Authorization':`Bearer ${token}`
    }
  };
    
  return  axios
    .post("http://localhost:8087/api/v1.0/market/company/register", company,config)
    .then((response) => {
      return response.data;
    })
    .catch((error) => {
      console.log(error);
    });

}

export default addCompanyDetails;