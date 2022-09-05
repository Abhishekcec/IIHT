import React from 'react'
import "./header.component.css"
import SearchBox  from '../../shared/searchbox/searchbox.component'
import { useNavigate } from 'react-router-dom'
import axios from "axios"

const Header=(props)=>  {
  const handleHeaderClicked = (event) => {
    props.setDataToBeShown(event.target.className);
  }

  const handleCompanyCodeChange = (event) => {
    props.handleCompanyCodeChange( event.target.value );
  }

  const navigate=useNavigate();
  const handleLogout=(event)=>{
    const email=localStorage.getItem("email");
    const url=`http://localhost:8085/api/v1.0/market/user/logout/${email}`;
    axios
    .post(url)
    .then((response) => {
      if (response.data === "Logged out  successfully") {
        navigate("/");
      }else{
        alert('something went wrong while logging out')
      }
    })
    .catch((error) => {
      console.log(error);
    });
       
  }

    return (
      <>
         <div className="header-block" >
            <div className="app-logo">
              <img
                src={require("./../../assets/company-logo.png")}
                alt="company-logo"
                className='company-logo'
              />
            </div>
            <div className="add-company" onClick={(event)=>handleHeaderClicked(event)}>
               Add Company
            </div>
            <div className="list-companies" onClick={(event)=>handleHeaderClicked(event)}>
              List All Companies
            </div>
            <div className="search-company">
              <SearchBox
                onSearchChanged={(event)=>handleCompanyCodeChange(event)}
                onSearchClicked={(event)=>handleHeaderClicked(event)}
              ></SearchBox>
            </div>
            <div className="logout-btn" onClick={(event)=>handleLogout(event)}>
               Log out
            </div>
          </div>
      </>
  )
}
export default Header;