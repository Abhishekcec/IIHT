import React from "react";
import "./homepage.component.css"
import SearchedComponent from "../searchedcompany/searchedcompany.component"
import DisplayAllCompanies from "../displayallcompanies/displayAllCompanies.component"
import AddCompany from "../addCompany/addCompany.component";
import Header from "../header/header.component";


const HomePage = () => {

    const [renderTab,setRenderTab]=React.useState("add-company");
    const [companyCode,setCompanyCode] =React.useState("");
 
    const handleCompanyCodeChange = (companyCodeValue) => {
       setCompanyCode(companyCodeValue);
     }

    return (
        <div className="main-content">
            <Header setDataToBeShown={(tabClassName)=>setRenderTab(tabClassName)} handleCompanyCodeChange={(event)=>handleCompanyCodeChange(event)}/>
            {renderTab === "list-companies" ? <DisplayAllCompanies setRenderTab={(event)=>setRenderTab(event)}/> :
             renderTab === "add-company" ? <AddCompany setRenderTab={(event)=>setRenderTab(event)}/> :
             renderTab === "search-button" ? <SearchedComponent companyCode={companyCode} setRenderTab={(event)=>setRenderTab(event)} /> : null}
        </div>
    )
}


export default HomePage;