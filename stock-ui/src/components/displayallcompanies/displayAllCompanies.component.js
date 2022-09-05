import React, { useEffect } from 'react'
import getAllCompanies from "../../services/getAllCompanies.service"
import deleteCompanyDetails from "../../services/deleteCompanyDetails.service"
import "./displayAllCompanies.component.css"
import DeleteIcon  from '../../shared/delete-icon/delete-icon.component'
  
const DisplayAllCompanies =()=>{
  const [companies,setCompanies]=React.useState([]);

  useEffect(()=>{
      getAllCompanies().then((res)=>{
         setCompanies(res);
      });
  },[]);

  const deleteComapny=(companyCode)=>{
    deleteCompanyDetails(companyCode).then((res)=>{
            if(res==="Company deleted Successfully and Stocks deleted Successfully"){
              getAllCompanies().then((res)=>{
                setCompanies(res);
             });
            }
    });
  };

    return (
      <div className="all-companies-container">
            { companies?.length>0&&
              companies?.map((company) => {
                    return (
                        <div key={company.companyCode} className="company-detail-row">
                            <div>
                               {company.companyName}
                            </div>
                             
                            <div>
                            {company.companyCode}
                            </div>
                            <div>
                            {company.companyWebsite}
                            </div>
                            <div> 
                            {company.companyTurnover}
                            </div>
                            <div className="delete-icon" onClick={()=>{deleteComapny(company.companyCode)}}><DeleteIcon/></div>
                        </div>
                    );
              })
            }
      </div>
    )
  }

  export default DisplayAllCompanies;