import axios from "axios"

const deleteCompanyDetails=(companyCode)=>{
  const token=localStorage.getItem("token");
  const config={
    headers: {
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin':"*",
      'Authorization':`Bearer ${token}`
    }
  };
    
  return  axios
    .delete(`http://localhost:8087/api/v1.0/market/company/delete/${companyCode}`,config)
    .then((response) => {
      return response.data;
    })
    .catch((error) => {
      console.log(error);
    });

}

export default deleteCompanyDetails;