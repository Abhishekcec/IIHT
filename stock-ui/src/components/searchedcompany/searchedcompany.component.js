import React from "react";
import getCompanyDetailsByCode from "../../services/getCompanyDetailsByCode.service";
import getStockDetailsByDate from "../../services/getStockDetailsByDate.service";
import "./searchedcompany.component.css"

const SearchedComponent = (props) => {

    const [stockDetails, setStockDetails] = React.useState();
    const [company, setCompany] = React.useState();
    const [startDate, setStartDate] = React.useState("");
    const [endDate, setEndDate] = React.useState("");
    const { companyCode } = props;


    React.useEffect(() => {
        getCompanyDetailsByCode(companyCode).then((res) => {
            setCompany(res?.company);
            setStockDetails(res?.stockDetails);
        })
    }, []);

    
    React.useEffect(() => {
        if(startDate.length===16&&endDate.length===16)
        getStockDetailsByDate(companyCode,startDate,endDate).then((res) => {
           if(Object.keys(res).length>0)
            setStockDetails(res);
        })
    }, [startDate,endDate]);


    const handleDateChange = (event) => {
        if (event.target.name ==="start-date") {
            setStartDate(event.target.value);
        }else{
            setEndDate(event.target.value);
        }

    }



    return (
        <div className="searched-company-component">
            <div className="company-code-row">
                <div className="company-code-label">Company Code</div>
                <div className="company-code-value">{company?.companyCode}</div>
            </div>
            <div className="company-name-row">
                <div className="company-name-label">Company Name</div>
                <div className="company-name-value">{company?.companyName}</div>
            </div>
            <div className="stock-range-row">
                <div className="from-label">
                    From
                </div>
                <div className="start-date">
                    <input
                        className="start-date-input-field"
                        name="start-date"
                        type="datetime-local"
                        min={"01/01/1900"}
                        max={new Date(Date.now()).toLocaleString().split(",")[0]}
                        onChange={handleDateChange}
                        value={startDate}
                    />
                </div>
                <div className="to-label">
                    to
                </div>
                <div className="end-date">
                    <input
                        className="end-date-input-field"
                        name="end-date"
                        type="datetime-local"
                        min={"01/01/1900"}
                        max={new Date(Date.now()).toLocaleString().split(",")[0]}
                        onChange={handleDateChange}
                        value={endDate}
                    />
                </div>
            </div>
            <div className="stock-table">
                <div className="stock-table-heading-row">
                    <div className="stock-price">Stock Price</div>
                    <div className="stock-date">Date</div>
                    <div className="stock-time">Time</div>
                </div>
                {
                    stockDetails?.stocks?.length>0&&
                    stockDetails?.stocks?.map((stock, index) => {
                        return <div key={index} className="stock-detail-row">
                            <div className="stock-price">{stock?.price}</div>
                            <div className="stock-date">{stock?.date?.split("T")[0]}</div>
                            <div className="stock-time">{stock?.date?.split("T")[1]}</div>
                        </div>
                    })
                }
            </div>
            <div className="stock-overall-details">
                <div className="min-row">
                    <div className="min-label">MIN</div>
                    <div className="min-value">{stockDetails?.minimumStockPrice}</div>
                </div>
                <div className="max-row">
                    <div className="max-label">MAX</div>
                    <div className="max-value">{stockDetails?.maximumStockPrice}</div>
                </div>
                <div className="avg-row">
                    <div className="avg-label">AVG</div>
                    <div className="avg-value">{stockDetails?.averageStockPrice}</div>
                </div>
            </div>
        </div>
    );
}
export default SearchedComponent;